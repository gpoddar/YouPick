package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.Poll;
import util.DBUtil;

public class PollViewDAO {
	
	Connection connection;
	public ArrayList<Poll> getViewPolls()
	{
		
        ArrayList<Poll> polls=new ArrayList<Poll>();
		DBUtil dbutil=new DBUtil();
		PreparedStatement pst=null;
		ResultSet resultSet=null;
		try{
			connection=dbutil.get();
			pst = connection.prepareStatement("select * from polls join poll_category on polls.category_id=poll_category.category_id order by alive ");
			resultSet = pst.executeQuery();
			while(resultSet.next()){
				Poll poll=new Poll();
				poll.setTitle(resultSet.getString("title"));
				poll.setPollId(resultSet.getInt("poll_id"));
				poll.setScore(resultSet.getDouble("score"));
				poll.setCreatedAt(resultSet.getDate("alive"));
				poll.setCategoryName(resultSet.getString("category_name"));
				poll.setVotes(resultSet.getLong("votes"));
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
