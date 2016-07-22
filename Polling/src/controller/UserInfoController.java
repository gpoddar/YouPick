
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

import org.json.JSONObject;

import DAO.UnivAreaDAO;
import DAO.UserDAO;
import dto.Area;
import dto.University;
import dto.User;

@WebServlet("/UserInfoController")
public class UserInfoController extends HttpServlet {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
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
    	
        User user = new User();

        user.setId(Double.parseDouble(session.getAttribute("userID").toString()));

        User userInfo = new UserDAO().getUserInfo(user);

        if (userInfo != null) {
            try {

                request.setAttribute("emailID", userInfo.getEmailID());
                request.setAttribute("name", userInfo.getFullName());
                if(userInfo.getAge()==0)
                request.setAttribute("age","");
                else
                request.setAttribute("age", userInfo.getAge());
                request.setAttribute("sex", userInfo.getSex());
                request.setAttribute("areaID", userInfo.getAreaID());
                request.setAttribute("schoolID", userInfo.getSchoolID());
                
                UnivAreaDAO ud=new UnivAreaDAO();
                
                ArrayList<Area> area=ud.getAreaList();
                ArrayList<University> univ=ud.getUnivList();
                
                request.setAttribute("arealist",area);
                request.setAttribute("univlist",univ);
                
                
                
                
                RequestDispatcher requestdispatcher = request.getRequestDispatcher("profile.jsp");
                requestdispatcher.forward(request, response);
            }
            catch (Exception e) {
                e.printStackTrace();
                RequestDispatcher requestdispatcher = request.getRequestDispatcher("Error.jsp");
                requestdispatcher.forward(request, response);
            }
        }
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
    	
        User user = new User();

        user.setId(Double.parseDouble(session.getAttribute("userID").toString()));

        User userInfo = new UserDAO().getUserInfo(user);

        if (userInfo != null) {
            try {

                request.setAttribute("emailID", userInfo.getEmailID());
                request.setAttribute("name", userInfo.getFullName());
                request.setAttribute("age", userInfo.getAge());
                request.setAttribute("sex", userInfo.getSex());
                request.setAttribute("areaID", userInfo.getAreaID());
                request.setAttribute("schoolID", userInfo.getSchoolID());
                
                
                
                RequestDispatcher requestdispatcher = request.getRequestDispatcher("profile.jsp");
                requestdispatcher.forward(request, response);
            }
            catch (Exception e) {
                e.printStackTrace();
                RequestDispatcher requestdispatcher = request.getRequestDispatcher("Error.jsp");
                requestdispatcher.forward(request, response);
            }
        }
    }
}
