package _7_stack._1_next_greater_element;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class MainTest {
    @Test
    public void testGetNextGreaterElementsArray() {
        int[] arr = new int[] { 4, 7, 3, 4, 8, 1 };
        int[] res = Main.getNextGreaterElementsArray(arr);

        int[] expectedArray = new int[] { 7, 8, 4, 8, -1, -1 };

        Assertions.assertTrue(areTwoArraysEqual(res, expectedArray));
    }

    private boolean areTwoArraysEqual(int[] arr1, int[] arr2) {
        boolean areEqual = true;
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                areEqual = false;
            }
        }
        return areEqual;
    }
}
