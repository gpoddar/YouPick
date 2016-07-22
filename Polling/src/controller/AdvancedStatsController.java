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

import DAO.AnsweredDAO;
import DAO.PollStatsDAO;
import DAO.UnivAreaDAO;
import dto.Poll;
import dto.PollStat;

/**
 * Servlet implementation class AdvancedStatsController
 */
@WebServlet("/AdvancedStatsController")
public class AdvancedStatsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdvancedStatsController() {
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
		
        long userID=(long)session.getAttribute("userID");
        String actionType=request.getParameter("actionType").toString();
        
        
        if(actionType.equals("age"))
        {
        	try {
        	int age=Integer.parseInt(request.getParameter("age").toString());
        	int pollID=Integer.parseInt(request.getParameter("pollID").toString());
        	PollStatsDAO pollStatDAO=new PollStatsDAO();
        	PollStat pollStat=pollStatDAO.getAgeVotes(pollID,age);
        	
        	JSONArray AgeVotes = new JSONArray();
    	    
    	    
        	AgeVotes.put(pollStat.getOptionA());
        	AgeVotes.put(pollStat.getOptionB());
        	AgeVotes.put(pollStat.getOptionC());
        	AgeVotes.put(pollStat.getOptionD());
        	
        	JSONObject JSONPoll = new JSONObject();
        	
			JSONPoll.put("agevotes",AgeVotes);
        	
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
        
        if(actionType.equals("area"))
        {
        	try {
        	int area=Integer.parseInt(request.getParameter("area").toString());
        	int pollID=Integer.parseInt(request.getParameter("pollID").toString());
        	PollStatsDAO pollStatDAO=new PollStatsDAO();
        	PollStat pollStat=pollStatDAO.getAreaVotes(pollID,area);
        	
        	JSONArray AreaVotes = new JSONArray();
    	    
    	    
        	AreaVotes.put(pollStat.getOptionA());
        	AreaVotes.put(pollStat.getOptionB());
        	AreaVotes.put(pollStat.getOptionC());
        	AreaVotes.put(pollStat.getOptionD());
        	
        	JSONObject JSONPoll = new JSONObject();
        	
			JSONPoll.put("areavotes",AreaVotes);
        	
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
		
		
        
        
        if(actionType.equals("univ"))
        {
        	try {
        	int univ=Integer.parseInt(request.getParameter("univ").toString());
        	int pollID=Integer.parseInt(request.getParameter("pollID").toString());
        	PollStatsDAO pollStatDAO=new PollStatsDAO();
        	PollStat pollStat=pollStatDAO.getUnivVotes(pollID,univ);
        	
        	JSONArray UnivVotes = new JSONArray();
    	    
    	    
        	UnivVotes.put(pollStat.getOptionA());
        	UnivVotes.put(pollStat.getOptionB());
        	UnivVotes.put(pollStat.getOptionC());
        	UnivVotes.put(pollStat.getOptionD());
        	
        	JSONObject JSONPoll = new JSONObject();
        	
			JSONPoll.put("univvotes",UnivVotes);
        	
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
        
        
        if(actionType.equals("combinational"))
        {
        	try {
        	int age=Integer.parseInt(request.getParameter("age").toString());
        	int gender=Integer.parseInt(request.getParameter("gender").toString());
        	int area=Integer.parseInt(request.getParameter("area").toString());
        	int univ=Integer.parseInt(request.getParameter("univ").toString());
        	int pollID=Integer.parseInt(request.getParameter("pollID").toString());
        	PollStatsDAO pollStatDAO=new PollStatsDAO();
        	PollStat pollStat=pollStatDAO.getCombVotes(pollID,age,gender,area,univ);
        	
        	JSONArray UnivVotes = new JSONArray();
    	    
    	    
        	UnivVotes.put(pollStat.getOptionA());
        	UnivVotes.put(pollStat.getOptionB());
        	UnivVotes.put(pollStat.getOptionC());
        	UnivVotes.put(pollStat.getOptionD());
        	
        	JSONObject JSONPoll = new JSONObject();
        	
			JSONPoll.put("combvotes",UnivVotes);
        	
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

}
