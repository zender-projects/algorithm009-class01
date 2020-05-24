package leetcode;

import java.util.Stack;

/**
 * @author Echo
 * @date 2020/5/24 1:47 下午
 *
 * 有效括号问题
 */
public class ValidBrackets_20 {


    public boolean isValid(String s) {

        if (s == null || "".equals(s)) {
            return true;
        }

        if (s.length() % 2 != 0) {
            return false;
        }

        Stack<Character> stack = new Stack<>();
        for (int i = 0;i < s.length();i ++) {
            char c = s.charAt(i);
            if (c == '[' || c == '{' || c == '（') {
                stack.push(c);
            }
            else {
                if (stack.isEmpty()) {
                    return false;
                }
                char cp = stack.peek();
                //匹配上了
                if ((c == ']' && cp == '[') || (c == '}' && cp == '{') || (c == ')' && cp == '(')) {
                    stack.pop();
                } else {   //没有匹配上
                    return false;
                }
            }
        }
        //如果stack中还有剩余的字符，则说明有部分匹配失败
        return stack.isEmpty();
    }
}
