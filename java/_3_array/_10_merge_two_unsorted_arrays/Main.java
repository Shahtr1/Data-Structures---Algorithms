// Merge Two unsorted arrays into single sorted array without duplicates

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Integer[] arr1 = new Integer[] { 1, 4, 6, 8, 2, 3, 1, 10, 100, 20 };
        Integer[] arr2 = new Integer[] { 7, 9, 6, 5, 10, 4, 100 };

        Integer[] merge = merge(arr1, arr2);
        for (Integer integer : merge) {
            System.out.println(integer.intValue());
        }

        // Set Insertion => O(n)
        // Sorting: O(n log n)
        // List to Array Conversion: O(n)

        // Overall: O(n log n)
    }

    private static Integer[] merge(Integer[] arr1, Integer[] arr2) {
        if (arr1.length == 0 && arr2.length == 0) {
            return new Integer[] {};
        }

        Set<Integer> mergedSet = new HashSet<>();

        mergedSet.addAll(Arrays.asList(arr1));
        mergedSet.addAll(Arrays.asList(arr2));

        List<Integer> sortedList = new ArrayList<>(mergedSet);

        Collections.sort(sortedList);

        return sortedList.toArray(new Integer[0]);
    }
}
