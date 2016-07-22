package service;

import java.util.ArrayList;

import DAO.PollViewDAO;
import dto.Poll;

public class PollViewService {

	
	public ArrayList<Poll> getViewPolls()
	{
		
		ArrayList<Poll> pollList=new ArrayList<Poll>();
		PollViewDAO pollViewDao=new PollViewDAO();
		pollList=pollViewDao.getViewPolls();
		if(pollList.size()==0)
		{
			//to DO
		}
		return pollList;
	}

}
