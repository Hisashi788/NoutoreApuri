package model;
/**
 * 登録クラス
 * このクラスは登録ホームで記入したユーザー情報を取得します
 * @author koikehisashi
 *
 */
public class Touroku {
	/** パスワード */
	private String Pass;
	/** メール */
	private String Mail;
	/** 名前 */
	private String Name;

	/**
	 * コンストラクター
	 * パスワード、メール、名前を取得設定する
	 * @param Pass
	 * @param Mail
	 * @param Name
	 */
	public Touroku(String Pass, String Mail, String Name) {
		this.Pass = Pass;
		this.Mail = Mail;
		this.Name = Name;
	}

	/** パスワード取得 */
	public String getPass() {
		return Pass;
	}

	/** メール取得 */
	public String getMail() {
		return Mail;
	}

	/** 名前取得 */
	public String getName() {
		return Name;
	}
}
