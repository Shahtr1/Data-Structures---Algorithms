package _7_stack._2_valid_parentheses;

import _7_stack.Stack;

public class Main {

    public static Boolean areValidParentheses(String str) {
        Stack<Character> stack = new Stack<>(100);

        char[] array = str.toCharArray();

        for (char item : array) {
            if (!stack.isEmpty()) {
                char peekElement = stack.peek();
                if (item == '}' && peekElement == '{') {
                    stack.pop();
                } else if (item == ']' && peekElement == '[') {
                    stack.pop();
                } else if (item == ')' && peekElement == '(') {
                    stack.pop();
                } else {
                    stack.push(item);
                }
            } else {
                stack.push(item);
            }
        }

        return stack.isEmpty();
    }

}
