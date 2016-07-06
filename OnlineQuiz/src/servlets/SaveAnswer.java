package servlets;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.Answer;
import Models.Question;
import Models.Result;
import Repository.UnitOfWork;

/**
 * Servlet implementation class SaveAnswer
 */
@WebServlet("/SaveAnswer")
public class SaveAnswer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SaveAnswer() {
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
		
		int typ = Integer.parseInt(request.getParameter("typ"));
		int questionID = Integer.parseInt(request.getParameter("questionID"));
		int resultID = Integer.parseInt(request.getParameter("id"));
		switch (typ){
		case 0:
			String answerString = request.getParameter("answer");
			
			boolean isCorrect = false;
			
			List<Answer> correctAnswers = uwork.GetAnswers().GetAll(questionID);
			for(Answer correctAnswer : correctAnswers){
				isCorrect = isCorrect || correctAnswer.equals(correctAnswer);
			}			
			if(isCorrect){
				Result result = uwork.GetResults().Get(resultID);
				result.SetScore(result.GetScore() + 1);
				uwork.GetResults().Update(result);
			}
		}

	}

}
