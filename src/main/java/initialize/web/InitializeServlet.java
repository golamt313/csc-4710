package initialize.web;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import initialize.database.InitializeDao;


@WebServlet("/initialize")
public class InitializeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private InitializeDao initializeDao;

    public void init() {
    	initializeDao = new InitializeDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
       
        	try {
	        	HttpSession session = request.getSession();
	            if (initializeDao.initialize()) {
	            	response.sendRedirect("initializesuccess.jsp");
	                //session.setAttribute("username",username);
	            } else {
	                //session.setAttribute("user", username);
	                response.sendRedirect("initializefail.jsp");
	            }
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        }
    }
}