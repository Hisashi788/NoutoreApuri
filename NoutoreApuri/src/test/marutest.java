package test;

import java.util.ArrayList;
import java.util.List;

public class marutest {

	public static void main(String[] args) {
		System.out.println(execute3());

	}
	  static List<Character> maru = new ArrayList<>();

		public static List<Character> execute3(){
			String str1 = "小池";
			String str2 = "小池";
				boolean bo = (str1.equals(str2));
				if(bo) {
					char ch = '⭕';
					maru.add(ch);
				}else {
					 char ch1 = '✖';
					maru.add(ch1);
				}
				return maru;
		}
}
