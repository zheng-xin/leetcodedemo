package leetcode.demos;
/**
 * 斐波那契数列
* @author: zhengxinm
* @Description:
* @date: 2020年5月14日 下午3:56:24 
* @version: nccnative
 */
public class Demo02 {
	public static void main(String[] args) {
		for (int i = 1;i<10;i++) {
			System.out.print(getCount(i) + ",");
		}
		System.out.println();
		for (int i = 1;i<10;i++) {
			System.out.print(getCount2(i) + ",");
		}
		
	}
	public  static int getCount(int n) {
		if (n == 1) {
			return 1;
		} else if (n == 2) {
			return 1;
		} else {
			return getCount(n-1) + getCount(n-2);
		}
	}
	public static int getCount2(int n) {
		if (n <= 2) {
			return 1;
		} else {
			int n_1 = 1;
			int n_2 = 1;
			int result = 0;
			for (int i = 3;i <= n;i++) {
				result =n_1 + n_2;
				int tmp = n_1;
				n_1 = result;
				n_2 = tmp;
			}
			return result;
		}
	}
	
}
