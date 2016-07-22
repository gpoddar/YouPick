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
import org.json.JSONObject;

import DAO.AnswerLoadDao;
import DAO.AnsweredDAO;
import dto.Answer;
import dto.Poll;
import service.PollLoadService;

/**
 * Servlet implementation class AnsweredPollsController
 */
@WebServlet("/AnsweredPollsController")
public class AnsweredPollsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AnsweredPollsController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
    	Object userName =session.getAttribute("userID");
    	
    	if( userName==null) 
    	{
    	  response.setHeader("Cache-Control","no-cache");
          response.setHeader("Cache-Control","no-store"); 
        	response.setDateHeader("Expires", 0); 
        	response.setHeader("Pragma","no-cache");
    	   RequestDispatcher rd = request.getRequestDispatcher("loginfail.jsp");
    	   rd.forward(request, response);
    	}
		

		
		int category=Integer.parseInt(request.getParameter("category"));
		String catClick=request.getParameter("isCatClick").toString();
		AnsweredDAO answeredDAO=new AnsweredDAO();
		

		ArrayList<Poll> polls=answeredDAO.fetchPolls(category,(long)session.getAttribute("userID"));
		
		
		if(polls!=null)
		{
		try {
		JSONArray pollJSONArray = new JSONArray();	
		for(Poll poll:polls)
		{
		JSONObject JSONPoll = new JSONObject();
		JSONPoll.put("PollId",poll.getPollId());
		JSONPoll.put("Description",poll.getDescription());
		JSONPoll.put("FbCommentId",poll.getFbCommentId());
		JSONPoll.put("ImgSrc",poll.getImgSrc());
		JSONPoll.put("OptionOne",poll.getOptionOne());
		JSONPoll.put("OptionTwo",poll.getOptiontwo());
		JSONPoll.put("OptionThree",poll.getOptionThree());
		JSONPoll.put("OptionFour",poll.getOptionFour());
		JSONPoll.put("Tagged",poll.getTagged());
		JSONPoll.put("Title",poll.getTitle());
		JSONPoll.put("answer",poll.getUserAnswer());
		JSONPoll.put("isbinary",poll.getBinary());
	    pollJSONArray.put(JSONPoll);
	    
		}
		
		
		JSONObject responseJSONPollObject = new JSONObject();
		responseJSONPollObject.put("Poll", pollJSONArray);
		
		
		
		
		
		
		AnswerLoadDao answerLoadDAO=new AnswerLoadDao();
		ArrayList<Answer> answers=answerLoadDAO.getAnswers((long)session.getAttribute("userID"));
		JSONArray pollJSONArray1 = new JSONArray();
		for(Answer answer:answers)
		{
		JSONObject JSONPoll = new JSONObject();
		JSONPoll.put("PollId",answer.getPoll_id());
		double total=(answer.getOptionA())+(answer.getOptionB())+(answer.getOptionC())+(answer.getOptionD());
		JSONPoll.put("optionA",(answer.getOptionA()/total)*100);
		JSONPoll.put("optionB",(answer.getOptionB()/total)*100);
		JSONPoll.put("optionC",(answer.getOptionC()/total)*100);
		JSONPoll.put("optionD",(answer.getOptionD()/total)*100);
		JSONPoll.put("answer",answer.getUseranswer());

	    pollJSONArray1.put(JSONPoll);
	    
		}
		responseJSONPollObject.put("answers", pollJSONArray1);
		
		
		String JSONString=responseJSONPollObject.toString();
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
		else
		{
		RequestDispatcher requestdispatcher=request.getRequestDispatcher("Error.jsp");
	    requestdispatcher.forward(request,response);	
		}
		
	}
	

}
