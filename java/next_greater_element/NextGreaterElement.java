package next_greater_element;

import common.Common;
import stacks.StackWithArray;

public class NextGreaterElement {
    public static int[] nextGreater(int[] arr) {
        int[] result = new int[arr.length];
        StackWithArray stack = new StackWithArray();
        for (int i = arr.length - 1; i >= 0; i--) {
            if (!stack.isEmpty()) {
                while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                    stack.pop();
                }
            }

            if (stack.isEmpty()) {
                result[i] = -1;
            } else {
                result[i] = stack.peek();
            }

            stack.push(arr[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        Common.printArray(nextGreater(new int[] { 4, 7, 3, 4, 8, 1 }));
    }
}
