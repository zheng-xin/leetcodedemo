package leetcode.demos;

import java.util.Iterator;
import java.util.LinkedList;
/**
 * 字符串加法  从后往前加 进位
 */
public class Demo01 {

	public static void main(String[] args) {
		getSum("1239","123");
	}
	public static String getSum(String str1,String str2) {
		if (str1 == null)
			return str2;
		if (str2 == null)
			return str1;
		int i = str1.length() -1;
		int j = str2.length() -1;
		int c = 0;
		LinkedList<Integer> list = new LinkedList<Integer>();
		while (i >= 0 || j >= 0 || c > 0) {
			int num1 = i >=0 && Integer.valueOf(str1.charAt(i) + "") > 0 ? Integer.valueOf(str1.charAt(i) + "") : 0;
			int num2 = j >=0 && Integer.valueOf(str2.charAt(j) + "") > 0 ? Integer.valueOf(str2.charAt(j) + "") : 0;
			int sunm = num1 + num2 + c;
			c = sunm / 10;
			list.addFirst(sunm % 10);
			j--;
			i--;
		}
		Iterator<Integer> it = list.iterator();
		while(it.hasNext()) {
			 Integer next = it.next();
			 System.out.print(next);
		}
		return "";
	}

}
