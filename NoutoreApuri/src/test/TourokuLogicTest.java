package test;


import model.Touroku;
import model.TourokuLogic;

public class TourokuLogicTest {

	public static void main(String[] args) {
		testExecute1();

	}





	private static void testExecute1() {
		Touroku touroku = new Touroku("4321", "shangxiaochi73@gmail.com", "小池 尚");
		TourokuLogic bo1 = new TourokuLogic();
		boolean result = bo1.execute(touroku);
		if(result) {
			System.out.println("testExecute1:成功しました");
		}else {
			System.out.println("testExecute1:失敗しました");
		}
	}

}
