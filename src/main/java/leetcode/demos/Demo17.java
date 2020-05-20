package leetcode.demos;

/**
 * @Auther: zhengxin
 * @Date: 2020/5/20 - 05 - 20 - 15:28
 * @Description: leetcode.demos
 * ��дһ�������������ַ��������е������ǰ׺��
 *
 * ��������ڹ���ǰ׺�����ؿ��ַ��� ""��
 * @version: 1.0
 *
 * �������е�һ���ַ���һ���������ַ����Ƚ�  ��ȡ��û�õ��ַ���
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
