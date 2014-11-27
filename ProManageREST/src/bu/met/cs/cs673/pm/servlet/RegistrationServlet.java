package bu.met.cs.cs673.pm.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bu.met.cs.cs673.pm.dao.UserDAO;
import bu.met.cs.cs673.pm.dto.User;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationServlet() 
    {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException 
	{
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException 
	{
		System.out.println(">>> RegistrationServlet");
		/*
		String email = request.getParameter("email");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		
		User user = new User();
		user.setEmail(email);
		user.setFirstname(firstname);
		user.setLastname(lastname);
		user.setUsername(username);
		user.setPassword(password);
		
		if (!validateUser(user))
		{
			response.sendError(500,  "Invalid input");
		}
		
		//insert user into the database
		UserDAO dao = new UserDAO();
		dao.insert(user);
		*/
		System.out.println("<<< RegistrationServlet");
		
		//redirect to the login page when the user is created
		response.sendRedirect("index.html");
	}
	
	/**
	 * validateUser
	 * 
	 * Validates the user input.
	 * 
	 * @param user
	 * @return
	 */
	private boolean validateUser(User user)
	{
		boolean isValid = true;
		
		if (user.getUsername() == null ||
			user.getPassword() == null ||
			user.getFirstname() == null ||
			user.getLastname() == null ||
			user.getEmail() == null)
		{
			isValid = false;
		}
		else if ("".equals(user.getUsername()) || 
				 "".equals(user.getPassword()) ||
				 "".equals(user.getFirstname()) ||
				 "".equals(user.getLastname()) ||
				 "".equals(user.getEmail()))
		{
			isValid = false;
		}
		
		return isValid;
	}
	
}
