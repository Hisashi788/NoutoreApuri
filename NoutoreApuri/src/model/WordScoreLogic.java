package model;

import dao.AccountDAO;

/**
 * ワードスコアロジッククラス
 * このクラスはアカウントDAOクラスを呼び出しスコア更新を要求する
 * @author koikehisashi
 *
 */
public class WordScoreLogic {
	/**
	 * アカウントDAOクラスを呼び出しスコア更新を要求し更新できたらtureできなければfalseを返す
	 * @param wordScore
	 * @return  account
	 */
	public boolean scoreExecute(WordScore wordScore) {
		AccountDAO dao = new AccountDAO();
		boolean account = dao.wordUpdate(wordScore);
		return account;

	}

}
