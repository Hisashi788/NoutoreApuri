package model;

/**
 * ワードクラス
 * このクラスはワードIDとデータベースからのワードを取得する
 * @author koikehisashi
 *
 */
public class Word {
	/** ワードID */
	private int wordId;
	/** ワードvalue */
	private String wordValue;

    /**
     * コンストラクター
     * ワードID,ワードvalueの初期設定
     * @param wordId
     * @param wordValue
     */
	public Word(int wordId, String wordValue) {
		this.wordId = wordId;
		this.wordValue = wordValue;
	}

	/**
	 * ワードIDを取得
	 * @return wordId
	 */
	public int getWordId() {
		return this.wordId;
	}

    /**
     * ワードvalueを取得
     * @return wordValue
     */
	public String getWordValue() {
		return this.wordValue;
	}
}
