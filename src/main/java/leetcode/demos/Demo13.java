package leetcode.demos;
import java.util.Stack;

//首先考虑的是int类型的溢出，int正数最大值2147483647负数最大值-2147483648，因此需要一位一位的判断，只看前9位，如果前9位比214748364大的话，肯定就溢出了，如果前9位等于14748364，此时就要看最后一位，若大于7那就溢出，直接返回0
//1.用取余的方式吧数字倒着取出来。
//2.吧int值再除以10向前移一位
//3.判断反转后的值是否小于2147483647或者是否大于-2147483648，如果是返回0
//4.用反转后的值乘10加上第一步取余的值。
//5最后返回

public class Demo13 {
	public static int reverse(int x) { //自己写的  思路不对 比较慢
		
		Stack<Character> stack = new Stack<Character>();
		String str = String.valueOf(x);
		boolean flag = false;
		for (int i = 0;i < str.length(); i ++) {
			if (str.charAt(i) =='-' && i == 0) {
				flag = true;
				continue;
			}
			stack.push(str.charAt(i));
		}
		if (flag) {
			stack.push('-');
		}
		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty()) {
			char c= stack.pop();
			sb.append(c);
		}
		Long result = Long.valueOf(sb.toString());
		if (result.longValue() > Integer.MAX_VALUE || result.longValue() < Integer.MIN_VALUE) {
			return 0;
		}
		return Integer.valueOf(sb.toString());
		
		
    }
	
	public static int reverse2(int x) {
		int result = 0;
		while (x != 0) {
			int last = x % 10;
			x = x / 10;
			if (result>214748364 || (result==214748364 && last>7)) { //整数最大的尾数是7，如果>7则溢出返回0
                return 0;
            }
            if (result<-214748364 || (result==-214748364 && last<-8)) {//整数最小的尾数是-8，如果<-8则溢出返回0
                return 0;
            }
			result = result * 10 + last;
		}
		return result;
	}
	public static void main(String[] args) {
		System.out.println(reverse2(1534236469));
	}
}
