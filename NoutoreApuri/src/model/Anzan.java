package model;

import java.util.Random;
/**
 * 暗算クラス
 * 計算問題作るクラス
 */
public class Anzan {
	/** 右辺 */
	private int num1;
	/** 左辺 */
	private int num2;
	/** +-/* */
	private char operator;
	/** 答え */
	private int answer;
    /**
     * コンストラクター
     * 乱数を使って問題を作っている
     */
	public Anzan() {
		int num1 =new Random().nextInt(100) + 100;
		this.num1 = num1;

		int num2 =new Random().nextInt(100) + 10;
		this.num2 = num2;

		setOperatorAndAnswer();

	}

    /**
     * 計算式を作成した時に答えも出す
     */
	private void setOperatorAndAnswer() {
		int[] seq = new int[4];
		for(int i = 0; i < seq.length; i++) {
			seq[i] = new Random().nextInt(4);
		}

		for(int i = 0; i < seq.length; i++) {
			switch(seq[i]) {
			case 0:
				char operator0 = '+';
				this.answer = num1 + num2;
				this.operator = operator0;
				break;
			case 1:
				char operator1 = '-';
				this.answer = num1 - num2;
				this.operator = operator1;
				break;
			case 2:
				char operator2 = '*';
				this.answer = num1 * num2;
				this.operator = operator2;
				break;
			case 3:
				char operator3 = '/';
				this.answer = num1 / num2;
				this.operator = operator3;
				break;
			}
		}
	}
    /**
     * 答えを返す
     * @return
     */
	public int getAnswer() {
		return answer;
	}
    /**
     * 答えを返す（Integer型）
     * @return
     */
	public Integer getAnswerInt() {
		return answer;
	}


    /**
     * 右辺を返す
     * @return
     */
	public int getNum1() {
		return num1;
	}

    /**
     * 左辺を返す
     * @return
     */
	public int getNum2() {
		return num2;
	}



	public char getOperator() {
		return operator;
	}

}
