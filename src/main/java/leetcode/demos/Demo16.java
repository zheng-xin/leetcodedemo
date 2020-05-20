package leetcode.demos;

/**
 * @Auther: zhengxin
 * @Date: 2020/5/20 - 05 - 20 - 14:05
 * @Description: leetcode.demos 罗马数字转整数
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 *例如，罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做 XXVII, 即为 XX + V + II 。
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，
 * 所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为IX。这个特殊的规则只适用于以下六种情况：
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X可以放在L(50) 和C(100) 的左边，来表示 40 和90。
 * C可以放在D(500) 和M(1000) 的左边，来表示400 和900。
 * 给定一个罗马数字，将其转换成整数。输入确保在 1到 3999 的范围内
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
