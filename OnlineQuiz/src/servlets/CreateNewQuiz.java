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

import Models.Quiz;
import Repository.UnitOfWork;

/**
 * Servlet implementation class CreateNewQuiz
 */
@WebServlet("/CreateNewQuiz")
public class CreateNewQuiz extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateNewQuiz() {
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
		ServletConfig sg=getServletConfig();
		ServletContext sc= sg.getServletContext();
		UnitOfWork uwork = (UnitOfWork)sc.getAttribute("uwork");		
		
		String username = "";
		String loginToken = "";
		Cookie cookie = null;
		Cookie[] cookies = null;
		cookies = request.getCookies();
		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				cookie = cookies[i];
				if (cookie.getName().equals("username"))
					username = cookie.getValue();
				else if (cookie.getName().equals("loginToken"))
					loginToken = cookie.getValue();
			}
		}
		
		String name = request.getParameter("name");
		
		Quiz quiz = new Quiz();
		quiz.SetName(name);
		quiz.SetAuthor(uwork.GetUsers().Get(username));
		
		int id = uwork.GetQuizes().Save(quiz);
		
		response.sendRedirect("EditQuiz.jsp?id="+id);
	}

}
