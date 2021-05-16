package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Word;
import model.WordLogic;
import model.WordScore;
import model.WordScoreLogic;

/**
 * Servlet implementation class WordServlet
 */
@WebServlet("/WordServlet")
public class WordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    //WordLogicを呼び出す
	WordLogic wl = new WordLogic();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//セッションスコープを呼び出す
		HttpSession session = request.getSession();
		//WordLogicからシャフルした問題のリスト呼び出す
		List<Word> questionWordList = wl.executeShuffles();
        //questionWordListの中身がnull出なければanki.jspへフォワードそうでなければLoginOK.jspへリダイレクト
		if(questionWordList != null) {
			session.setAttribute("questionWordList", questionWordList);
			RequestDispatcher dispatcher = request.getRequestDispatcher(
					"/WEB-INF/jsp/anki.jsp");
			dispatcher.forward(request, response);
		}else {
			response.sendRedirect("/NoutoreApuri/WEB-INF/jsp/LoginOK.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int theNumberOfCorrectAnswers = 0;
		//セッションスコープを呼び出す
		HttpSession session = request.getSession();
		//リクエストから入力した回答の値を取得
		request.setCharacterEncoding("UTF-8");
		String answer1  = request.getParameter("answer1");
		String answer2  = request.getParameter("answer2");
		String answer3  = request.getParameter("answer3");
		String answer4  = request.getParameter("answer4");
		String answer5  = request.getParameter("answer5");
		String answer6  = request.getParameter("answer6");
		String answer7  = request.getParameter("answer7");
		String answer8  = request.getParameter("answer8");
		String answer9  = request.getParameter("answer9");
		String answer10  = request.getParameter("answer10");
        //回答した値をリストに挿入
		List<String> wordInputList = new ArrayList<>();
	 	wordInputList.add(answer1);
	 	wordInputList.add(answer2);
	 	wordInputList.add(answer3);
	 	wordInputList.add(answer4);
	 	wordInputList.add(answer5);
	 	wordInputList.add(answer6);
	 	wordInputList.add(answer7);
	 	wordInputList.add(answer8);
	 	wordInputList.add(answer9);
	 	wordInputList.add(answer10);
        //wordInputListを引数に入れて⭕️、❌が入ったリストを受け取る
		List<Character> resultCheckList = wl.executeRsultCheckList(wordInputList);
		//セッションスコープに入れた問題と同じ問題を呼び出す
		List<Word> questionWordList = wl.getQuestionWordList();
		char a = '⭕';
        //resultCheckList
		for(Character result : resultCheckList) {
			if(result == a) {
				theNumberOfCorrectAnswers++;
			}
		}
		//スコープにtheNumberOfCorrectAnswers、questionWordList、wordInputList、resultCheckListを追加
	    session.setAttribute("theNumberOfCorrectAnswers", theNumberOfCorrectAnswers);
	    session.setAttribute("questionWordList", questionWordList);
	    request.setAttribute("wordInputList",wordInputList);
	    session.setAttribute("resultCheckList", resultCheckList);
        //スコープからWordScoreとNameを取得theNumberOfCorrectAnswers と比較しハイスコアー更新した場合wordKoushin.jspそうでない場合wordkekka.jspにフォワードする
		int a1 = (int) session.getAttribute("WordScore");
		String s1 = (String)session.getAttribute("Name");
		 if(theNumberOfCorrectAnswers > a1) {
			 WordScore wordScore = new WordScore(theNumberOfCorrectAnswers,s1);
			 WordScoreLogic wsl = new WordScoreLogic();
			 boolean result1 = wsl.scoreExecute(wordScore);
			 if(result1) {
				 RequestDispatcher dispatcher1 = request.getRequestDispatcher(
						"/WEB-INF/jsp/wordKoushin.jsp");
				 dispatcher1.forward(request, response);
			 }
		 }
		 RequestDispatcher dispatcher = request.getRequestDispatcher(
			  "/WEB-INF/jsp/wordkekka.jsp");
		 dispatcher.forward(request, response);
        }
}
