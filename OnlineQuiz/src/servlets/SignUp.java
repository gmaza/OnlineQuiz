package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.User;
import Repository.UserRepository;

/**
 * Servlet implementation class SignUp
 */
@WebServlet("/SignUp")
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUp() {
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
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("confirmPassword");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String age = request.getParameter("age");
		String mail = request.getParameter("mail");
		
		User user = new User();
		user.SetAge(Integer.parseInt(age));
		user.SetFirstname(firstname);
		user.SetLastname(lastname);
		user.SetMail(mail);
		user.SetScore(0);
		user.SetUsername(username);
		user.SetPasswordHash(password);
		
		UserRepository userRepo = new UserRepository();
		
		if(userRepo.Get(username)==null || !password.equals(confirmPassword) || password.isEmpty()){
			response.sendRedirect("Register.jsp");
			return;
		}
		
		userRepo.Save(user);
		
		String token = userRepo.Login(username, password);
		
		Cookie cookie = new Cookie("username", username);
	    response.addCookie(cookie);
	    
	    Cookie cookieToken = new Cookie("loginToken", token);
	    response.addCookie(cookieToken);
	    
	    response.sendRedirect("index.jsp");
	}

}
