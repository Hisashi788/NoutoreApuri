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

import model.Anzan;
import model.AnzanLogic;
import model.AnzanScore;
import model.AnzanScoreLogic;

/**
 * Servlet implementation class AnzanServlet
 */
@WebServlet("/AnzanServlet")
public class AnzanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	//AnzanLogicクラスを呼び出す
	AnzanLogic al = new AnzanLogic();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//AnzanLogicでできた問題を受け取る
		List<Anzan> anzanList = al.makeQuestionAnzanList();
        //anzanListがnullでなければスコープにリストを入れてanzan.jspにフォワードする
		if(anzanList != null) {
			request.setAttribute("anzanList", anzanList);
			RequestDispatcher dispatcher = request.getRequestDispatcher(
					"/WEB-INF/jsp/anzan.jsp");
			dispatcher.forward(request, response);
		}else {
			response.sendRedirect("/NoutoreApuri/WEB-INF/jsp/LoginOK.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int theNumberOfCorrectAnswers = 0;

		HttpSession session = request.getSession();

        //リクエストから入力した回答した値を取得
		request.setCharacterEncoding("UTF-8");
		String answer1  = request.getParameter("answer1");
		int answernum1 = Integer.parseInt(answer1);
		String answer2  = request.getParameter("answer2");
		int answernum2 = Integer.parseInt(answer2);
		String answer3  = request.getParameter("answer3");
		int answernum3 = Integer.parseInt(answer3);
		String answer4  = request.getParameter("answer4");
		int answernum4 = Integer.parseInt(answer4);
		String answer5  = request.getParameter("answer5");
		int answernum5 = Integer.parseInt(answer5);
		String answer6  = request.getParameter("answer6");
		int answernum6 = Integer.parseInt(answer6);
		String answer7  = request.getParameter("answer7");
		int answernum7 = Integer.parseInt(answer7);
		String answer8  = request.getParameter("answer8");
		int answernum8 = Integer.parseInt(answer8);
		String answer9  = request.getParameter("answer9");
		int answernum9 = Integer.parseInt(answer9);
		String answer10  = request.getParameter("answer10");
		int answernum10 = Integer.parseInt(answer10);

		//Integer型のリストを作りint型に変換した回答を入れた変数を挿入
		List<Integer> inputList = new ArrayList<Integer>();
	 	inputList.add(answernum1);
	 	inputList.add(answernum2);
	 	inputList.add(answernum3);
	 	inputList.add(answernum4);
	 	inputList.add(answernum5);
	 	inputList.add(answernum6);
	 	inputList.add(answernum7);
	 	inputList.add(answernum8);
	 	inputList.add(answernum9);
	 	inputList.add(answernum10);
        //取得した値を答え合わせ
		List<Boolean> resultList = al.makeResultList(inputList);
		//正解数カウント
		for(Boolean result : resultList) {
			if(result) {
				theNumberOfCorrectAnswers++;
			}
		}
		//正解数をセッションスコープに追加
		session.setAttribute("theNumberOfCorrectAnswers", theNumberOfCorrectAnswers);

        //暗算の最高得点をセッションスコープから取得
		int bestAnzanScore = (int) session.getAttribute("AnzanScore");
		String s1 = (String)session.getAttribute("Name");
        //今回の得点が最高得点を上回っていれば最高得点を更新する
		if(theNumberOfCorrectAnswers > bestAnzanScore) {
			AnzanScore anzanScore = new AnzanScore(theNumberOfCorrectAnswers,s1);
			AnzanScoreLogic wsl = new AnzanScoreLogic();
			boolean result1 = wsl.anzanScoreExecute(anzanScore);
            //最高得点を更新した場合、結果更新用画面に移動
			if(result1) {
				RequestDispatcher dispatcher1 = request.getRequestDispatcher(
					"/WEB-INF/jsp/anzanKekkaKoushin.jsp");
				dispatcher1.forward(request, response);
			}
		}
		//最高得点が上回っていない時通常の結果画面に移動
		RequestDispatcher dispatcher1 = request.getRequestDispatcher(
				"/WEB-INF/jsp/kekka.jsp");
		dispatcher1.forward(request, response);
        }


	}

