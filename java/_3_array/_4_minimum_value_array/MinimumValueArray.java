package _3_array._4_minimum_value_array;

public class MinimumValueArray {
    public static Integer getMinimumValue(int[] arr) {
        if (arr.length > 0) {
            int min = arr[0];

            for (var i : arr) {
                if (i < min) {
                    min = i;
                }
            }

            return min;
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(getMinimumValue(new int[]{300, 63, 100, 23, 52}).intValue());
    }
}
