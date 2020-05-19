package leetcode.demos;
/**
 * 滑动窗口找最大不重复子串
 */
import java.util.HashMap;
import java.util.Map;

public class Demo05 {
	public static void main(String[] args) {
//		System.out.println(getLength("absertyuiocaaabbbcdrfg123456789abcdefg"));
		System.out.println(getLength("abbcade"));
	}
	public static Integer getLength(String str) {
		if (str == null || str.length() == 0) {
			return 0;
		}
		int left = 0;
		int right = 0;
		int max = 0;
		int length = str.length();
		int start = 0;
		int end = 0;
		Map<Character,Integer> map = new HashMap<Character,Integer>();
		while (right < length) {
			char ch = str.charAt(right);
			Integer index = map.get(ch);
			if (index != null) {
				left = Math.max(index + 1, left);
			} 
			map.put(ch, right);
			if (right - left + 1 > max) {
				start = left;
				end = right;
			}
			max = Math.max(right - left + 1, max);
			right ++;
		}
		System.out.println(str.substring(start, end + 1));
		return max;
	}
}
