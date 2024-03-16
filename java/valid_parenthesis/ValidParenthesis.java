package valid_parenthesis;

import stacks.StackWithArray;

public class ValidParenthesis {
    public static boolean isValid(String s) {
        StackWithArray stack = new StackWithArray();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    char top = (char) stack.peek();
                    if ((c == ')') && top == '(' ||
                            (c == '}') && top == '{' ||
                            (c == ']') && top == '[') {
                        stack.pop();
                    } else {
                        return false;
                    }
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("}{}")); // false
        System.out.println(isValid("{[()]}")); // true
        System.out.println(isValid("(({[{}{}()]}")); // false
        System.out.println(isValid("{[{}{}()]}")); // true
    }
}
