package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.Area;
import dto.Poll;
import dto.PollStat;
import dto.University;
import dto.UserAge;
import util.DBUtil;

public class PollStatsDAO {
	
	
	Connection connection;
	PollStat pollStat=null;
	public PollStat getStats(int poll_id)
	{
		
        ArrayList<Poll> polls=new ArrayList<Poll>();
		DBUtil dbutil=new DBUtil();
		PreparedStatement pst=null;
		PreparedStatement pst2=null;
		PreparedStatement pst3=null;
		PreparedStatement pst4=null;
		ResultSet resultSet=null;
		ResultSet resultSet2=null;
		ResultSet resultSet3=null;
		ResultSet resultSet4=null;
		try{
			connection=dbutil.get();
			
				pst= connection.prepareStatement("select * from poll_answers where poll_id=?");
				pst.setInt(1,poll_id);
				resultSet = pst.executeQuery();
			
				while(resultSet.next()){
				pollStat=new PollStat();
				long optionA=resultSet.getInt("optionA");
				long optionB=resultSet.getInt("optionB");
				long optionC=resultSet.getInt("optionC");
				long optionD=resultSet.getInt("optionD");
				
				pollStat.setVotes(optionA+optionB+optionC+optionD);
				pollStat.setOptionA(optionA);
				pollStat.setOptionB(optionB);
				pollStat.setOptionC(optionC);
				pollStat.setOptionD(optionD);
			
				
				long max = optionA;
				String maxChar="A";

			    if (optionB > max)
			    {
			        max = optionB;
			        maxChar="B";
			        
			    }
			    if (optionC > max)
			    {
			        max = optionC;
			        maxChar="C";
			    }
			    if (optionD > max)
			    {
			        maxChar = "D";
			    }
			    
				pollStat.setOption(maxChar);
				


			}
				pst.close();
				resultSet.close();
			
			
			pst2=connection.prepareStatement("select count(*) as male from user_answers join users on usr_id=id where (sex like '%Male%' or sex like '%male%') and poll_id=?");
			pst2.setInt(1,poll_id);
			resultSet2 = pst2.executeQuery();
		
			while(resultSet2.next()){
			pollStat.setMale(resultSet2.getLong("male"));   

			}				
				
				
			pst2.close();
			resultSet2.close();
			
			
			
			pst3=connection.prepareStatement("select count(*) as female from user_answers join users on usr_id=id where (sex like '%Female%' or sex like '%female%') and poll_id=?");
			pst3.setInt(1,poll_id);
			resultSet3 = pst3.executeQuery();
		
			while(resultSet3.next()){
			pollStat.setFemale(resultSet3.getLong("female"));   

			}	
				
			pst3.close();
			resultSet3.close();
			
			
			ArrayList<UserAge> ages=new ArrayList<UserAge>();
			
			
			pst4=connection.prepareStatement("select age,count(age) as agecount from user_answers join users on usr_id=id where (sex like '%Male%' or sex like '%male%') and poll_id=? group by age order by age");
			pst4.setInt(1,poll_id);
			resultSet4 = pst4.executeQuery();
		
			while(resultSet4.next()){
				UserAge ua=new UserAge();
				ua.setAge(resultSet4.getInt("age"));
				ua.setNumber(resultSet4.getInt("agecount"));
			 ages.add(ua);

			}	
			pollStat.setAges(ages);  	
			pst3.close();
			resultSet3.close();
			
			
			
			
			dbutil.close(connection);
			
		}
		catch(SQLException sqlException){
			sqlException.printStackTrace();
			try {
				pst.close();
				pst2.close();
				pst3.close();
				pst4.close();
				resultSet.close();
				resultSet2.close();
				resultSet3.close();
				resultSet4.close();
			} catch (SQLException sqlException1) {
				
				sqlException.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} 
		finally{
			
			dbutil.close(connection);
			
		}
		
		return pollStat;
		
		
	}
	
	public ArrayList<Area> getAreaStats(int poll_id)
	{
		ArrayList<Area> arealist=new ArrayList<Area>();
	        ResultSet result1;
	        DBUtil dbutil = new DBUtil();
	        PreparedStatement pst = null;
	        try {
	            connection = dbutil.get();
	            pst = connection.prepareStatement("select area_name,count(area_name) as countno from user_answers join users join poll_area on usr_id=id and locationID=area_id where poll_id=? group by area_name");
	            pst.setInt(1, poll_id);
	            result1 = pst.executeQuery();
	            while (result1.next()) {
	            	Area area=new Area();
	            	area.setId((result1.getInt("countno")));
	            	area.setName((result1.getString("area_name")));
	                arealist.add(area);
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

	        return arealist;
	}
	
	
	public ArrayList<University> getUnivStats(int poll_id)
	{
		ArrayList<University> univlist=new ArrayList<University>();
	        ResultSet result1;
	        DBUtil dbutil = new DBUtil();
	        PreparedStatement pst = null;
	        try {
	            connection = dbutil.get();
	            pst = connection.prepareStatement("select school_name,count(school_name) as countno from user_answers join users join poll_school on usr_id=id and schoolID=school_id where poll_id=? group by school_name");
	            pst.setInt(1, poll_id);
	            result1 = pst.executeQuery();
	            while (result1.next()) {
	            	University univ=new University();
	            	univ.setId((result1.getInt("countno")));
	            	univ.setName((result1.getString("school_name")));
	                univlist.add(univ);
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

	        return univlist;
	}
	
	
	public PollStat getMaleVotes(long poll_id)
	{
		PollStat pollstat=new PollStat();
        ResultSet result1;
        DBUtil dbutil = new DBUtil();
        PreparedStatement pst = null;
        try {
            connection = dbutil.get();
            pst = connection.prepareStatement("select answer,count(answer) as mycount from user_answers join users on usr_id=id where (sex like '%Male%' or sex like '%male%') and poll_id=? group by answer");
            pst.setLong(1, poll_id);
            result1 = pst.executeQuery();
            while (result1.next()) {
              if(result1.getLong("answer")==1)
              {
            	pollstat.setOptionA(result1.getLong("mycount"));  
              }
              if(result1.getLong("answer")==2)
              {
            	pollstat.setOptionB(result1.getLong("mycount"));  
              }
              if(result1.getLong("answer")==3)
              {
            	  pollstat.setOptionC(result1.getLong("mycount"));    
              }
              if(result1.getLong("answer")==4)
              {
            	  pollstat.setOptionD(result1.getLong("mycount"));  
              }
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

        return pollstat;
	}
	
	public PollStat getFemaleVotes(long poll_id)
	{
		PollStat pollstat=new PollStat();
        ResultSet result1;
        DBUtil dbutil = new DBUtil();
        PreparedStatement pst = null;
        try {
            connection = dbutil.get();
            pst = connection.prepareStatement("select answer,count(answer) as mycount from user_answers join users on usr_id=id where (sex like '%Female%' or sex like '%female%') and poll_id=? group by answer");
            pst.setLong(1, poll_id);
            result1 = pst.executeQuery();
            while (result1.next()) {
              if(result1.getLong("answer")==1)
              {
            	pollstat.setOptionA(result1.getLong("mycount"));  
              }
              if(result1.getLong("answer")==2)
              {
            	pollstat.setOptionB(result1.getLong("mycount"));  
              }
              if(result1.getLong("answer")==3)
              {
            	  pollstat.setOptionC(result1.getLong("mycount"));    
              }
              if(result1.getLong("answer")==4)
              {
            	  pollstat.setOptionD(result1.getLong("mycount"));  
              }
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

        return pollstat;
	}
	
	
	public PollStat getAgeVotes(long poll_id,int age)
	{
		PollStat pollstat=new PollStat();
        ResultSet result1;
        DBUtil dbutil = new DBUtil();
        PreparedStatement pst = null;
        try {
            connection = dbutil.get();
            pst = connection.prepareStatement("select answer,count(answer) as mycount from user_answers join users on usr_id=id where age=? and poll_id=? group by answer");
            pst.setInt(1,age);
            pst.setLong(2, poll_id);
            result1 = pst.executeQuery();
            while (result1.next()) {
              if(result1.getLong("answer")==1)
              {
            	pollstat.setOptionA(result1.getLong("mycount"));  
              }
              if(result1.getLong("answer")==2)
              {
            	pollstat.setOptionB(result1.getLong("mycount"));  
              }
              if(result1.getLong("answer")==3)
              {
            	  pollstat.setOptionC(result1.getLong("mycount"));    
              }
              if(result1.getLong("answer")==4)
              {
            	  pollstat.setOptionD(result1.getLong("mycount"));  
              }
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

        return pollstat;
	}
	
	
	
	
	
	public PollStat getAreaVotes(long poll_id,int area)
	{
		PollStat pollstat=new PollStat();
        ResultSet result1;
        DBUtil dbutil = new DBUtil();
        PreparedStatement pst = null;
        try {
            connection = dbutil.get();
            pst = connection.prepareStatement("select answer,count(answer) as mycount from user_answers join users on usr_id=id where locationID=? and poll_id=? group by answer");
            pst.setInt(1,area);
            pst.setLong(2, poll_id);
            result1 = pst.executeQuery();
            while (result1.next()) {
              if(result1.getLong("answer")==1)
              {
            	pollstat.setOptionA(result1.getLong("mycount"));  
              }
              if(result1.getLong("answer")==2)
              {
            	pollstat.setOptionB(result1.getLong("mycount"));  
              }
              if(result1.getLong("answer")==3)
              {
            	  pollstat.setOptionC(result1.getLong("mycount"));    
              }
              if(result1.getLong("answer")==4)
              {
            	  pollstat.setOptionD(result1.getLong("mycount"));  
              }
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

        return pollstat;
	}
	
	
	
	
	public PollStat getUnivVotes(long poll_id,int univ)
	{
		PollStat pollstat=new PollStat();
        ResultSet result1;
        DBUtil dbutil = new DBUtil();
        PreparedStatement pst = null;
        try {
            connection = dbutil.get();
            pst = connection.prepareStatement("select answer,count(answer) as mycount from user_answers join users on usr_id=id where schoolID=? and poll_id=? group by answer");
            pst.setInt(1,univ);
            pst.setLong(2, poll_id);
            result1 = pst.executeQuery();
            while (result1.next()) {
              if(result1.getLong("answer")==1)
              {
            	pollstat.setOptionA(result1.getLong("mycount"));  
              }
              if(result1.getLong("answer")==2)
              {
            	pollstat.setOptionB(result1.getLong("mycount"));  
              }
              if(result1.getLong("answer")==3)
              {
            	  pollstat.setOptionC(result1.getLong("mycount"));    
              }
              if(result1.getLong("answer")==4)
              {
            	  pollstat.setOptionD(result1.getLong("mycount"));  
              }
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

        return pollstat;
	}
	
	
	
	public PollStat getCombVotes(long poll_id,int age,int gender,int area,int univ)
	{
		PollStat pollstat=new PollStat();
        ResultSet result1;
        DBUtil dbutil = new DBUtil();
        PreparedStatement pst = null;
        try {
            connection = dbutil.get();
            
            String query="select answer,count(answer) as mycount from user_answers join users on usr_id=id where ";
            
            if(age!=-1)
            	query+="age in(?) and ";
            else
            	query+="1=? and ";
            
            if(gender==0)
            	query+="(sex like '%Male%' or sex like '%male%') and ";
            
            if(gender==1)
            	query+="(sex like '%Female%' or sex like '%female%') and ";
            
            if(area!=-1)
            	query+="locationID in(?) and ";
            else
            	query+="1=? and ";
            
            if(univ!=-1)
            	query+="schoolID in(?) and ";
            else
            	query+="1=? and ";
            
            query+="poll_id=? group by answer";
            

                pst = connection.prepareStatement(query);
 
            if(age==-1)
            	pst.setInt(1,1);
            else
            	pst.setInt(1,age);
            
            if(area==-1)
            	pst.setInt(2,1);
            else
            	pst.setInt(2,area);
            
            if(univ==-1)
            	pst.setInt(3,1);
            else
            	pst.setInt(3,univ);

            pst.setLong(4, poll_id);
            result1 = pst.executeQuery();
            while (result1.next()) {
              if(result1.getLong("answer")==1)
              {
            	pollstat.setOptionA(result1.getLong("mycount"));  
              }
              if(result1.getLong("answer")==2)
              {
            	pollstat.setOptionB(result1.getLong("mycount"));  
              }
              if(result1.getLong("answer")==3)
              {
            	  pollstat.setOptionC(result1.getLong("mycount"));    
              }
              if(result1.getLong("answer")==4)
              {
            	  pollstat.setOptionD(result1.getLong("mycount"));  
              }
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

        return pollstat;
	}
	
	
	public ArrayList<PollStat> getSchoolTable(long poll_id)
	{
        ArrayList<PollStat> schoolList=new ArrayList<PollStat>();
        ResultSet result1;
        DBUtil dbutil = new DBUtil();
        PreparedStatement pst = null;
        try {
            connection = dbutil.get();
            pst = connection.prepareStatement("select school_name ,answer,count(answer) as mycount from user_answers join users join poll_school on usr_id=id and schoolID=school_id where poll_id=? group by answer order by school_name,answer");
            pst.setLong(1, poll_id);
            String previous="";
            PollStat pollstat=new PollStat();
            result1 = pst.executeQuery();
            while (result1.next())
            {
            	
            	if(result1.getString("school_name").equals(previous))
            	{
		              if(result1.getLong("answer")==1)
		              {
		            	pollstat.setOptionA(result1.getLong("mycount"));  
		              }
		              if(result1.getLong("answer")==2)
		              {
		            	pollstat.setOptionB(result1.getLong("mycount"));  
		              }
		              if(result1.getLong("answer")==3)
		              {
		            	  pollstat.setOptionC(result1.getLong("mycount"));    
		              }
		              if(result1.getLong("answer")==4)
		              {
		            	  pollstat.setOptionD(result1.getLong("mycount"));  
		              }
            	}
            	else
            	{
            		if(pollstat.getCollege()!=null)
            		schoolList.add(pollstat);
            		pollstat=new PollStat();
            		previous=result1.getString("school_name");
            		pollstat.setCollege(result1.getString("school_name"));
            		if(result1.getLong("answer")==1)
		              {
		            	pollstat.setOptionA(result1.getLong("mycount"));  
		              }
		              if(result1.getLong("answer")==2)
		              {
		            	pollstat.setOptionB(result1.getLong("mycount"));  
		              }
		              if(result1.getLong("answer")==3)
		              {
		            	  pollstat.setOptionC(result1.getLong("mycount"));    
		              }
		              if(result1.getLong("answer")==4)
		              {
		            	  pollstat.setOptionD(result1.getLong("mycount"));  
		              }
            		
            	}
            }
            schoolList.add(pollstat);
            
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

        return schoolList;
	}

	
	public ArrayList<PollStat> getAreaTable(long poll_id)
	{
        ArrayList<PollStat> areaList=new ArrayList<PollStat>();
        ResultSet result1;
        DBUtil dbutil = new DBUtil();
        PreparedStatement pst = null;
        try {
            connection = dbutil.get();
            pst = connection.prepareStatement("select area_name ,answer,count(answer) as mycount from user_answers join users join poll_area on usr_id=id and locationID=area_id where poll_id=? group by answer order by area_name,answer;");
            pst.setLong(1, poll_id);
            String previous="";
            PollStat pollstat=new PollStat();
            result1 = pst.executeQuery();
            while (result1.next())
            {
            	
            	if(result1.getString("area_name").equals(previous))
            	{
		              if(result1.getLong("answer")==1)
		              {
		            	pollstat.setOptionA(result1.getLong("mycount"));  
		              }
		              if(result1.getLong("answer")==2)
		              {
		            	pollstat.setOptionB(result1.getLong("mycount"));  
		              }
		              if(result1.getLong("answer")==3)
		              {
		            	  pollstat.setOptionC(result1.getLong("mycount"));    
		              }
		              if(result1.getLong("answer")==4)
		              {
		            	  pollstat.setOptionD(result1.getLong("mycount"));  
		              }
            	}
            	else
            	{
            		if(pollstat.getArea()!=null)
            		areaList.add(pollstat);
            		pollstat=new PollStat();
            		previous=result1.getString("area_name");
            		pollstat.setArea(result1.getString("area_name"));
            		if(result1.getLong("answer")==1)
		              {
		            	pollstat.setOptionA(result1.getLong("mycount"));  
		              }
		              if(result1.getLong("answer")==2)
		              {
		            	pollstat.setOptionB(result1.getLong("mycount"));  
		              }
		              if(result1.getLong("answer")==3)
		              {
		            	  pollstat.setOptionC(result1.getLong("mycount"));    
		              }
		              if(result1.getLong("answer")==4)
		              {
		            	  pollstat.setOptionD(result1.getLong("mycount"));  
		              }
            		
            	}
            }
            areaList.add(pollstat);
            
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

        return areaList;
	}
	
	
	public ArrayList<PollStat> getAgeTable(long poll_id)
	{
        ArrayList<PollStat> ageList=new ArrayList<PollStat>();
        ResultSet result1;
        DBUtil dbutil = new DBUtil();
        PreparedStatement pst = null;
        try {
            connection = dbutil.get();
            pst = connection.prepareStatement("select age,answer,count(answer) as mycount from user_answers join users on usr_id=id where poll_id=? group by answer order by age,answer");
            pst.setLong(1, poll_id);
            String previous="";
            PollStat pollstat=new PollStat();
            result1 = pst.executeQuery();
            while (result1.next())
            {
            	
            	if((result1.getLong("age")+"").equals(previous))
            	{
		              if(result1.getLong("answer")==1)
		              {
		            	pollstat.setOptionA(result1.getLong("mycount"));  
		              }
		              if(result1.getLong("answer")==2)
		              {
		            	pollstat.setOptionB(result1.getLong("mycount"));  
		              }
		              if(result1.getLong("answer")==3)
		              {
		            	  pollstat.setOptionC(result1.getLong("mycount"));    
		              }
		              if(result1.getLong("answer")==4)
		              {
		            	  pollstat.setOptionD(result1.getLong("mycount"));  
		              }
            	}
            	else
            	{
            		if(pollstat.getArea()!=null)
            		ageList.add(pollstat);
            		pollstat=new PollStat();
            		previous=result1.getString("age")+"";
            		pollstat.setArea(result1.getString("age")+"");
            		if(result1.getLong("answer")==1)
		              {
		            	pollstat.setOptionA(result1.getLong("mycount"));  
		              }
		              if(result1.getLong("answer")==2)
		              {
		            	pollstat.setOptionB(result1.getLong("mycount"));  
		              }
		              if(result1.getLong("answer")==3)
		              {
		            	  pollstat.setOptionC(result1.getLong("mycount"));    
		              }
		              if(result1.getLong("answer")==4)
		              {
		            	  pollstat.setOptionD(result1.getLong("mycount"));  
		              }
            		
            	}
            }
            ageList.add(pollstat);
            
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

        return ageList;
	}
	
}
