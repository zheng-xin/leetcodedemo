package leetcode.demos;/**
 * 找字符串最长的回文子串
* @author: zhengxinm
* @Description:
* @date: 2020年5月14日 下午8:26:06 
* @version: nccnative
 */
public class Demo11 {
	public static String longestPalindrome(String s) {
		 if (s == null || s.length() < 1) return "";
		    int start = 0, end = 0;
		    for (int i = 0; i < s.length(); i++) {
		        int len1 = getLength(s, i, i);
		        int len2 = getLength(s, i, i + 1);
		        int len = Math.max(len1, len2);
		        if (len > end - start) {
		            start = i - (len - 1) / 2;
		            end = i + len / 2;
		        }
		    }
		    return s.substring(start, end + 1);

	}
	public static int getLength(String s,int left,int right) {//返回回文长度
		while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
			left --;
			right ++;
		}
		return right - left -1;
	}
	public static void main(String[] args) {
		System.out.println(longestPalindrome("aba"));
		System.out.println(3/2);
	}
}
