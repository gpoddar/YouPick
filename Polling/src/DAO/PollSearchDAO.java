package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.Poll;
import util.DBUtil;

public class PollSearchDAO {

	Connection connection;
	public ArrayList<Poll> getSearchPolls(String searchString)
	{
		
        ArrayList<Poll> polls=new ArrayList<Poll>();
		DBUtil dbutil=new DBUtil();
		PreparedStatement pst=null;
		ResultSet resultSet=null;
		try{
			connection=dbutil.get();
			if(searchString.length()>=10)
			{
			if(searchString.substring(0,9).toLowerCase().equals("category:"))
			{
				pst = connection.prepareStatement("select * from polls join poll_category on polls.category_id=poll_category.category_id where category_name like ?");
				pst.setString(1,searchString.substring(9,searchString.length()));
			}
				else
			{
			pst = connection.prepareStatement("select * from polls join poll_category on polls.category_id=poll_category.category_id where title like ? or description like ? or optionone like ? or optiontwo like ? or optionthree like ? or optionfour like ?");
			pst.setString(1,"%"+searchString+"%");
			pst.setString(2,"%"+searchString+"%");
			pst.setString(3,"%"+searchString+"%");
			pst.setString(4,"%"+searchString+"%");
			pst.setString(5,"%"+searchString+"%");
			pst.setString(6,"%"+searchString+"%");
			}
			}
			else
			{
				pst = connection.prepareStatement("select * from polls join poll_category on polls.category_id=poll_category.category_id where title like ? or description like ? or optionone like ? or optiontwo like ? or optionthree like ? or optionfour like ?");
				pst.setString(1,"%"+searchString+"%");
				pst.setString(2,"%"+searchString+"%");
				pst.setString(3,"%"+searchString+"%");
				pst.setString(4,"%"+searchString+"%");
				pst.setString(5,"%"+searchString+"%");
				pst.setString(6,"%"+searchString+"%");
				
				
			}
			
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
