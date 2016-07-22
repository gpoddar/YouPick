
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.User;
import util.DBUtil;

public class UserDAO {

    Connection connection;
    int status = -1;

    public void resetPassword(String email,String newPass)
    {

        DBUtil dbutil = new DBUtil();
        PreparedStatement pst = null;
        try {
            connection = dbutil.get();
            pst = connection.prepareStatement("update users set password=? where emailID like ?");
            pst.setString(1, newPass);
            pst.setString(2,email);
            pst.executeUpdate();
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
    	
    }
    
    public boolean isAnswered(long pollid,long userid)
    {
    	boolean isAnswered=false;
    	 Double userID = null;
         ResultSet result1;
         DBUtil dbutil = new DBUtil();
         PreparedStatement pst = null;
         try {
             connection = dbutil.get();
             pst = connection.prepareStatement("select * from user_answers where poll_id = ? AND usr_id = ?");
             pst.setLong(1, pollid);
             pst.setLong(2, userid);
             result1 = pst.executeQuery();
             while(result1.next())
             {
             	isAnswered=true;
             }
 
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

         return isAnswered;
    }
    
    
    public int updateUserProfile(User user) {

        DBUtil dbutil = new DBUtil();
        PreparedStatement pst = null;
        try {
            connection = dbutil.get();
            pst = connection.prepareStatement("update users set age = ?, sex = ?, name = ?, locationID = ? , schoolID = ?, emailID = ? where id = ?");
            pst.setInt(1, user.getAge());
            pst.setString(2, user.getSex());
            pst.setString(3, user.getFullName());
            pst.setDouble(4, user.getAreaID());
            pst.setDouble(5, user.getSchoolID());
            pst.setString(6, user.getEmailID());
            pst.setDouble(7, user.getId());
            status = pst.executeUpdate();
            pst.close();
            if (status == 0) {
                //to do
            }

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

    public long createUserProfile(User user) {

        DBUtil dbutil = new DBUtil();
        PreparedStatement pst = null;
        PreparedStatement pst1 = null;
        long user_id=-1;
        ResultSet resultset=null;
        try {
            connection = dbutil.get();
            pst = connection.prepareStatement("insert into users (emailID,password,fb_userID,age,sex,name,locationID, schoolID) values(?,?,?,?,?,?,?,?)");
            pst.setString(1, user.getEmailID());
            pst.setString(2, user.getPassword());
            pst.setString(3, user.getFb_userID());
            pst.setDouble(4, user.getAge());
            pst.setString(5, user.getSex());
            pst.setString(6, user.getFullName());
            pst.setLong(7, 1);
            pst.setLong(8, 1);
            
            status = pst.executeUpdate();
            pst.close();
            if (status == 1) {
              
            pst1=connection.prepareStatement("select id from users where fb_userId=?");
            pst1.setString(1, user.getFb_userID());
            resultset=pst1.executeQuery();
            while(resultset.next())
            {
            	user_id=resultset.getLong("id");
            }
            	
            	
            }

            
            
            
            pst1.close();
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

        return user_id;
    }

    public Double findUserByEmailID(User user) {

        Double userID = null;
        ResultSet result1;
        DBUtil dbutil = new DBUtil();
        PreparedStatement pst = null;
        try {
            connection = dbutil.get();
            pst = connection.prepareStatement("select id from users where emailID like ? AND password like ?");
            pst.setString(1, user.getEmailID());
            pst.setString(2, user.getPassword());
            result1 = pst.executeQuery();
            while (result1.next()) {
                userID = result1.getDouble("id");
            }
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

        return userID;
    }

    public Double findUserByFbUserID(User user) {

        Double userID = null;

        DBUtil dbutil = new DBUtil();
        PreparedStatement pst = null;
        try {
            connection = dbutil.get();
            pst = connection.prepareStatement("select id from users where fb_userID like ?");
            pst.setString(1, user.getFb_userID());
            ResultSet result = pst.executeQuery();
            while (result.next()) {
                userID = result.getDouble("id");
            }
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
        return userID;
    }

    public User getUserInfo(User user) {

        User userInfo = new User();

        DBUtil dbutil = new DBUtil();
        PreparedStatement pst = null;
        try {
            connection = dbutil.get();
            pst = connection.prepareStatement("select * from users where id = ?");
            pst.setDouble(1, user.getId());
            ResultSet result = pst.executeQuery();
            while (result.next()) {
                userInfo.setAge(result.getInt("age"));
                userInfo.setSex(result.getString("sex"));
                userInfo.setFullName(result.getString("name"));
                userInfo.setEmailID(result.getString("emailID"));
                userInfo.setAreaID(result.getDouble("locationID"));
                userInfo.setSchoolID(result.getDouble("schoolID"));
            }
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
        return userInfo;
    }

}
