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

import DAO.PollFetchDAO;
import DAO.PollStatsDAO;
import dto.Area;
import dto.Poll;
import dto.PollStat;
import dto.University;
import dto.UserAge;

/**
 * Servlet implementation class PollStatsController
 */
@WebServlet("/PollStatsController")
public class PollStatsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PollStatsController() {
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
		
		int poll_id=Integer.parseInt(request.getParameter("poll_id"));
		PollStatsDAO pollStatsDAO=new PollStatsDAO();
		PollStat pollStat=pollStatsDAO.getStats(poll_id);
		PollFetchDAO pollFetchDAO=new PollFetchDAO();
		Poll poll=pollFetchDAO.getPoll(poll_id);
		
		
		if(pollStat!=null)
		{
		try {
	    JSONArray genderlist = new JSONArray();
	    JSONArray agelist = new JSONArray();
	    JSONArray agecountlist = new JSONArray();
	    JSONArray arealist = new JSONArray();
	    JSONArray areacountlist = new JSONArray();
	    JSONArray univlist = new JSONArray();
	    JSONArray univcountlist = new JSONArray();
	    JSONArray answerslist = new JSONArray();
	    
	    genderlist.put(pollStat.getMale());
	    genderlist.put(pollStat.getFemale());
	    
	    answerslist.put(pollStat.getOptionA());
	    answerslist.put(pollStat.getOptionB());
	    answerslist.put(pollStat.getOptionC());
	    answerslist.put(pollStat.getOptionD());
	    JSONObject JSONAge = new JSONObject();
	    JSONObject JSONArea = new JSONObject();
	    JSONObject JSONUniv = new JSONObject();
	    JSONArray MaleVotes = new JSONArray();
	    JSONArray FemaleVotes = new JSONArray();
	    
	    PollStat maleVotes=new PollStat();
	    PollStat femaleVotes=new PollStat();
	    
	    maleVotes=pollStatsDAO.getMaleVotes(poll_id);
	    femaleVotes=pollStatsDAO.getFemaleVotes(poll_id);
	    
	    
	    MaleVotes.put(maleVotes.getOptionA());
	    MaleVotes.put(maleVotes.getOptionB());
	    MaleVotes.put(maleVotes.getOptionC());
	    MaleVotes.put(maleVotes.getOptionD());
	    
	    FemaleVotes.put(femaleVotes.getOptionA());
	    FemaleVotes.put(femaleVotes.getOptionB());
	    FemaleVotes.put(femaleVotes.getOptionC());
	    FemaleVotes.put(femaleVotes.getOptionD());
	    
	    JSONArray JSONSchoolTable = new JSONArray();
	    
	    ArrayList<PollStat> pollstat=new ArrayList<PollStat>();
	    
	    pollstat=pollStatsDAO.getSchoolTable(poll_id);
	    
	    
	    for(PollStat p:pollstat)
	    {
	    JSONObject JSONSchoolTableobject=new JSONObject();
	    JSONSchoolTableobject.put("name",p.getCollege());
	    JSONSchoolTableobject.put("A",p.getOptionA());
	    JSONSchoolTableobject.put("B",p.getOptionB());
	    JSONSchoolTableobject.put("C",p.getOptionC());
	    JSONSchoolTableobject.put("D",p.getOptionD());
	    JSONSchoolTable.put(JSONSchoolTableobject);
	    }
	    
	    
	    
	    
	    JSONArray JSONAreaTable = new JSONArray();
	    
	    ArrayList<PollStat> pollstat1=new ArrayList<PollStat>();
	    
	    pollstat1=pollStatsDAO.getAreaTable(poll_id);
	    
	    
	    for(PollStat p:pollstat1)
	    {
	    JSONObject JSONAreaTableobject=new JSONObject();
	    JSONAreaTableobject.put("name",p.getArea());
	    JSONAreaTableobject.put("A",p.getOptionA());
	    JSONAreaTableobject.put("B",p.getOptionB());
	    JSONAreaTableobject.put("C",p.getOptionC());
	    JSONAreaTableobject.put("D",p.getOptionD());
	    JSONAreaTable.put(JSONAreaTableobject);
	    }
	    
	    
	    JSONArray JSONAgeTable = new JSONArray();
	    
	    ArrayList<PollStat> pollstat2=new ArrayList<PollStat>();
	    
	    pollstat2=pollStatsDAO.getAgeTable(poll_id);
	    
	    
	    for(PollStat p:pollstat2)
	    {
	    JSONObject JSONAgeTableobject=new JSONObject();
	    JSONAgeTableobject.put("name",p.getArea());
	    JSONAgeTableobject.put("A",p.getOptionA());
	    JSONAgeTableobject.put("B",p.getOptionB());
	    JSONAgeTableobject.put("C",p.getOptionC());
	    JSONAgeTableobject.put("D",p.getOptionD());
	    JSONAgeTable.put(JSONAgeTableobject);
	    }
	    
	    
	    
	    
	    for(UserAge i:pollStat.getAges())
	    {
	    	if(i.getAge()!=0)
	    	{
	    	agelist.put(i.getAge());
	    	}
	    }
	    
	    JSONAge.put("age",agelist);
	    for(UserAge i:pollStat.getAges())
	    {
	    	if(i.getAge()!=0)
	    	{
	    	agecountlist.put(i.getNumber());
	    	}
	    }
	    JSONAge.put("agecount",agecountlist);
	    
	    
	    ArrayList<Area> areaArrayList=new PollStatsDAO().getAreaStats(poll_id);
	    ArrayList<University> univArrayList=new PollStatsDAO().getUnivStats(poll_id);
	    
	    for(University u:univArrayList)
	    {
	    	univlist.put(u.getName());
	    	univcountlist.put(u.getId());
	    }
	    
	    for(Area a:areaArrayList)
	    {
	    	arealist.put(a.getName());
	    	areacountlist.put(a.getId());
	    }
	    
	    JSONArea.put("arealist",arealist);
	    JSONArea.put("areacountlist",areacountlist);
	    
	    JSONUniv.put("univlist",univlist);
	    JSONUniv.put("univcountlist",univcountlist);
	    
	    
	    
	    
	    
		JSONObject JSONPoll = new JSONObject();
		JSONPoll.put("votes",pollStat.getVotes());
		JSONPoll.put("option",pollStat.getOption());
		JSONPoll.put("title", poll.getTitle());
		JSONPoll.put("description",poll.getDescription());
		JSONPoll.put("optionOne", poll.getOptionOne());
		JSONPoll.put("optionTwo", poll.getOptiontwo());
		JSONPoll.put("optionThree", poll.getOptionThree());
		JSONPoll.put("optionFour", poll.getOptionFour());
		JSONPoll.put("genderlist", genderlist);
		JSONPoll.put("ageobject", JSONAge);
		JSONPoll.put("answerslist", answerslist);
		JSONPoll.put("area", JSONArea);
		JSONPoll.put("univ", JSONUniv);
		JSONPoll.put("malevotes",MaleVotes);
		JSONPoll.put("femalevotes",FemaleVotes);
		JSONPoll.put("SchoolTable",JSONSchoolTable);
		JSONPoll.put("AreaTable",JSONAreaTable);
		JSONPoll.put("AgeTable",JSONAgeTable);
		
		JSONObject responseJSONPollObject = new JSONObject();
		responseJSONPollObject.put("pollStat", JSONPoll);
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
		else
		{
		RequestDispatcher requestdispatcher=request.getRequestDispatcher("Error.jsp");
	    requestdispatcher.forward(request,response);	
		}
		
	}

}
