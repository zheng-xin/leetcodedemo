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
        for (int i = 0; i < s.length();i++ ) {
            char pre = i - 1 >= 0 ? s.charAt(i - 1) : '0';
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
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    };

    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
    }
}
