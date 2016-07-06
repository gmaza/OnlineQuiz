package servlets;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.CORBA.INTERNAL;

import Models.Answer;
import Models.AnswerResult;
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
		ServletConfig sg=getServletConfig();
		ServletContext sc= sg.getServletContext();
		UnitOfWork uwork = (UnitOfWork)sc.getAttribute("uwork");

		int typ = Integer.parseInt(request.getParameter("typ"));
		int questionID = Integer.parseInt(request.getParameter("questionID"));
		int resultID = Integer.parseInt(request.getParameter("id"));
		switch (typ){
		case 0:{
			String answerString = request.getParameter("answer");

			boolean isCorrect = false;

			List<Answer> correctAnswers = uwork.GetAnswers().GetAll(questionID);
			for(Answer correctAnswer : correctAnswers){
				isCorrect = isCorrect || correctAnswer.GetAnswer().equals(answerString);
			}			
			if(isCorrect){
				Result result = uwork.GetResults().Get(resultID);
				result.SetScore(result.GetScore() + 1);
				uwork.GetResults().Update(result);
			}
			AnswerResult resAnswer = new AnswerResult();
			resAnswer.SetText(answerString);
			resAnswer.SetResult(uwork.GetResults().Get(resultID));
			uwork.GetResults().SaveAnswerResult(resAnswer);
			response.sendRedirect("StartQuiz.jsp?id=" + resultID +"&questionID="+ uwork.GetQuestions().GetNextQuestion(questionID).GetID());
			break;
		}
		case 1:{
			String answerString = request.getParameter("answer");

			boolean isCorrect = false;

			Answer correctAnswers = uwork.GetAnswers().Get(Integer.parseInt(answerString));
			isCorrect = correctAnswers.GetAnswerType();
			if(isCorrect){
				Result result = uwork.GetResults().Get(resultID);
				result.SetScore(result.GetScore() + 1);
				uwork.GetResults().Update(result);
			}
			AnswerResult resAnswer = new AnswerResult();
			resAnswer.SetText(answerString);
			resAnswer.SetResult(uwork.GetResults().Get(resultID));
			uwork.GetResults().SaveAnswerResult(resAnswer);
			response.sendRedirect("StartQuiz.jsp?id=" + resultID +"&questionID="+ uwork.GetQuestions().GetNextQuestion(questionID).GetID());
		}
		}

	}

}
