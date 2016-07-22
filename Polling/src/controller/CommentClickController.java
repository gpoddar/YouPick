package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import DAO.AnswerLoadDao;
import DAO.PollFetchDAO;
import DAO.UserDAO;
import dto.Answer;
import dto.Poll;
import service.PollLoadService;

/**
 * Servlet implementation class CommentClickController
 */
@WebServlet("/CommentClickController")
public class CommentClickController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentClickController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		long usrid=(long)session.getAttribute("userID");
		long pollId=Long.parseLong(request.getParameter("pollid").toString());
		boolean isAnswered=new UserDAO().isAnswered(pollId,usrid);
		
		
		try {
		
		JSONObject JSONPoll1 = new JSONObject();
		
			JSONPoll1.put("status",isAnswered);

		JSONObject JSONPoll = new JSONObject();
		if(isAnswered)
		{
			
			AnswerLoadDao answerLoadDAO=new AnswerLoadDao();
			ArrayList<Answer> answers=answerLoadDAO.getAnswers((long)session.getAttribute("userID"));
			JSONArray pollJSONArray1 = new JSONArray();
			for(Answer answer:answers)
			{
			if(answer.getPoll_id()==pollId)
			{
			
			JSONPoll.put("PollId",answer.getPoll_id());
			double total=(answer.getOptionA())+(answer.getOptionB())+(answer.getOptionC())+(answer.getOptionD());
			JSONPoll.put("optionA",(answer.getOptionA()/total)*100);
			JSONPoll.put("optionB",(answer.getOptionB()/total)*100);
			JSONPoll.put("optionC",(answer.getOptionC()/total)*100);
			JSONPoll.put("optionD",(answer.getOptionD()/total)*100);
			JSONPoll.put("answer",answer.getUseranswer());

		    
			}
			}
			JSONPoll1.put("answerinfo", JSONPoll);
			
		}
		
		
		
		String JSONString=JSONPoll1.toString();
		response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");
	    response.getWriter().write(JSONString);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();

        long pollId=Long.parseLong(request.getParameter("pollid").toString());

		Poll poll=new PollFetchDAO().getPoll(pollId);
		
		try {

		JSONObject JSONPoll = new JSONObject();
		JSONPoll.put("PollId",poll.getPollId());
		JSONPoll.put("Votes",poll.getVotes());
		JSONPoll.put("Description",poll.getDescription());
		JSONPoll.put("FbCommentId",poll.getFbCommentId());
		JSONPoll.put("ImgSrc",poll.getImgSrc());
		JSONPoll.put("OptionOne",poll.getOptionOne());
		JSONPoll.put("OptionTwo",poll.getOptiontwo());
		JSONPoll.put("OptionThree",poll.getOptionThree());
		JSONPoll.put("OptionFour",poll.getOptionFour());
		JSONPoll.put("Tagged",poll.getTagged());
		JSONPoll.put("Title",poll.getTitle());
		JSONPoll.put("isbinary",poll.getBinary());


		
		JSONObject responseJSONPollObject = new JSONObject();
		responseJSONPollObject.put("Poll", JSONPoll);
		String JSONString=JSONPoll.toString();
		response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");
	    response.getWriter().write(JSONString);
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			RequestDispatcher requestdispatcher=request.getRequestDispatcher("Error.jsp");
		    requestdispatcher.forward(request,response);
		}

	}

}
