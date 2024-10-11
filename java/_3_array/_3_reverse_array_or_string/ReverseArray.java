package _3_array._3_reverse_array_or_string;

import common.Common;

public class ReverseArray {
    public static int[] reverseArray(int[] numbers) {
        var start = 0;
        var end = numbers.length - 1;
        while (start < end) {
            var temp = numbers[start];
            numbers[start] = numbers[end];
            numbers[end] = temp;
            start++;
            end--;
        }

        return numbers;
    }

    public static void main(String[] args) {
        Common.printArray(reverseArray(new int[]{1, 2, 3, 4, 5, 6, 7}));
    }
}
