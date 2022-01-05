package leetcode20;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @author Wenyi Cao
 * @version 1.0
 * @link
 * @description 有效的括号
 * @date 2021/10/29 11:49
 * @see
 */
public class Solution {

    public static void main(String[] args) {
//        String input = "()[]{}";
        String input = "]";
        System.out.println(isValid(input));
        System.out.println(isValid2(input));
    }

    private static boolean isValid2(String input) {

        // 栈
        LinkedList<Character> stack = new LinkedList();

        char[] chars = input.toCharArray();
        for (char cur : chars) {
            if (cur == '(' || cur == '[' || cur == '{') {
                // 左括号入栈
                stack.push(cur);
            } else {
                if (stack.isEmpty()){
                    return false;
                }
                // 遇到右括号，和栈顶元素匹配
                Character top = stack.pop();
                if (top == '(' && cur != ')') {
                    // 不匹配返回false
                    return false;
                }
                if (top == '[' && cur != ']') {
                    // 不匹配返回false
                    return false;
                }
                if (top == '{' && cur != '}') {
                    // 不匹配返回false
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }


    public static boolean isValid(String input) {

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()){
                    return false;
                }
                Character topChar = stack.pop();
                if (c == ')' && topChar != '(') {
                    return false;
                } else if (c == ']' && topChar != '[') {
                    return false;
                } else if (c == '}' && topChar != '{') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
