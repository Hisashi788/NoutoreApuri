package model;

public class Account {
	private String Pass;
	private String Mail;
	private String Name;
	private int WordScore = 0;
	private int AnzanScore = 0;


		public Account (String Pass, String Mail, String Name, int WordScore, int AnzanScore) {
			this.Pass = Pass;
			this.Mail = Mail;
			this.Name = Name;
			this.WordScore = WordScore;
			this.AnzanScore = AnzanScore;
		}

		public Account () {}

		public int getWordScore() {
			return WordScore;
		}


		public int getAnzanScore() {
			return AnzanScore;
		}


		public String getPass() {
			return Pass;
		}

		public String getMail() {
			return Mail;
		}

		public String getName() {
			return Name;
		}
}
