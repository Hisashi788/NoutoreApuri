package model;

/**
 * ワードスコアークラス
 * このクラスはプレイヤーの名前と更新用のスコアを取得する
 * @author koikehisashi
 *
 */
public class WordScore {
	/** ワードスコアー */
	private int wordScore = 0;
	/** 名前 */
	private String name = null;

	/**
	 * コンストラクター
	 * 名前、スコアー取得初期設定
	 * @param wordScore
	 * @param name
	 */
	public WordScore(int wordScore, String name) {
		this.wordScore = wordScore;
		this.name = name;
	}

	/**
	 * ワードスコア取得
	 * @return　wordScore
	 */
	public int getWordScore() {
		return wordScore;
	}

	/**
	 * 名前取得
	 * @return name
	 */
	public String getName() {
		return name;
	}
}
