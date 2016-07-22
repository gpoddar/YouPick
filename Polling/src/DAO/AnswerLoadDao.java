package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.Answer;
import util.DBUtil;

public class AnswerLoadDao {

	Connection connection;
	public Answer getAnswer(int poll_id,int selectedOption,long usrid)
	{
		Answer answer=new Answer();
		DBUtil dbutil=new DBUtil();
		PreparedStatement pst=null;
		ResultSet resultSet=null;
		try{
			connection=dbutil.get();
			pst= connection.prepareStatement("insert into user_answers(poll_id,usr_id,answer) values(?,?,?)");
			pst.setInt(1,poll_id);
			pst.setLong(2,usrid);
			pst.setInt(3,selectedOption);
			int status = pst.executeUpdate();
			pst.close();
			if(status==0)
			{
				//to do
			}
			
			status=-1;
			
			switch(selectedOption)
			{
			case 1:
				pst= connection.prepareStatement("UPDATE poll_answers SET optionA = optionA + 1  WHERE poll_id = ?");
				pst.setInt(1,poll_id);
				status=pst.executeUpdate();
				pst.close();
				break;
			case 2:
				pst= connection.prepareStatement("UPDATE poll_answers SET optionB = optionB + 1  WHERE poll_id = ?");
				pst.setInt(1,poll_id);
				status=pst.executeUpdate();
				pst.close();
				break;
			case 3:
				pst= connection.prepareStatement("UPDATE poll_answers SET optionC = optionC + 1  WHERE poll_id = ?");
				pst.setInt(1,poll_id);
				status=pst.executeUpdate();
				pst.close();
				break;
			case 4:
				pst= connection.prepareStatement("UPDATE poll_answers SET optionD = optionD + 1  WHERE poll_id = ?");
				pst.setInt(1,poll_id);
				status=pst.executeUpdate();
				pst.close();
				break;
			}
			if(status==0||status==-1)
			{
				//to do
			}
			
			pst=connection.prepareStatement("UPDATE polls SET votes = votes + 1  WHERE poll_id = ?");
			pst.setInt(1,poll_id);
			status=pst.executeUpdate();
			pst.close();
			
			
			pst=connection.prepareStatement("select * from poll_answers where poll_id=?");
			pst.setInt(1,poll_id);
			resultSet=pst.executeQuery();
			while(resultSet.next())
			{
				answer.setbinary(resultSet.getBoolean("isbinary"));
				answer.setOptionA(resultSet.getDouble("optionA"));
				answer.setOptionB(resultSet.getDouble("optionB"));
				answer.setOptionC(resultSet.getDouble("optionC"));
				answer.setOptionD(resultSet.getDouble("optionD"));
				answer.setPoll_id(poll_id);
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
		
		return answer;
			
	}
	
	
	
	
	
	public Answer getAnswer(int poll_id,long usrid)
	{
		Answer answer=new Answer();
		DBUtil dbutil=new DBUtil();
		PreparedStatement pst=null;
		ResultSet resultSet=null;
		try{
			connection=dbutil.get();
			pst=connection.prepareStatement("select * from poll_answers where poll_id=?");
			pst.setInt(1,poll_id);
			resultSet=pst.executeQuery();
			while(resultSet.next())
			{
				answer.setbinary(resultSet.getBoolean("isbinary"));
				answer.setOptionA(resultSet.getDouble("optionA"));
				answer.setOptionB(resultSet.getDouble("optionB"));
				answer.setOptionC(resultSet.getDouble("optionC"));
				answer.setOptionD(resultSet.getDouble("optionD"));
				answer.setPoll_id(poll_id);
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
		
		return answer;
			
	}
	
	
	
	
	public ArrayList<Answer> getAnswers(long usrid)
	{
		ArrayList<Answer> answers=new ArrayList<Answer>();
		
		DBUtil dbutil=new DBUtil();
		PreparedStatement pst=null;
		ResultSet resultSet=null;
		try{
			connection=dbutil.get();
			pst=connection.prepareStatement("SELECT * FROM poller.poll_answers left join user_answers on poll_answers.poll_id=user_answers.poll_id where usr_id=?");
			pst.setLong(1,usrid);
			resultSet=pst.executeQuery();
			while(resultSet.next())
			{
				Answer answer=new Answer();
				answer.setbinary(resultSet.getBoolean("isbinary"));
				answer.setOptionA(resultSet.getDouble("optionA"));
				answer.setOptionB(resultSet.getDouble("optionB"));
				answer.setOptionC(resultSet.getDouble("optionC"));
				answer.setOptionD(resultSet.getDouble("optionD"));
				answer.setPoll_id(resultSet.getLong("poll_id"));
				answer.setUseranswer(resultSet.getInt("answer"));
				answers.add(answer);
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
		
		return answers;
			
	}
	
	
}
