package leetcode.demos;/**
 * �ҳ������н����ֹ�һ�ε�����  �������
* @author: zhengxinm
* @Description:
* @date: 2020��5��14�� ����3:58:27 
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
