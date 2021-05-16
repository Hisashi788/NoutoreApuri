package model;

import dao.AccountDAO;
/**
 * 登録ロジッククラス
 * このクラスはアカウントDAOクラスを呼び出しデータベースにアカウントの追加を要求する
 * @author koikehisashi
 *
 */
public class TourokuLogic {
	/**
	 * アカウントDAOクラスを呼び出しデータベースにアカウントの追加しその結果を返す
	 * @param touroku 登録情報
	 * @return dao.create(touroku)
	 */
	public boolean execute(Touroku touroku) {
		AccountDAO dao = new AccountDAO();
		return dao.create(touroku);
	}
}
