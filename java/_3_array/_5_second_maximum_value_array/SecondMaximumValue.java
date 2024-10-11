package _3_array._5_second_maximum_value_array;

public class SecondMaximumValue {

    public static Integer getSecondMaximumValue(int[] arr) {
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;

        for (var i : arr) {
            if (i > max) {
                secondMax = max;
                max = i;
            } else if (i > secondMax && i != max) {
                secondMax = i;
            }
        }

        return secondMax;
    }

    public static void main(String[] args) {
        System.out.println(getSecondMaximumValue(new int[]{13, 34, 2, 34, 33, 1}));
    }
}
