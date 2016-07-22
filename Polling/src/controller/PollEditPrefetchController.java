package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.PollAddDAO;
import DAO.PollFetchDAO;
import dto.Category;
import dto.Poll;

/**
 * Servlet implementation class PollEditPrefetchController
 */
@WebServlet("/PollEditPrefetchController")
public class PollEditPrefetchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PollEditPrefetchController() {
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
		// TODO Auto-generated method stub
		long pollid=Long.parseLong(request.getParameter("pollid").toString());
		Poll poll=new PollFetchDAO().getPoll(pollid);
		request.setAttribute("poll",poll);
		PollAddDAO pollAddDAO=new PollAddDAO();
		ArrayList<Category> categoryList=pollAddDAO.getCategories();
		
		request.setAttribute("CategoryList",categoryList);
		RequestDispatcher view=request.getRequestDispatcher("EditPoll.jsp");
	    view.forward(request,response);
	}

}
