package leetcode.demos;

/**
 * @Auther: zhengxin
 * @Date: 2020/5/20 - 05 - 20 - 15:28
 * @Description: leetcode.demos
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 * @version: 1.0
 *
 * 用数组中第一个字符串一次与后面的字符串比较  截取掉没用的字符串
 */

public class Demo17 {
    public  static String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";
        String ans = strs[0];
        for (int i = 1;i < strs.length;i++) {
            int j = 0;
            for (; j <strs[i].length() && j < ans.length();j++) {
                if (ans.charAt(j) != strs[i].charAt(j)) {
                    break;
                }
            }
            ans = ans.substring(0,j);
            if (ans.equals("")) {
                return "";
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix2(new String[]{"flower","flow","flight"}));
    }
}
