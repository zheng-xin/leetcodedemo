package leetcode.demos;
import java.util.Stack;

//���ȿ��ǵ���int���͵������int�������ֵ2147483647�������ֵ-2147483648�������Ҫһλһλ���жϣ�ֻ��ǰ9λ�����ǰ9λ��214748364��Ļ����϶�������ˣ����ǰ9λ����14748364����ʱ��Ҫ�����һλ��������7�Ǿ������ֱ�ӷ���0
//1.��ȡ��ķ�ʽ�����ֵ���ȡ������
//2.��intֵ�ٳ���10��ǰ��һλ
//3.�жϷ�ת���ֵ�Ƿ�С��2147483647�����Ƿ����-2147483648������Ƿ���0
//4.�÷�ת���ֵ��10���ϵ�һ��ȡ���ֵ��
//5��󷵻�

public class Demo13 {
	public static int reverse(int x) { //�Լ�д��  ˼·���� �Ƚ���
		
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
			if (result>214748364 || (result==214748364 && last>7)) { //��������β����7�����>7���������0
                return 0;
            }
            if (result<-214748364 || (result==-214748364 && last<-8)) {//������С��β����-8�����<-8���������0
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
