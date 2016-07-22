package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.Poll;
import util.DBUtil;

public class AnsweredDAO {

	Connection connection;
	public ArrayList<Poll> fetchPolls(int category,long userid)
	{
		

        ArrayList<Poll> polls=new ArrayList<Poll>();
		DBUtil dbutil=new DBUtil();
		PreparedStatement pst=null;
		ResultSet resultSet=null;
		try{
			connection=dbutil.get();
			if(category==-1)
			{
				pst = connection.prepareStatement("select * from polls left join user_answers on polls.poll_id=user_answers.poll_id where usr_id=?");
				pst.setLong(1,userid);
				resultSet = pst.executeQuery();
			}
			else
			{
				pst= connection.prepareStatement("select * from polls left join user_answers on polls.poll_id=user_answers.poll_id where usr_id=? and category_id=?");
				pst.setLong(1,userid);
				pst.setLong(2,category);
				resultSet = pst.executeQuery();
			}
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
				poll.setUserAnswer(resultSet.getInt("answer"));
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
