package service;

import DAO.AnswerLoadDao;
import dto.Answer;

public class AnswerLoadService {
	
	public Answer getAnswer(int poll_id,int selectedOption,long usrid)
	{
		AnswerLoadDao answerLoadDao = new AnswerLoadDao();
		Answer answer=answerLoadDao.getAnswer(poll_id,selectedOption,usrid);
		return answer;
	}
	
	
	public Answer getAnswer(int poll_id,long usrid)
	{
		AnswerLoadDao answerLoadDao = new AnswerLoadDao();
		Answer answer=answerLoadDao.getAnswer(poll_id,usrid);
		return answer;
	}

}
