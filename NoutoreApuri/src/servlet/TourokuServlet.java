package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Touroku;
import model.TourokuLogic;

/**
 * Servlet implementation class TourokuServlet
 */
@WebServlet("/TourokuServlet")
public class TourokuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//TourokuServletへフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher(
			 "/WEB-INF/jsp/touroku.jsp");
		dispatcher.forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 登録フォームに記入した値を取得する
		request.setCharacterEncoding("UTF-8");
		String Name = request.getParameter("Name");
		String Mail = request.getParameter("Mail");
		String Pass = request.getParameter("Pass");
        // データベースにName,Mail,Passを登録する
		Touroku touroku = new Touroku(Name, Mail, Pass);
		TourokuLogic bo1 = new TourokuLogic();
		boolean result = bo1.execute(touroku);
        //登録できたらWelcomeServletへフォワードするできなければTourokuServletへリダイレクト
		if(result) {
			response.sendRedirect("/NoutoreApuri/WelcomeServlet");
		}else {
			response.sendRedirect("/NoutoreApuri/TourokuServlet");
		}
	}
}
