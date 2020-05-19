package leetcode.demos;/**
 * 找出数组中仅出现过一次的数字  异或运算
* @author: zhengxinm
* @Description:
* @date: 2020年5月14日 下午3:58:27 
* @version: nccnative
 */
public class Demo08 {
	public static int singleNumber(int[] nums) {
		int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
	}
	public static void main(String[] args) {
		System.out.println(singleNumber(new int[] {1,2,3,3,2}));
	}
}
