package leetcode.demos;

/**
 * @Auther: zhengxin
 * @Date: 2020/5/20 - 05 - 20 - 14:05
 * @Description: leetcode.demos ��������ת����
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 *���磬�������� 2 д�� II ����Ϊ�������е� 1��12 д�� XII ����Ϊ X + II �� 27 д�� XXVII, ��Ϊ XX + V + II ��
 * ͨ������£�����������С�������ڴ�����ֵ��ұߡ���Ҳ�������������� 4 ��д�� IIII������ IV������ 1 ������ 5 ����ߣ�
 * ����ʾ�������ڴ��� 5 ��С�� 1 �õ�����ֵ 4 ��ͬ���أ����� 9 ��ʾΪIX���������Ĺ���ֻ�������������������
 * I ���Է��� V (5) �� X (10) ����ߣ�����ʾ 4 �� 9��
 * X���Է���L(50) ��C(100) ����ߣ�����ʾ 40 ��90��
 * C���Է���D(500) ��M(1000) ����ߣ�����ʾ400 ��900��
 * ����һ���������֣�����ת��������������ȷ���� 1�� 3999 �ķ�Χ��
 * @version: 1.0
 */
public class Demo16 {
    public  static int romanToInt(String s) {
        int sum = 0;
        for (int i = s.length() - 1; i >= 0;i--) {
            char pre = i < s.length() - 1 ? s.charAt(i+1) : '0';
            char current = s.charAt(i);
            sum +=translate(pre,current);
        }
        return sum;
    }
    public static int translate (char pre,char curr) {
        int preInt = getInt(pre);
        int currInt = getInt(curr);
        if (currInt < preInt) {
            return -currInt;
        } else {
            return currInt;
        }
    }
    public static  int getInt(char c) {
        if ('I' ==  c) {
            return 1;
        } else if ('V' == c) {
            return 5;
        } else if ('X' == c) {
            return 10;
        } else if ('L' == c) {
            return 50;
        } else if ('C' == c) {
            return 100;
        } else if ('D' == c) {
            return 500;
        } else if ('M' == c) {
            return 1000;
        }
        return 0;
    };

    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
    }
}
