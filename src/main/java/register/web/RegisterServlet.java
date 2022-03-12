package register.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

import register.dao.UserDao;
import register.model.User;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserDao userDao;

    public void init() {
    	userDao = new UserDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {

    	String username = request.getParameter("username");
		String password = request.getParameter("password");
		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		String birthday = request.getParameter("birthday");
		Integer streetnumber = Integer.parseInt(request.getParameter("streetnumber"));
		String street = request.getParameter("street");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		Integer zipcode = Integer.parseInt(request.getParameter("zipcode"));
		Integer ppsbalance = 0;
		Double bankbalance = 1000.00;
		
		
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setFirstname(firstName);
		user.setLastname(lastName);
		user.setBirthday(birthday);
		user.setStreetnumber(streetnumber);
		user.setStreet(street);
		user.setCity(city);
		user.setState(state);
		user.setZipcode(zipcode);
		user.setPpsbalance(ppsbalance);
		user.setBankbalance(bankbalance);

        try {
        	userDao.registerUser(user);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            //e.printStackTrace();
        }

        response.sendRedirect("details.jsp");
    }
}