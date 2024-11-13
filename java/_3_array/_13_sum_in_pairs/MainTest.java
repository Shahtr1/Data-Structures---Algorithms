package _3_array._13_sum_in_pairs;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MainTest {

    private static int[] inputArray = new int[] { 4, 3, 9, 2, 1, 5, 6 };
    private static int sum;

    @Test
    public void testGetNumbersOfSumPairs_ifSumIs8() {
        sum = 8;
        List<List<Integer>> resList = Main.getNumbersOfSumPairs(inputArray, sum);
        int presentPairCount = 2;
        for (List<Integer> res : resList) {
            if (res.contains(2) && res.contains(6)) {
                presentPairCount--;
            } else if (res.contains(3) && res.contains(5)) {
                presentPairCount--;
            }
        }

        Assertions.assertEquals(0, presentPairCount);
    }

    @Test
    public void testGetNumbersOfSumPairs_ifSumIs5() {
        sum = 5;
        List<List<Integer>> resList = Main.getNumbersOfSumPairs(inputArray, sum);
        int presentPairCount = 2;
        for (List<Integer> res : resList) {
            if (res.contains(1) && res.contains(4)) {
                presentPairCount--;
            } else if (res.contains(3) && res.contains(2)) {
                presentPairCount--;
            }
        }

        Assertions.assertEquals(0, presentPairCount);
    }

    @Test
    public void testGetNumbersOfSumPairs_ifSumIs10() {
        sum = 10;
        List<List<Integer>> resList = Main.getNumbersOfSumPairs(inputArray, sum);
        int presentPairCount = 2;
        for (List<Integer> res : resList) {
            if (res.contains(9) && res.contains(1)) {
                presentPairCount--;
            } else if (res.contains(4) && res.contains(6)) {
                presentPairCount--;
            }
        }

        Assertions.assertEquals(0, presentPairCount);
    }

}
