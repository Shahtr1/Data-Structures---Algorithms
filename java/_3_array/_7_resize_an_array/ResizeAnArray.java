package _3_array._7_resize_an_array;

public class ResizeAnArray {
    public void resize(int[] arr, int capacity) {
        int[] temp = new int[capacity];
        for (int i = 0; i < arr.length; i++) {
            temp[i] = arr[i];
        }

        arr = temp;
    }
}
