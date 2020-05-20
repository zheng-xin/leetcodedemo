package leetcode.demos;
public class Demo14 {
	 public static boolean IsPalindrome(int x) {
	        // ���������
	        // ������������ x < 0 ʱ��x ���ǻ�������
	        // ͬ���أ�������ֵ����һλ�� 0��Ϊ��ʹ������Ϊ���ģ�
	        // �����һλ����ҲӦ���� 0
	        // ֻ�� 0 ������һ����
	       if (x < 0 || (x % 10 == 0 && x != 0)) {
	       	 return false;
		   }
			int reverseNum = 0;
	       while (x > reverseNum) {
	       	reverseNum = reverseNum * 10 + x % 10;
	       	x = x/10;
		   }
	        // �����ֳ���Ϊ����ʱ�����ǿ���ͨ�� revertedNumber/10 ȥ��������λ�����֡�
	        // ���磬������Ϊ 12321 ʱ���� while ѭ����ĩβ���ǿ��Եõ� x = 12��revertedNumber = 123��
	        // ���ڴ�����λ�����ֲ�Ӱ����ģ����������Լ���ȣ����������ǿ��Լ򵥵ؽ���ȥ����
		 return x == reverseNum || x == reverseNum / 10;

	    }
	 public static void main(String[] args) {
		 System.out.println(IsPalindrome(12));
	}
}
