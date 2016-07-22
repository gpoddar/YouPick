package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.Poll;
import util.DBUtil;

public class SearchPollDAO {
	
	
	

	Connection connection;
	public ArrayList<Poll> fetchSearchPolls(String searchString,long userId)
	{
		
        ArrayList<Poll> polls=new ArrayList<Poll>();
		DBUtil dbutil=new DBUtil();
		PreparedStatement pst=null;
		ResultSet resultSet=null;
		try{
			connection=dbutil.get();
			pst = connection.prepareStatement("select * from polls where poll_id not in (select poll_id from user_answers where usr_id=?) and (title like ? or description like ? or optionone like ? or optiontwo like ? or optionthree like ? or optionfour like ?)");
			pst.setLong(1,userId);
			pst.setString(2,"%"+searchString+"%");
			pst.setString(3,"%"+searchString+"%");
			pst.setString(4,"%"+searchString+"%");
			pst.setString(5,"%"+searchString+"%");
			pst.setString(6,"%"+searchString+"%");
			pst.setString(7,"%"+searchString+"%");
			resultSet = pst.executeQuery();
			
			while(resultSet.next()){
				Poll poll=new Poll();
				poll.setTitle(resultSet.getString("title"));
				poll.setDescription(resultSet.getString("Description"));
				poll.setFbCommentId(resultSet.getString("FBcomment"));
				poll.setImgSrc(resultSet.getString("imgsrc"));
				poll.setOptionFour(resultSet.getString("optionfour"));
				poll.setOptionOne(resultSet.getString("optionone"));
				poll.setOptionThree(resultSet.getString("optionthree"));
				poll.setOptiontwo(resultSet.getString("optiontwo"));
				poll.setPollId(resultSet.getInt("poll_id"));
				poll.setTagged(resultSet.getString("tagged"));
				poll.setBinary(resultSet.getInt("isbinary"));
				polls.add(poll);
			}
			pst.close();
			resultSet.close();
			dbutil.close(connection);
			
		}
		catch(SQLException sqlException){
			sqlException.printStackTrace();
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} 
		finally{
			
			dbutil.close(connection);
			try {
				pst.close();
				resultSet.close();
			} catch (SQLException sqlException) {
				
				sqlException.printStackTrace();
			}
			
		}
		
		return polls;
		
		
	}

}
