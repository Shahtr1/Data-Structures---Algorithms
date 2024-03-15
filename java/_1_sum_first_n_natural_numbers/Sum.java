package _1_sum_first_n_natural_numbers;

class Sum {
    public static int findSum(int n) {
        return n * (n + 1) / 2;
    }

    public static void main(String[] args) {
        System.out.println(findSum(4));
    }
}
