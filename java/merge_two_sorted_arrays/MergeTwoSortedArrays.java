package merge_two_sorted_arrays;

import common.Common;

public class MergeTwoSortedArrays {

    public static int[] merge(int[] arr1, int[] arr2) {
        int totalLength = arr1.length + arr2.length;
        int[] result = new int[totalLength];
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                result[k] = arr1[i];
                i++;
            } else {
                result[k] = arr2[j];
                j++;
            }
            k++;
        }

        while (i < arr1.length) {
            result[k] = arr1[i];
            i++;
            k++;
        }

        while (j < arr2.length) {
            result[k] = arr2[j];
            j++;
            k++;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr1 = { 2, 3, 5, 10 };
        int[] arr2 = { 4, 6, 11, 15 };

        Common.printArray(merge(arr1, arr2));
    }
}
