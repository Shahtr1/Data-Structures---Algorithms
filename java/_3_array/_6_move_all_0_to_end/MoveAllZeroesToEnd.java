package _3_array._6_move_all_0_to_end;

import common.Common;

public class MoveAllZeroesToEnd {
    public static int[] moveAllZeroes(int[] arr) {
        int j = 0;
        for (var i = 0; i < arr.length; i++) {
            if (arr[i] != 0 && arr[j] == 0) {
                var temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }

            if (arr[j] != 0) {
                j++;
            }
        }

        return arr;
    }

    public static void main(String[] args) {
        Common.printArray(moveAllZeroes(new int[]{8, 1, 0, 2, 1, 0, 3}));
    }
}
