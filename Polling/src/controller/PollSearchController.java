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

import DAO.PollSearchDAO;
import DAO.UnivAreaDAO;
import dto.Area;
import dto.Poll;
import dto.University;
import service.PollViewService;

/**
 * Servlet implementation class PollSearchController
 */
@WebServlet("/PollSearchController")
public class PollSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PollSearchController() {
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
		
		
		String searchstring=request.getParameter("searchstring");
		PollSearchDAO pollSearchDAO=new PollSearchDAO();
		ArrayList<Poll> pollList=pollSearchDAO.getSearchPolls(searchstring);
		UnivAreaDAO univAreaDAO=new UnivAreaDAO();
		ArrayList<Area> areas=univAreaDAO.getAreaList();
		ArrayList<University>univs=univAreaDAO.getUnivList();
		ArrayList<Integer> ages=univAreaDAO.getAgeList();
		
		
		
		request.setAttribute("arealist",areas);
		request.setAttribute("univlist",univs);
		request.setAttribute("agelist",ages);
		request.setAttribute("pollList",pollList);
		
		request.setAttribute("isSearch",searchstring);
		RequestDispatcher view=request.getRequestDispatcher("pollviewstats.jsp");
	    view.forward(request,response);
		
	}

}
