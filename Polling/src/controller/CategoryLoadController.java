package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import DAO.PollAddDAO;
import dto.Category;
import dto.Poll;

/**
 * Servlet implementation class CategoryLoadController
 */
@WebServlet("/CategoryLoadController")
public class CategoryLoadController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoryLoadController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PollAddDAO pollAddDAO=new PollAddDAO();
		ArrayList<Category> categoryList=pollAddDAO.getCategories();
		
		request.setAttribute("CategoryList",categoryList);
		RequestDispatcher view=request.getRequestDispatcher("pollAdd.jsp");
	    view.forward(request,response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PollAddDAO pollAddDAO=new PollAddDAO();
		ArrayList<Category> categoryList=pollAddDAO.getCategories();
		
		
		
		if(categoryList!=null)
		{
		try {
		JSONArray categoryJSONArray = new JSONArray();	
		for(Category category:categoryList)
		{
		JSONObject JSONPoll = new JSONObject();
		JSONPoll.put("category_id",category.getCategory_id());
		JSONPoll.put("category_name",category.getCategory_name());
        categoryJSONArray.put(JSONPoll);
		}
		JSONObject responseJSONCategoryObject = new JSONObject();
		responseJSONCategoryObject.put("Poll", categoryJSONArray);
		String JSONString=categoryJSONArray.toString();
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
