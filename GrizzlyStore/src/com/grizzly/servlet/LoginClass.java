package com.grizzly.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.grizzly.dao.LoginDAO;

/**
 * Servlet implementation class LoginClass
 */
@WebServlet(name = "Login", urlPatterns = { "/login" })
public class LoginClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	static int count = 1;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginClass() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uname = request.getParameter("uname");
		String pass = request.getParameter("pass");
		
		//PrintWriter out = response.getWriter();
		
		LoginDAO dao = new LoginDAO();
		if(dao.check(uname, pass)) {
			HttpSession session = request.getSession();
			session.setAttribute("username", uname);
			response.sendRedirect("welcome.jsp");
		}
		else {
			if(count==3){
				request.setAttribute("errorMessage", "You have exceeded the 3 failed login attempt. Please try loggin after some time.");
				RequestDispatcher rd = request.getRequestDispatcher("/Login.jsp");
				rd.include(request, response);
				count=0;
			}
			else{
				count++;
				request.setAttribute("errorMessage", "Invalid username or password");
				RequestDispatcher rd = request.getRequestDispatcher("/Login.jsp");
				rd.include(request, response);
				//response.sendRedirect("Login.jsp");
			}
			
		}
	}

}
