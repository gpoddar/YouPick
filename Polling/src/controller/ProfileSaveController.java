package controller;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.UserDAO;
import dto.User;
import exception.ProfileFormException;

/**
 * Servlet implementation class ProfileSaveController
 */
@WebServlet("/ProfileSaveController")
public class ProfileSaveController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = 
		    Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfileSaveController() {
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
		
		
		try
		{
		
		int age;
		
		String name=request.getParameter("name").toString();
		if(name=="" ||name==null)
		{
			throw new ProfileFormException("Name cannot be blank");
		}
		
		if(!(name.matches("^[\\p{L} .'-]+$")))
		{
			throw new ProfileFormException("Invalid Name entered");
		}
		
		
		try{
		age=Integer.parseInt(request.getParameter("age").toString());
		}
		catch(Exception e)
		{
			throw new ProfileFormException("Invalid age entered");
			
		}
		
		String gender=request.getParameter("gender").toString();
		if(!(gender.equals("Male")||gender.equals("Female")||gender.equals("female")||gender.equals("male"))||gender.equals("")||gender==null)
		{
			throw new ProfileFormException("Invalid gender");
		}

		
		
		String email=request.getParameter("email").toString();
		if(gender=="" ||gender==null)
		{
			throw new ProfileFormException("Email ID cannot be blank");
		}
		if(!validate(email))
		{
			throw new ProfileFormException("Please enter a valid email address");
		}
		
		//String area=request.getParameter("area").toString();
		//String school=request.getParameter("school").toString();
		
		User u=new User();
		u.setAge(age);
		u.setFullName(name);
		u.setSex(gender);
		u.setEmailID(email);
		u.setId(Double.parseDouble(session.getAttribute("userID").toString()));
		u.setAreaID(Integer.parseInt(request.getParameter("area").toString()));
		u.setSchoolID(Integer.parseInt(request.getParameter("university").toString()));
		int status=new UserDAO().updateUserProfile(u);
		if(status==1)
		{
			RequestDispatcher requestdispatcher = request.getRequestDispatcher("profilesuccess.jsp");
            requestdispatcher.forward(request, response);
		}
		else
		{
            RequestDispatcher requestdispatcher = request.getRequestDispatcher("Error.jsp");
            requestdispatcher.forward(request, response);
		}
		
		
		
		}
		catch(ProfileFormException p)
		{
			String s=p.getMessage();
			request.setAttribute("message",s);
            RequestDispatcher requestdispatcher = request.getRequestDispatcher("validationError.jsp");
            requestdispatcher.forward(request, response);
		}
		
		
		
	}
	
	
	
	public static boolean validate(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX .matcher(emailStr);
        return matcher.find();
}

}
