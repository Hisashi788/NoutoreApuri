package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import dao.WordDAO;
/**
 * WordLogicクラス
 * WordDAOクラスからワードを取得し問題を作成、答え合わせをするクラス
 * @author koikehisashi
 *
 */
public class WordLogic {
	/** WordDAO */
	private WordDAO wdao = new WordDAO();
	/** データベースからワードを取得したワードリスト */
	private List<Word> wordList = wdao.wordMaster();
	/** 合否判定よう⭕️と✖️が入ったリスト */
	private List<Character> wordResultCheckList = new ArrayList<>();
	/** 問題用ワードリスト */
	private List<Word> questionWordList = null;

	/**
	 *
	 * @return　questionWordLis
	 */
	public List<Word> getQuestionWordList() {
		return questionWordList;
	}
    /**
     * 問題１０問作成するメソッド
     * @return questionWordList 問題用ワードリスト
     */
	public List<Word> executeShuffles() {
		Collections.shuffle(wordList);
		questionWordList = wordList.subList(0, 10);
		return questionWordList;
	}
    /**
     * 答え合わせをするメソッド
     * @param wordInputList　回答した値が入ったリスト
     * @return wordResultCheckList　合否判定よう⭕️と✖️が入ったリスト
     */
	public List<Character> executeRsultCheckList(List<String> wordInputList){
		this.wordResultCheckList.clear();

		for(int i = 0; i < this.questionWordList.size(); i++) {
			String str1 = wordInputList.get(i);
			String str2 = this.questionWordList.get(i).getWordValue();
			boolean bo = (str1.equals(str2));
			if(bo) {
				char ch = '⭕';
				this.wordResultCheckList.add(ch);
			}else {
				 char ch1 = '✖';
				this.wordResultCheckList.add(ch1);
			}
		}
		return this.wordResultCheckList ;
	}
}
