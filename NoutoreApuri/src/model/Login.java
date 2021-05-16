package model;
/**
 * ログインクラス
 * このクラスは画面の記入欄から取得したログイン情報を取得
 * @author koikehisashi
 *
 */
public class Login {
	/** 名前 */
	private String Name;
	/** パスワード */
	private String Pass;

	/**
	 * コンストラクター
	 * 名前、パスワード取得設定する
	 * @param Name
	 * @param Pass
	 */
	public Login(String Name, String Pass) {
		this.Name = Name;
		this.Pass = Pass;
	}
	/**
	 * 名前を取得
	 * @return Name
	 */
	public String getName() {
		return Name;
	}
	/**
	 * パスワード取得
	 * @return Pass
	 */
	public String getPass() {
		return Pass;
	}
}
