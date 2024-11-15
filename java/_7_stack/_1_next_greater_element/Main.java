package _7_stack._1_next_greater_element;

import _7_stack.Stack;

public class Main {

    public static int[] getNextGreaterElementsArray(int[] arr) {
        int[] res = new int[arr.length];
        Stack stack = new Stack(arr.length);

        for (int i = arr.length - 1; i >= 0; i--) {
            if (!stack.isEmpty()) {
                while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                    stack.pop();
                }
            }
            if (stack.isEmpty()) {
                res[i] = -1;
            } else {
                res[i] = stack.peek();
            }
            stack.push(arr[i]);
        }

        return res;
    }

}
