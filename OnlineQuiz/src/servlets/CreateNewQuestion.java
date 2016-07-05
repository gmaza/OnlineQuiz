package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.Question;
import Models.Quiz;
import Repository.UnitOfWork;

/**
 * Servlet implementation class CreateNewQuestion
 */
@WebServlet("/CreateNewQuestion")
public class CreateNewQuestion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateNewQuestion() {
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
		UnitOfWork uwork = new UnitOfWork();		
		
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
		
		String name = request.getParameter("question");
		String quizID = request.getParameter("quizID");
		
		Question question = new Question();
		question.SetQuestion(name);
		question.SetQuestionType(1);
		question.SetQuiz(uwork.GetQuizes().Get(Integer.parseInt(quizID)));
		
		int id = uwork.GetQuestions().Save(question);
		
		response.sendRedirect("EditNewQuestionResponse.jsp?id="+id);
	}

}
