package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Account;
import model.Login;
import model.LoginLogic;

/**
 *Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//login.jspへフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher(
				"/WEB-INF/jsp/login.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//loginフォームに入力した値を取得
		request.setCharacterEncoding("UTF-8");
		String Name = request.getParameter("Name");
		String Pass = request.getParameter("Pass");
        //データベースを利用してログイン情報を照合する
		Login login = new Login(Name, Pass);
		LoginLogic bo = new LoginLogic();
		Account result = (Account) bo.execute(login);
        //照合できたらName,WordScore,AnzanScoreをスコープに格納する
		if(result!= null) {
			HttpSession session = request.getSession();
			session.setAttribute("Name", Name);
			session.setAttribute("WordScore", result.getWordScore());
			session.setAttribute("AnzanScore", result.getAnzanScore());
        //照合できたらloginOK.jspにフォワードするできなければLoginServletへリダイレクトする
			RequestDispatcher dispatcher = request.getRequestDispatcher(
				"/WEB-INF/jsp/loginOK.jsp");
			dispatcher.forward(request, response);
		}else {
			response.sendRedirect("/NoutoreApuri/LoginServlet");
		}
	}
}
