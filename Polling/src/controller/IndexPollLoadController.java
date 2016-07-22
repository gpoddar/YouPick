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

import dto.Poll;
import service.PollLoadService;

/**
 * Servlet implementation class IndexPollLoadController
 */
@WebServlet("/IndexPollLoadController")
public class IndexPollLoadController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexPollLoadController() {
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

		
		
		
		int category=Integer.parseInt(request.getParameter("category"));

		String loadedpolls=request.getParameter("loadedString").toString();
		
		ArrayList<String>loadedPolls=new ArrayList<String>();
		PollLoadService pollLoadService=new PollLoadService();
		

		ArrayList<Poll> polls=pollLoadService.getIndexPolls(category,loadedpolls);

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
		JSONPoll.put("isbinary",poll.getBinary());
	    pollJSONArray.put(JSONPoll);
	    loadedpolls+=poll.getPollId()+",";
	    
		}
		
		
		JSONObject responseJSONPollObject = new JSONObject();
		responseJSONPollObject.put("Poll", pollJSONArray);
		responseJSONPollObject.put("loadedpolls", loadedpolls);
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
