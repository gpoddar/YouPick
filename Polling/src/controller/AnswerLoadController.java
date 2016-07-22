package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import dto.Answer;
import service.AnswerLoadService;

/**
 * Servlet implementation class AnswerLoadController
 */
@WebServlet("/AnswerLoadController")
public class AnswerLoadController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AnswerLoadController() {
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
		
		
		
		
		
		String poll_id=request.getParameter("id");
		String selectedOption=request.getParameter("selectedOption");
		AnswerLoadService AnswerLoadService=new AnswerLoadService();
		
		
		
		if(request.getParameter("answeredpoll").equals("true"))
		{
			Answer answer=AnswerLoadService.getAnswer(Integer.parseInt(poll_id),(long)session.getAttribute("userID"));
			
			try {
			JSONObject JSONAnswer = new JSONObject();
			if(answer.isbinary())
			{
				double total=(answer.getOptionA())+(answer.getOptionB());
				JSONAnswer.put("optionA",(answer.getOptionA()/total)*100);
				JSONAnswer.put("optionB",(answer.getOptionB()/total)*100);
				JSONAnswer.put("type","two");
				String JSONString=JSONAnswer.toString();
				response.setContentType("application/json");
			    response.setCharacterEncoding("UTF-8");
			    response.getWriter().write(JSONString);
			}
			else
			{
				double total=(answer.getOptionA())+(answer.getOptionB())+(answer.getOptionC())+(answer.getOptionD());
				JSONAnswer.put("optionA",(answer.getOptionA()/total)*100);
				JSONAnswer.put("optionB",(answer.getOptionB()/total)*100);
				JSONAnswer.put("optionC",(answer.getOptionC()/total)*100);
				JSONAnswer.put("optionD",(answer.getOptionD()/total)*100);
				JSONAnswer.put("type","four");
				String JSONString=JSONAnswer.toString();
				response.setContentType("application/json");
			    response.setCharacterEncoding("UTF-8");
			    response.getWriter().write(JSONString);
			}
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
		
		Answer answer=AnswerLoadService.getAnswer(Integer.parseInt(poll_id),Integer.parseInt(selectedOption),(long)session.getAttribute("userID"));
		
		try {
		JSONObject JSONAnswer = new JSONObject();
		if(answer.isbinary())
		{
			double total=(answer.getOptionA())+(answer.getOptionB());
			JSONAnswer.put("optionA",(answer.getOptionA()/total)*100);
			JSONAnswer.put("optionB",(answer.getOptionB()/total)*100);
			JSONAnswer.put("type","two");
			String JSONString=JSONAnswer.toString();
			response.setContentType("application/json");
		    response.setCharacterEncoding("UTF-8");
		    response.getWriter().write(JSONString);
		}
		else
		{
			double total=(answer.getOptionA())+(answer.getOptionB())+(answer.getOptionC())+(answer.getOptionD());
			JSONAnswer.put("optionA",(answer.getOptionA()/total)*100);
			JSONAnswer.put("optionB",(answer.getOptionB()/total)*100);
			JSONAnswer.put("optionC",(answer.getOptionC()/total)*100);
			JSONAnswer.put("optionD",(answer.getOptionD()/total)*100);
			JSONAnswer.put("type","four");
			String JSONString=JSONAnswer.toString();
			response.setContentType("application/json");
		    response.setCharacterEncoding("UTF-8");
		    response.getWriter().write(JSONString);
		}
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
