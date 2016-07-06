package servlets;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.Answer;
import Models.AnswerResult;
import Models.Quiz;
import Models.Result;
import Repository.UnitOfWork;

/**
 * Servlet implementation class FinishQuiz
 */
@WebServlet("/FinishQuiz")
public class FinishQuiz extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FinishQuiz() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletConfig sg=getServletConfig();
		ServletContext sc= sg.getServletContext();
		UnitOfWork uwork = (UnitOfWork)sc.getAttribute("uwork");
		
		int typ = Integer.parseInt(request.getParameter("typ"));
		int questionID = Integer.parseInt(request.getParameter("questionID"));
		int resultID = Integer.parseInt(request.getParameter("id"));
		switch (typ){
		case 0:
			String answerString = request.getParameter("answer");
			Result result = uwork.GetResults().Get(resultID);
			
			boolean isCorrect = false;
			
			List<Answer> correctAnswers = uwork.GetAnswers().GetAll(questionID);
			for(Answer correctAnswer : correctAnswers){
				isCorrect = isCorrect || correctAnswer.GetAnswer().equals(answerString);
			}			
			if(isCorrect){				
				result.SetScore(result.GetScore() + 1);				
			}
			AnswerResult resAnswer = new AnswerResult();
			resAnswer.SetText(answerString);
			resAnswer.SetResult(uwork.GetResults().Get(resultID));
			result.SetEndDate(new Date());
			uwork.GetResults().Update(result);
			long resultDur = ((result.GetEndDate().getTime()/60000) - (result.GetStartDate().getTime()/60000));
			response.sendRedirect("Result.jsp?score=" + result.GetScore() + "&duration=" + resultDur);
		}
	}

}
