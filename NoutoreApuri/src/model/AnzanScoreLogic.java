package model;

import dao.AccountDAO;
/**
 * 暗算ロジッククラス
 * このクラスはアカウントDAOクラスを呼び出し暗算スコアーの更新を要求する
 * @author koikehisashi
 *
 */
public class AnzanScoreLogic {
	    /**
	     * アカウントDAOクラスを呼び出しanzanUpdateメソッドの引数にanzanScoreを持たせ暗算スコアーの更新を要求する
	     * @param anzanScore スコア更新用クラス
	     * @return upAnzan スコア更新できればtrueできなければfalse
	     */
		public boolean anzanScoreExecute(AnzanScore anzanScore) {
			AccountDAO dao = new AccountDAO();
			boolean upAnzan = dao.anzanUpdate(anzanScore);
			return upAnzan;
		}
}
