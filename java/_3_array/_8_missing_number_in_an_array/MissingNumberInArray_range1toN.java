package _3_array._8_missing_number_in_an_array;

public class MissingNumberInArray_range1toN {

    public static int missingNumber(int[] arr) {
        int n = arr.length + 1;
        int sum = (n * (n + 1)) / 2;
        for (int i = 0; i < arr.length; i++) {
            sum -= arr[i];
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(missingNumber(new int[]{1, 2, 3, 5}));
    }
}
