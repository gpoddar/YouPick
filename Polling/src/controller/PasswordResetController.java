package controller;

import java.io.IOException;
import java.math.BigInteger;
import java.security.SecureRandom;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;


import org.apache.commons.codec.digest.DigestUtils;

import DAO.UserDAO;

/**
 * Servlet implementation class PasswordResetController
 */
@WebServlet("/PasswordResetController")
public class PasswordResetController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PasswordResetController() {
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
		
		String email=request.getParameter("email");
		
		SecureRandom random = new SecureRandom();
		
		String newPass="PASS"+new BigInteger(130, random).toString(32).toLowerCase();
		
		String hashed=DigestUtils.sha256Hex(newPass);
		
		new UserDAO().resetPassword(email,hashed);
		
		
		
		
		
		// Recipient's email ID needs to be mentioned.
	      String to = "email";

	      // Sender's email ID needs to be mentioned
	      String from = "admin@poller.com";

	      // Get system properties
	      Properties properties = System.getProperties();

	      // Setup mail server
	      properties.setProperty("mail.smtp.host","localhost");
	      properties.setProperty("mail.smtp.port", "8080");

	      // Get the default Session object.
	      Session session = Session.getDefaultInstance(properties);

	      try{
	         // Create a default MimeMessage object.
	         MimeMessage message = new MimeMessage(session);

	         // Set From: header field of the header.
	         message.setFrom(new InternetAddress(from));

	         // Set To: header field of the header.
	         message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

	         // Set Subject: header field
	         message.setSubject("Password reset");

	         // Now set the actual message
	         message.setText("your password has been reset to the following "+newPass);

	         // Send message
	         Transport.send(message);
	      }catch (MessagingException mex) {
	         mex.printStackTrace();
	      }
		
		
		
		
		
		
		
		
		
		
		response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");
	    response.getWriter().write(newPass);
		
		
		
	}

}
