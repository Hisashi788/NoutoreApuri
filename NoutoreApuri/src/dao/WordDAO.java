package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Word;

/**
 * ワードDAOクラス
 * このクラスはワードテーブルを操作します
 * @author koikehisashi
 *
 */
public class WordDAO {
	private final String JDBC_URL =  "jdbc:h2:tcp://localhost/~/NA";
	private final String DB_USER = "na";
	private final String DB_PASS = "";
    /**
     * データベースからワードを取り出しリストに格納する
     * @return　lw 格納したワードリストを返す
     */
	public List<Word> wordMaster() {
		List<Word> lw = new ArrayList<Word>();

		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			String sql = "SELECT* FROM WORD";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			ResultSet rs = pStmt.executeQuery();

				while(rs.next()) {
					int wordId = rs.getInt("WORD_ID");
					String wordValue = rs.getString("WORD_VALUE");
					Word word = new Word (wordId, wordValue);
					lw.add(word);
				}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return lw;
	}
}
