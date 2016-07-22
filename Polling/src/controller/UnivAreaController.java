package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.UnivAreaDAO;

/**
 * Servlet implementation class UnivAreaController
 */
@WebServlet("/UnivAreaController")
public class UnivAreaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UnivAreaController() {
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
		
		if(request.getParameter("actionType").equals("area"))
		{
			UnivAreaDAO univAreaDAO=new UnivAreaDAO();
			int status=univAreaDAO.addArea(request.getParameter("areaname"));
			if(status==1)
			{
				response.sendRedirect("success.jsp");
			}
				//to do
			else
			{
				response.sendRedirect("fail.jsp");
			}
				//todo
			
		}
		if(request.getParameter("actionType").equals("school"))
		{
			UnivAreaDAO univAreaDAO=new UnivAreaDAO();
			int schoolstatus=univAreaDAO.addSchool(request.getParameter("schoolname"));
			if(schoolstatus==1)
			{
				response.sendRedirect("success.jsp");
			}
				//to do
			else
			{
				response.sendRedirect("fail.jsp");
			}
				//todo
		}
		
		if(request.getParameter("actionType").equals("category"))
		{
			UnivAreaDAO univAreaDAO=new UnivAreaDAO();
			int categorystatus=univAreaDAO.addCategory(request.getParameter("categoryname"));
			if(categorystatus==1)
			{
				response.sendRedirect("success.jsp");
			}
				//to do
			else
			{
				response.sendRedirect("fail.jsp");
			}
				//todo
		}
				
	}

}
