package servlets;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Database.DatabaseHelper;
import Interfaces.IUserRepository;
import Repository.UnitOfWork;
import Repository.UserRepository;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DatabaseHelper helper = new DatabaseHelper();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		ServletConfig sg=getServletConfig();
		ServletContext sc= sg.getServletContext();
		UnitOfWork uwork = (UnitOfWork)sc.getAttribute("uwork");
		
		IUserRepository userRepo = uwork.GetUsers();
		String token = userRepo.Login(username, password);
		if(token.isEmpty()) {
			response.sendRedirect("Login.jsp");
			return;
		}
		Cookie cookie = new Cookie("username", username);
	    response.addCookie(cookie);
	    
	    Cookie cookieToken = new Cookie("loginToken", token);
	    response.addCookie(cookieToken);
	    response.addCookie(cookie);
	    
	    response.sendRedirect("index.jsp");
	}

}
