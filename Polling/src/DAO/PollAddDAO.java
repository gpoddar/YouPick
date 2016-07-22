
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.Category;
import dto.Poll;
import util.DBUtil;

public class PollAddDAO {

    Connection connection;
    int status = -1;
    int imageName;

    public int getImageName() {
        DBUtil dbutil = new DBUtil();
        PreparedStatement pst = null;
        ResultSet resultSet = null;
        try {
            connection = dbutil.get();

            pst = connection.prepareStatement("select max(poll_id) as imageName from polls");
            resultSet = pst.executeQuery();
            while (resultSet.next())
                imageName = resultSet.getInt("imageName");
            imageName++;
            pst.close();
            resultSet.close();
            dbutil.close(connection);

        }
        catch (SQLException sqlException) {
            sqlException.printStackTrace();

        }
        catch (ClassNotFoundException e) {

            e.printStackTrace();
        }
        finally {

            dbutil.close(connection);
            try {
                pst.close();
                resultSet.close();
            }
            catch (SQLException sqlException) {

                sqlException.printStackTrace();
            }

        }

        return imageName;

    }

    public ArrayList<Category> getCategories() {
        ArrayList<Category> categories = new ArrayList<Category>();
        DBUtil dbutil = new DBUtil();
        PreparedStatement pst = null;
        ResultSet resultSet = null;
        try {
            connection = dbutil.get();
            pst = connection.prepareStatement("select * from poll_category where visibility=1");
            resultSet = pst.executeQuery();

            while (resultSet.next()) {
                Category category = new Category();
                category.setCategory_id(resultSet.getInt("category_id"));
                category.setCategory_name(resultSet.getString("category_name"));
                categories.add(category);
            }
            pst.close();
            resultSet.close();
            dbutil.close(connection);

        }
        catch (SQLException sqlException) {
            sqlException.printStackTrace();

        }
        catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        finally {

            dbutil.close(connection);
            try {
                pst.close();
                resultSet.close();
            }
            catch (SQLException sqlException) {

                sqlException.printStackTrace();
            }

        }

        return categories;

    }

    public int addPoll(Poll poll) {

        DBUtil dbutil = new DBUtil();
        PreparedStatement pst = null;
        PreparedStatement pst1 = null;
        ResultSet resultSet = null;
        long fbcommentid = -1;
        try {
            connection = dbutil.get();
            pst = connection.prepareStatement("select max(poll_id) as fbcommentid from polls");
            resultSet = pst.executeQuery();
            while (resultSet.next())
                fbcommentid = resultSet.getLong("fbcommentid");
            pst.close();
            fbcommentid++;
            pst1 = connection
                    .prepareStatement("insert into polls(title,description,imgsrc,optionone,optiontwo,optionthree,optionfour,category_id,alive,FBcomment,isbinary) values(?,?,?,?,?,?,?,?,now(),?,?)");
            pst1.setString(1, poll.getTitle());
            pst1.setString(2, poll.getDescription());
            pst1.setString(3, poll.getImgSrc());
            pst1.setString(4, poll.getOptionOne());
            pst1.setString(5, poll.getOptiontwo());
            pst1.setString(6, poll.getOptionThree());
            pst1.setString(7, poll.getOptionFour());
            pst1.setLong(8, poll.getCategory());
            pst1.setLong(9, fbcommentid);
            pst1.setInt(10, poll.getBinary());
            status = pst1.executeUpdate();
            pst1.close();
            if (status == 0) {
                //to do
            }

            int pollid = -1;
            pst = connection.prepareStatement("select max(poll_id) as 'pollid' from polls");
            resultSet = pst.executeQuery();
            while (resultSet.next()) {
                pollid = resultSet.getInt("pollid");

            }

            pst = connection.prepareStatement("insert into poll_answers(poll_id,optionA,optionB,optionC,optionD) values(?,?,?,?,?)");
            pst.setInt(1, pollid);
            pst.setInt(2, 0);
            pst.setInt(3, 0);
            pst.setInt(4, 0);
            pst.setInt(5, 0);

            status = pst.executeUpdate();

            pst.close();
            dbutil.close(connection);

        }
        catch (SQLException sqlException) {
            sqlException.printStackTrace();

        }
        catch (ClassNotFoundException e) {

            e.printStackTrace();
        }
        finally {

            dbutil.close(connection);
            try {
                pst.close();

            }
            catch (SQLException sqlException) {

                sqlException.printStackTrace();
            }

        }

        return status;

    }

    public int editPoll(Poll poll) {

        DBUtil dbutil = new DBUtil();
        PreparedStatement pst1 = null;
        try {
            connection = dbutil.get();
            pst1 = connection.prepareStatement(
                    "update polls set title = ?,description = ?,imgsrc = ?,optionone = ?,optiontwo = ?,optionthree = ?,optionfour = ?,category_id = ?,isbinary = ? where poll_id = ?");
            pst1.setString(1, poll.getTitle());
            pst1.setString(2, poll.getDescription());
            pst1.setString(3, poll.getImgSrc());
            pst1.setString(4, poll.getOptionOne());
            pst1.setString(5, poll.getOptiontwo());
            pst1.setString(6, poll.getOptionThree());
            pst1.setString(7, poll.getOptionFour());
            pst1.setLong(8, poll.getCategory());
            pst1.setInt(9, poll.getBinary());
            pst1.setDouble(10, poll.getPollId());
            status = pst1.executeUpdate();
            pst1.close();
            if (status == 0) {
                //to do
            }

            dbutil.close(connection);

        }
        catch (SQLException sqlException) {
            sqlException.printStackTrace();

        }
        catch (ClassNotFoundException e) {

            e.printStackTrace();
        }
        finally {

            dbutil.close(connection);
            try {
                pst1.close();

            }
            catch (SQLException sqlException) {

                sqlException.printStackTrace();
            }

        }

        return status;

    }
}
