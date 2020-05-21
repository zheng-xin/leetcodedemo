package leetcode.demos;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @Auther: zhengxin
 * @Date: 2020/5/20 - 05 - 20 - 16:57
 * @Description: 判断括号表达式是否合法  是用栈完成
 * @version: 1.0
 */
public class Demo18 {
    public static boolean isValid(String s) {
        Map<Character,Character> map = new HashMap<Character,Character>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        if (s == null || "".equals(s))
            return true;
        Stack<Character> stack =  new Stack<>();
        for (int i = 0; i < s.length(); i ++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty())
                    return false;
                char ch = stack.pop();
                if (map.get(c) == ch) {
                    continue;
                } else {
                    return false;
                }
            }
        }
        return  stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("}"));
    }
}
