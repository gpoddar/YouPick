
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

import org.apache.commons.codec.digest.DigestUtils;
import org.json.JSONObject;

import DAO.UserDAO;
import dto.User;

@WebServlet("/UserLoginController")
public class UserLoginController extends HttpServlet {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String fromFb = request.getParameter("fromFb").toString();

        User user = new User();

        Double userID;

        if (fromFb.equals("true")) {
            user.setFb_userID(request.getParameter("fb_userID"));
            userID = new UserDAO().findUserByFbUserID(user);

            if (userID == null) {
                try {

                    JSONObject responseJSON = new JSONObject();
                    responseJSON.put("userExists", false);
                    String JSONString = responseJSON.toString();
                    response.setContentType("application/json");
                    response.setCharacterEncoding("UTF-8");
                    response.getWriter().write(JSONString);
                }
                catch (Exception e) {
                    e.printStackTrace();
                    RequestDispatcher requestdispatcher = request.getRequestDispatcher("Error.jsp");
                    requestdispatcher.forward(request, response);
                }
            }
            else {
                try {
                	HttpSession session = request.getSession(true);
            		ArrayList<String> loadedPolls=new ArrayList<String>();
            		session.setAttribute("userID",(long)userID.doubleValue());
            		session.setAttribute("loadedPolls",loadedPolls);
                    session.setAttribute("fbLogin","true");
                    User u=new User();
                    u.setId(userID);
            		u=new UserDAO().getUserInfo(u);
            		if(u.getEmailID().equals("admin@poller.com"))
            		{
            			session.setAttribute("isAdmin",true);
                        JSONObject responseJSON = new JSONObject();
                        responseJSON.put("userExists", true);
                        responseJSON.put("url","addpoll.jsp");
                        responseJSON.put("userID", userID);
                        session.setAttribute("fbLogin","true");
                        String JSONString = responseJSON.toString();
                        response.setContentType("application/json");
                        response.setCharacterEncoding("UTF-8");
                        response.getWriter().write(JSONString);
            		}
            		else
            		{
                    JSONObject responseJSON = new JSONObject();
                    responseJSON.put("userExists", true);
                    responseJSON.put("url","home.jsp");
                    
                    responseJSON.put("userID", userID);
                    String JSONString = responseJSON.toString();
                    response.setContentType("application/json");
                    response.setCharacterEncoding("UTF-8");
                    response.getWriter().write(JSONString);
            		}
                }
                catch (Exception e) {
                    e.printStackTrace();
                    RequestDispatcher requestdispatcher = request.getRequestDispatcher("Error.jsp");
                    requestdispatcher.forward(request, response);
                }
            }
        }
        else if(fromFb.equals("linktrue")){
        	
        	user.setFb_userID(request.getParameter("fb_userID"));
            userID = new UserDAO().findUserByFbUserID(user);

            if (userID == null) {
                try {

                    JSONObject responseJSON = new JSONObject();
                    responseJSON.put("userExists", false);
                    String JSONString = responseJSON.toString();
                    response.setContentType("application/json");
                    response.setCharacterEncoding("UTF-8");
                    response.getWriter().write(JSONString);
                }
                catch (Exception e) {
                    e.printStackTrace();
                    RequestDispatcher requestdispatcher = request.getRequestDispatcher("Error.jsp");
                    requestdispatcher.forward(request, response);
                }
            }
            else {
                try {
                	HttpSession session = request.getSession(true);
            		ArrayList<String> loadedPolls=new ArrayList<String>();
            		session.setAttribute("userID",(long)userID.doubleValue());
            		session.setAttribute("loadedPolls",loadedPolls);
                    session.setAttribute("fbLogin","true");
                    User u=new User();
                    u.setId(userID);
            		u=new UserDAO().getUserInfo(u);
            		if(u.getEmailID().equals("admin@poller.com"))
            		{
            			session.setAttribute("isAdmin",true);
                        JSONObject responseJSON = new JSONObject();
                        responseJSON.put("userExists", true);
                        responseJSON.put("url","addpoll.jsp");
                        responseJSON.put("userID", userID);
                        session.setAttribute("fbLogin","true");
                        String JSONString = responseJSON.toString();
                        response.setContentType("application/json");
                        response.setCharacterEncoding("UTF-8");
                        response.getWriter().write(JSONString);
            		}
            		else
            		{
            		String param=request.getParameter("parameter").toString();
                    JSONObject responseJSON = new JSONObject();
                    responseJSON.put("userExists", true);
                    responseJSON.put("url","viewpoll.jsp?param="+param);
                    
                    responseJSON.put("userID", userID);
                    String JSONString = responseJSON.toString();
                    response.setContentType("application/json");
                    response.setCharacterEncoding("UTF-8");
                    response.getWriter().write(JSONString);
            		}
                }
                catch (Exception e) {
                    e.printStackTrace();
                    RequestDispatcher requestdispatcher = request.getRequestDispatcher("Error.jsp");
                    requestdispatcher.forward(request, response);
                }
            }
        	
        	
        	
        }
        
        else if(fromFb.equals("linkfalse")){
        	
        	
        	user.setEmailID(request.getParameter("emailID"));
            user.setPassword(DigestUtils.sha256Hex(request.getParameter("password")));
            userID = new UserDAO().findUserByEmailID(user);

            if (userID == null) {
              
                    RequestDispatcher requestdispatcher = request.getRequestDispatcher("wrongusernamepass.jsp");
                    requestdispatcher.forward(request, response);
                
            }
            else {
              
                User u=new User();
                u.setId(userID);
        		u=new UserDAO().getUserInfo(u);
        		if(u.getEmailID().equals("admin@poller.com"))
        		{
        			HttpSession session = request.getSession(true);
        			session.setAttribute("isAdmin",true);
            		ArrayList<String> loadedPolls=new ArrayList<String>();
            		session.setAttribute("userID",(long)userID.doubleValue());
            		session.setAttribute("loadedPolls",loadedPolls);
            		session.setAttribute("fbLogin","false");
                    RequestDispatcher requestdispatcher = request.getRequestDispatcher("viewpollstats.jsp");
                    requestdispatcher.forward(request, response);
                    
        		}
        		else{
            		HttpSession session = request.getSession(true);
            		ArrayList<String> loadedPolls=new ArrayList<String>();
            		session.setAttribute("userID",(long)userID.doubleValue());
            		session.setAttribute("loadedPolls",loadedPolls);
            		session.setAttribute("fbLogin","false");
            		String param=request.getParameter("parameter").toString();
                    RequestDispatcher requestdispatcher = request.getRequestDispatcher("viewpoll.jsp?param="+param);
                    requestdispatcher.forward(request, response);
        		}
            }
        	
        	
        	
        }
        
        
        
        
        else {
        	
        	
        	
        	
            user.setEmailID(request.getParameter("emailID"));
            user.setPassword(DigestUtils.sha256Hex(request.getParameter("password")));
            userID = new UserDAO().findUserByEmailID(user);

            if (userID == null) {
              
                    RequestDispatcher requestdispatcher = request.getRequestDispatcher("wrongusernamepass.jsp");
                    requestdispatcher.forward(request, response);
                
            }
            else {
              
                User u=new User();
                u.setId(userID);
        		u=new UserDAO().getUserInfo(u);
        		if(u.getEmailID().equals("admin@poller.com"))
        		{
        			HttpSession session = request.getSession(true);
        			session.setAttribute("isAdmin",true);
            		ArrayList<String> loadedPolls=new ArrayList<String>();
            		session.setAttribute("userID",(long)userID.doubleValue());
            		session.setAttribute("loadedPolls",loadedPolls);
            		session.setAttribute("fbLogin","false");
                    RequestDispatcher requestdispatcher = request.getRequestDispatcher("viewpollstats.jsp");
                    requestdispatcher.forward(request, response);
                    
        		}
        		else{
            		HttpSession session = request.getSession(true);
            		ArrayList<String> loadedPolls=new ArrayList<String>();
            		session.setAttribute("userID",(long)userID.doubleValue());
            		session.setAttribute("loadedPolls",loadedPolls);
            		session.setAttribute("fbLogin","false");
                    RequestDispatcher requestdispatcher = request.getRequestDispatcher("home.jsp");
                    requestdispatcher.forward(request, response);
        		}
            }
        }
    }

}
