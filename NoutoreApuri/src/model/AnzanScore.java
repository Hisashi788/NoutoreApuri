package model;
/**
 * 暗算スコアクラス
 * ハイスコア更新した時に使用するクラス
 * @author koikehisashi
 *
 */
public class AnzanScore {
	/** 暗算スコア */
	private int anzanScore = 0;
	/** プレイヤーネーム */
	private String name = null;

	/**
	 * コンストラクター
	 * 初期値設定
	 * @param anzanScore　更新したスコアー
	 * @param name　プレイヤーネーム
	 */
	public AnzanScore(int anzanScore, String name) {
		this.anzanScore = anzanScore;
		this.name = name;
	}

	/** 暗算スコアー取得 */
	public int getAnzanScore() {
		return anzanScore;
	}

	/** プレイヤーネーム取得 */
	public String getName() {
		return name;
	}
}
