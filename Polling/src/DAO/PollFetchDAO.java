package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



import dto.Poll;
import util.DBUtil;

public class PollFetchDAO {
	
	Connection connection;
	public ArrayList<Poll> fetchPolls(int category,ArrayList<String>loadedPolls,long userid)
	{
		

        ArrayList<Poll> polls=new ArrayList<Poll>();
		DBUtil dbutil=new DBUtil();
		PreparedStatement pst=null;
		ResultSet resultSet=null;
		try{
			connection=dbutil.get();
			if(category==-1&&loadedPolls.size()==0)
			{
				pst = connection.prepareStatement("select * from polls where poll_id not in(select poll_id from user_answers where usr_id=?) order by polls.score limit 10");
				pst.setLong(1,userid);
				resultSet = pst.executeQuery();
			}
			else if(category==-1&&loadedPolls.size()!=0)
			{
				String tempPst="select * from polls where polls.poll_id not in (select poll_id from user_answers where usr_id=?) and polls.poll_id not in (";
				for(String s:loadedPolls)
				{
					tempPst+="?,";
				}
				tempPst=tempPst.substring(0,(tempPst.length()-1));
				tempPst+=") order by polls.score limit 10";
			
				pst = connection.prepareStatement(tempPst);
				pst.setLong(1,userid);
				int tempPstCount=2;
				
				for(String s:loadedPolls)
				{
					pst.setLong(tempPstCount,(long)(Double.parseDouble(s)));
					tempPstCount++;
				}

				resultSet = pst.executeQuery();
			}
			
			else if(loadedPolls.size()!=0)
			{
				String tempPst="select * from polls where polls.poll_id not in (select poll_id from user_answers where usr_id=?) and category_id=? and  polls.poll_id not in (";
				for(String s:loadedPolls)
				{
					tempPst+="?,";
				}
				tempPst=tempPst.substring(0,(tempPst.length()-1));
				tempPst+=") order by polls.score limit 10";
			
				pst = connection.prepareStatement(tempPst);
				pst.setLong(1,userid);
				pst.setLong(2,category);
				int tempPstCount=3;
				
				for(String s:loadedPolls)
				{
					pst.setLong(tempPstCount,(long)(Double.parseDouble(s)));
					tempPstCount++;
				}

				resultSet = pst.executeQuery();
				
				
				
				
			}
			else
			{
				pst= connection.prepareStatement("select * from polls where polls.poll_id not in (select poll_id from user_answers where usr_id=?) and category_id=? order by polls.score limit 10");
				pst.setLong(1,userid);
				pst.setLong(2,category);
				resultSet = pst.executeQuery();
			}
			while(resultSet.next()){
				Poll poll=new Poll();
				poll.setTitle(resultSet.getString("title"));
				poll.setVotes(resultSet.getLong("votes"));
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
	
	
	
	public Poll getPoll(long poll_id)
	{
		
		

		DBUtil dbutil=new DBUtil();
		PreparedStatement pst=null;
		ResultSet resultSet=null;
		Poll poll=null;
		try{
			connection=dbutil.get();
				pst = connection.prepareStatement("select * from polls where poll_id =?");
				pst.setLong(1,poll_id);
				resultSet = pst.executeQuery();
			
			while(resultSet.next()){
				poll=new Poll();
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
		
		return poll;
		
		
		
		
	}
	
	
	
	
	public ArrayList<Poll> fetchIndexPolls(int category,String loadedpolls)
	{
		String temp[]=loadedpolls.split(",");
		
		ArrayList<String> loadedPolls=new ArrayList<String>();
		
		if(!loadedpolls.equals(""))
		{	
			for(int i=0;i<temp.length;i++)
			{
				loadedPolls.add(temp[i]);
			}
		}
		
		
		ArrayList<Poll> polls=new ArrayList<Poll>();
		DBUtil dbutil=new DBUtil();
		PreparedStatement pst=null;
		ResultSet resultSet=null;
		try{
			connection=dbutil.get();
			if(category==-1&&loadedPolls.size()==0)
			{
				pst = connection.prepareStatement("select * from polls order by polls.score limit 10");
				resultSet = pst.executeQuery();
			}
			else if(category==-1&&loadedPolls.size()!=0)
			{
				String tempPst="select * from polls where polls.poll_id not in (";
				for(String s:loadedPolls)
				{
					tempPst+="?,";
				}
				tempPst=tempPst.substring(0,(tempPst.length()-1));
				tempPst+=") order by polls.score limit 10";
			
				pst = connection.prepareStatement(tempPst);
				int tempPstCount=1;
				
				for(String s:loadedPolls)
				{
					pst.setLong(tempPstCount,(long)(Double.parseDouble(s)));
					tempPstCount++;
				}

				resultSet = pst.executeQuery();
			}
			
			else if(loadedPolls.size()!=0)
			{
				String tempPst="select * from polls where category_id=? and polls.poll_id not in (";
				for(String s:loadedPolls)
				{
					tempPst+="?,";
				}
				tempPst=tempPst.substring(0,(tempPst.length()-1));
				tempPst+=") order by polls.score limit 10";
			
				pst = connection.prepareStatement(tempPst);
				pst.setLong(1,category);
				int tempPstCount=2;
				
				for(String s:loadedPolls)
				{
					pst.setLong(tempPstCount,(long)(Double.parseDouble(s)));
					tempPstCount++;
				}

				resultSet = pst.executeQuery();
				
				
				
				
			}
			else
			{
				pst= connection.prepareStatement("select * from polls where category_id=? order by polls.score limit 10");
				pst.setLong(1,category);
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
