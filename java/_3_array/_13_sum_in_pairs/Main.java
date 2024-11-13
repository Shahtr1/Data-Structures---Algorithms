package _3_array._13_sum_in_pairs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static List<List<Integer>> getNumbersOfSumPairs(int[] array, int pairSum) {
        Map<Integer, Boolean> holder = new HashMap<>();
        List<List<Integer>> resList = new ArrayList<>();

        for (int item : array) {
            if (holder.get(item) == null) {
                holder.put(pairSum - item, true);
            } else {
                resList.add(List.of(item, pairSum - item));
            }
        }

        return resList;
    }
}
