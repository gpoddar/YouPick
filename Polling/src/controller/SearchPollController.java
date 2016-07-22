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

import DAO.SearchPollDAO;
import dto.Poll;

/**
 * Servlet implementation class SearchPollController
 */
@WebServlet("/SearchPollController")
public class SearchPollController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchPollController() {
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
		
		
		String searchString=request.getParameter("searchString");
		
		ArrayList<Poll> polls= new SearchPollDAO().fetchSearchPolls(searchString,Long.parseLong(userName.toString()));
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
		}
		JSONObject responseJSONPollObject = new JSONObject();
		responseJSONPollObject.put("Poll", pollJSONArray);
		String JSONString=pollJSONArray.toString();
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
