package _3_array._2_remove_even_from_array;

import common.Common;

public class RemoveEven {
    static int[] removeEven(int[] arr) {
        int oddCount = 0;
        for (var i : arr) {
            if (i % 2 != 0) {
                oddCount++;
            }
        }

        int[] result = new int[oddCount];
        int idx = 0;
        for (int j : arr) {
            if (j % 2 != 0) {
                result[idx] = j;
                idx++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 4, 1};
        Common.printArray(removeEven(arr));
    }
}
