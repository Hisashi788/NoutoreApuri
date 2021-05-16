package model;

import dao.AccountDAO;
/**
 * ログインロジッククラス
 * このクラスはアカウントDAOを呼び出しデータベース内に一致するデータがあればそのアカウントを返す
 * @author koikehisashi
 *
 */
public class LoginLogic {
	/**
	 * アカウントDAOを呼び出しfindByLoginメソッドの引数にログインを持してアカウントを取得し返す
	 * @param login 画面から取得したログイン情報
	 * @return account ログイン情報と一致したデータベースないのアカウント情報
	 */
	public Account execute(Login login) {
		AccountDAO dao = new AccountDAO();
		Account account = dao.findByLogin(login);
		return account;
	}
}
