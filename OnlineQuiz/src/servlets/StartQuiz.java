package servlets;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.*;
import Repository.UnitOfWork;

/**
 * Servlet implementation class StartQuiz
 */
@WebServlet("/StartQuiz")
public class StartQuiz extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StartQuiz() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		String quizIdString = request.getParameter("quizID");		
		
		UnitOfWork uwork = new UnitOfWork();
		
		Quiz quiz = uwork.GetQuizes().Get(Integer.parseInt(quizIdString));
		
		Result result = new Result();
		result.SetStartDate(new Date());
		result.SetScore(0);
		result.SetQuiz(quiz);
		result.SetUser(uwork.GetUsers().Get(username));
		
		int questionID = uwork.GetQuestions().GetAll(quiz.GetID()).get(0).GetID();
		
		uwork.GetResults().Save(result);
		response.sendRedirect("StartQuiz.jsp?questionID="+questionID);
	}

}
