package service;

import java.util.ArrayList;

import DAO.PollFetchDAO;
import dto.Poll;

public class PollLoadService {
	
	public ArrayList<Poll> getPolls(int category,ArrayList<String> loadedPolls, long usrid)
	{
	
		PollFetchDAO pollFetchDAO=new PollFetchDAO();
		ArrayList<Poll> polls=pollFetchDAO.fetchPolls(category,loadedPolls,usrid);
		return polls;
	}
	
	
	public ArrayList<Poll> getIndexPolls(int category,String loadedpolls)
	{
	
		PollFetchDAO pollFetchDAO=new PollFetchDAO();
		ArrayList<Poll> polls=pollFetchDAO.fetchIndexPolls(category,loadedpolls);
		return polls;
	}

}
