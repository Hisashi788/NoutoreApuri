package model;

import java.util.ArrayList;
import java.util.List;

/**
 * AnzanLogicクラス
 * 暗算問題のリスト作成、答え合わせをするクラス
 * @author koikehisashi
 *
 */
public class AnzanLogic {
	/** 問題のリスト */
	private List<Anzan> questionAnzanList = new ArrayList<>();
	/** 問題の正解リスト*/
	private List<Integer> answerList = new ArrayList<>();
	/** 合否判定リスト */
	private List<Boolean> resultList = new ArrayList<>();

	/**
	 * 暗算問題を10問作成リストに挿入
	 * @return 問題を返す
	 */
	public List<Anzan> makeQuestionAnzanList() {
		this.questionAnzanList.clear();
		for(int i = 0; i < 10; i++) {
			Anzan anzan = new Anzan();
			this.questionAnzanList.add(anzan);
		}
		return this.questionAnzanList;

	}

	/**
	 * questionAnzanListのanzanインスタンスから答えだけ抜き取りanswerListに挿入しなおす
	 * @return　answerList　問題の答えのみが入ったリスト返す
	 */
	private List<Integer> makeAnzanAnswerList() {
		this.answerList.clear();
		for(Anzan anzan : this.questionAnzanList){
			 this.answerList.add(anzan.getAnswer());
		}
		return this.answerList;
	}

	/**
	 * answerListとinputList比較し答え合わせをする
	 * @param inputList　回答を入れたリスト
	 * @return　resultList　trueかfalseが入ったリスト
	 */
	public List<Boolean> makeResultList(List<Integer> inputList){
		this.resultList.clear();
		makeAnzanAnswerList();

		for(int i = 0; i < this.answerList.size(); i++) {
			int v1 = inputList.get(i);
			int v2 = this.answerList.get(i);
			boolean bo = (v1 == v2);
			this.resultList.add(bo);
		}
		return this.resultList ;

	}



}
