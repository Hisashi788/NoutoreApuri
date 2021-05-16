package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Account;
import model.AnzanScore;
import model.Login;
import model.Touroku;
import model.WordScore;

public class AccountDAO {
	private final String JDBC_URL =  "jdbc:h2:tcp://localhost/~/NA";
	private final String DB_USER = "na";
	private final String DB_PASS = "";
    /**
     * ログイン情報を使ってアカウント取得
     * @param login 画面から入力したログイン情報
     * @return 検索できた時だけアカウント情報返すできなければnullを返す
     *
     */
	public Account findByLogin(Login login) {
		Account account = null;
		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			String sql = "SELECT * FROM ACCOUNT WHERE NAME = ? AND PASS = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, login.getName());
			pStmt.setString(2, login.getPass());

			ResultSet rs = pStmt.executeQuery();
			if(rs.next()) {
				String pass = rs.getString("PASS");
				String mail = rs.getString("MAIL");
				String name = rs.getString("NAME");
				int wordScore = rs.getInt("WORDSCORE");
				int anzanScore = rs.getInt("ANZANSCORE");
				account = new Account (pass, mail, name,  wordScore, anzanScore);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return account;
	}
    /**
     *登録情報をデータベースにインサートする
     * @param touroku 新しく入力したユーザー情報
     * @return　登録できたらtrueできなければfalse
     */
	public boolean create(Touroku touroku) {
		boolean result = false;

		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			String sql = "INSERT INTO ACCOUNT VALUES (?,?,?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, touroku.getName());
			pStmt.setString(2, touroku.getMail());
			pStmt.setString(3, touroku.getPass());

			int rs = pStmt.executeUpdate();
			if(rs != 0) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return result;
		}
		return result;
	}

	/**
	 * ワードスコア情報を使ってデータベースwordScore更新
	 * @param wordScore　更新するワードスコアー
	 * @return　更新できればtrueできなければfalse
	 */
	public boolean wordUpdate(WordScore wordScore) {
		boolean result = false;

		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			String sql = "UPDATE account SET wordscore = ?  WHERE name = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, wordScore.getWordScore());
			pStmt.setString(2, wordScore.getName());

			int rs = pStmt.executeUpdate();

			if(rs != 0) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return result;
		}
		return result;
	}

	/**
	 * 暗算スコア情報を使ってデータベースanzanScore更新
	 * @param anzanScore　更新するワードスコアー
	 * @return　更新できればtrueできなければfalse
	 */
	public boolean anzanUpdate(AnzanScore anzanScore) {
		boolean result = false;

		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			String sql = "UPDATE account SET anzanscore = ?  WHERE name = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, anzanScore.getAnzanScore());
			pStmt.setString(2, anzanScore.getName());

			int rs = pStmt.executeUpdate();

			if(rs != 0) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return result;
		}
		return result;
	}
}
