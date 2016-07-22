package service;

import DAO.PollAddDAO;
import dto.Poll;

public class PollAddService {

	
	public int addPoll(Poll poll)
	{
		PollAddDAO pollAddDao=new PollAddDAO();
		return pollAddDao.addPoll(poll);
				
	}
	public String getImageName()
	{
		PollAddDAO pollAddDao=new PollAddDAO();
		return ""+pollAddDao.getImageName();
	}
	
	public int editPoll(Poll poll)
    {
        PollAddDAO pollAddDao=new PollAddDAO();
        return pollAddDao.editPoll(poll);
                
    }
}
