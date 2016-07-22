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

import DAO.PollAddDAO;
import DAO.UnivAreaDAO;
import dto.Area;
import dto.Category;
import dto.Poll;
import dto.University;
import service.PollViewService;

/**
 * Servlet implementation class AreaUnivController
 */
public class AreaUnivController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AreaUnivController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub		
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
		
		PollViewService pollViewService=new PollViewService();
		ArrayList<Poll> pollList=pollViewService.getViewPolls();
		
		UnivAreaDAO univAreaDao=new UnivAreaDAO();
		
		ArrayList<University> univList=univAreaDao.getUnivList();
		ArrayList<Area> areaList=univAreaDao.getAreaList();
		PollAddDAO pollAddDAO=new PollAddDAO();
		ArrayList<Category> catList=pollAddDAO.getCategories();
		
		request.setAttribute("pollList",pollList);
		request.setAttribute("univList",univList);
		request.setAttribute("areaList",areaList);
		request.setAttribute("catList",catList);
		RequestDispatcher view=request.getRequestDispatcher("univareaadd.jsp");
	    view.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
