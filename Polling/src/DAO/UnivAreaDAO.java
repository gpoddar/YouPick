package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.Area;
import dto.Poll;
import dto.University;
import util.DBUtil;

public class UnivAreaDAO {
	
	Connection connection;
	int status=-1;
	public int addArea(String area)
	{
		DBUtil dbutil=new DBUtil();
		PreparedStatement pst=null;
		try{
			connection=dbutil.get();
			pst= connection.prepareStatement("insert into poll_area(area_name) values(?)");
			pst.setString(1,area);

			status = pst.executeUpdate();
			pst.close();
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
				
			} catch (SQLException sqlException) {
				
				sqlException.printStackTrace();
			}
			
		}
		
		return status;
	}
	
	public int addSchool(String school)
	{
		DBUtil dbutil=new DBUtil();
		PreparedStatement pst=null;
		try{
			connection=dbutil.get();
			pst= connection.prepareStatement("insert into poll_school(school_name) values(?)");
			pst.setString(1,school);

			status = pst.executeUpdate();
			pst.close();
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
				
			} catch (SQLException sqlException) {
				
				sqlException.printStackTrace();
			}
			
		}
		
		return status;
	}
	
	public int addCategory(String Category)
	{
		DBUtil dbutil=new DBUtil();
		PreparedStatement pst=null;
		try{
			connection=dbutil.get();
			pst= connection.prepareStatement("insert into poll_category(category_name) values(?)");
			pst.setString(1,Category);

			status = pst.executeUpdate();
			pst.close();
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
				
			} catch (SQLException sqlException) {
				
				sqlException.printStackTrace();
			}
			
		}
		
		return status;
	}
	
	public int disableArea(double areaID) {
        DBUtil dbutil = new DBUtil();
        PreparedStatement pst = null;
        try {
            connection = dbutil.get();
            pst = connection.prepareStatement("update poll_area set visibility = 0 where area_id = ?");
            pst.setDouble(1, areaID);

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

    public int disableSchool(double schoolID) {
        DBUtil dbutil = new DBUtil();
        PreparedStatement pst = null;
        try {
            connection = dbutil.get();
            pst = connection.prepareStatement("update poll_school set visibility = 0 where school_id = ?");
            pst.setDouble(1, schoolID);

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

    public int disableCategory(double categoryID) {
        DBUtil dbutil = new DBUtil();
        PreparedStatement pst = null;
        try {
            connection = dbutil.get();
            pst = connection.prepareStatement("update poll_category set visibility = 0 where category_id = ?");
            pst.setDouble(1, categoryID);

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
    
    
    public ArrayList<University>getUnivList()
    {

        ArrayList<University> universities=new ArrayList<University>();
		DBUtil dbutil=new DBUtil();
		PreparedStatement pst=null;
		ResultSet resultSet=null;
		try{
			connection=dbutil.get();
			pst = connection.prepareStatement("select * from poll_school where visibility=1");
			resultSet = pst.executeQuery();
			while(resultSet.next()){
				University university=new University();
				university.setId(resultSet.getLong("school_id"));
				university.setName(resultSet.getString("school_name"));
				universities.add(university);
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
		
		return universities;
		
		
    }
    
    public ArrayList<Area>getAreaList()
    {

        ArrayList<Area> areas=new ArrayList<Area>();
		DBUtil dbutil=new DBUtil();
		PreparedStatement pst=null;
		ResultSet resultSet=null;
		try{
			connection=dbutil.get();
			pst = connection.prepareStatement("select * from poll_area where visibility=1");
			resultSet = pst.executeQuery();
			while(resultSet.next()){
				Area area=new Area();
				area.setId(resultSet.getLong("area_id"));
				area.setName(resultSet.getString("area_name"));
				areas.add(area);
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
		
		return areas;
		
		
    }
    
    
    
    public ArrayList<Integer>getAgeList()
    {

        ArrayList<Integer> ages=new ArrayList<Integer>();
		DBUtil dbutil=new DBUtil();
		PreparedStatement pst=null;
		ResultSet resultSet=null;
		try{
			connection=dbutil.get();
			pst = connection.prepareStatement("select distinct age from users;");
			resultSet = pst.executeQuery();
			while(resultSet.next()){
				ages.add(resultSet.getInt("age"));
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
		
		return ages;
		
		
    }
    
    

}


