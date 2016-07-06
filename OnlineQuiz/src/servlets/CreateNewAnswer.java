package servlets;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.*;
import Repository.UnitOfWork;

/**
 * Servlet implementation class CreateNewAnswer
 */
@WebServlet("/CreateNewAnswer")
public class CreateNewAnswer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateNewAnswer() {
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
		
		String questionIDString = request.getParameter("questionID");
		String answerString = request.getParameter("answer");
		int questionID = Integer.parseInt(questionIDString);
		Question question = uwork.GetQuestions().Get(questionID);

		Answer answer = new Answer();
		answer.SetAnswer(answerString);
		
		
		switch(question.GetQuestionType()){
		case QuestionResponse:
			answer.SetAnswerType(true);
			answer.SetQuestion(question);
			uwork.GetAnswers().Save(answer);
			response.sendRedirect("EditQuestionResponse.jsp?id="+question.GetID());
		case PictureResponse:
			answer.SetAnswerType(true);
			answer.SetQuestion(question);
			uwork.GetAnswers().Save(answer);
			response.sendRedirect("EditPictureResponse.jsp?id="+question.GetID());
		}
	}
}
