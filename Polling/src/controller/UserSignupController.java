
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

@WebServlet("/UserSignupController")
public class UserSignupController extends HttpServlet {

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

        String fbUserID = request.getParameter("fb_userID");

        User user = new User();

        if (fbUserID != null) {

            user.setFb_userID(fbUserID);
            user.setAge(Integer.parseInt(request.getParameter("age")));
            user.setSex(request.getParameter("gender"));
            user.setFullName(request.getParameter("name"));
            user.setEmailID(request.getParameter("email"));
            user.setPassword("");

            long userID  = new UserDAO().createUserProfile(user);
            
            HttpSession session = request.getSession(true);
    		ArrayList<String> loadedPolls=new ArrayList<String>();
    		session.setAttribute("userID",userID);
    		session.setAttribute("loadedPolls",loadedPolls);
            session.setAttribute("fbLogin","true");
            JSONObject responseJSON = new JSONObject();

            try {
                if (userID == -1) {
                    responseJSON.put("url", "Polling/FBloginfail.jsp");
                }
                else {
                    responseJSON.put("url", "Polling/home.jsp");
                }
                session.setAttribute("fbLogin","true");
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

            user.setFb_userID("none");
            user.setAge(0);
            user.setSex("");
            user.setFullName("");
            user.setEmailID(request.getParameter("emailID"));
            user.setPassword(DigestUtils.sha256Hex(request.getParameter("signuppassword")));
            
            HttpSession session = request.getSession(true);
    		ArrayList<String> loadedPolls=new ArrayList<String>();

    		session.setAttribute("loadedPolls",loadedPolls);
    		session.setAttribute("fbLogin","false");

            long status = new UserDAO().createUserProfile(user);
            long userID=(long)new UserDAO().getUserInfo(user).getId();
    		session.setAttribute("userID",userID);

                if (status == -1) {
                	RequestDispatcher requestdispatcher = request.getRequestDispatcher("Error.jsp");
                    requestdispatcher.forward(request, response);
                }
                else {
                	RequestDispatcher requestdispatcher = request.getRequestDispatcher("home.jsp");
                    requestdispatcher.forward(request, response);
                }
               
         
                
            
        }
    }
}
