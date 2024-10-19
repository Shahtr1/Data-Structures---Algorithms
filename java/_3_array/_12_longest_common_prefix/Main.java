package _3_array._12_longest_common_prefix;

public class Main {
    public static void main(String[] args) {
        String[] input1 = { "geeksforgeeks", "geeks", "geek", "geezer" };
        String[] input2 = { "apple", "ape", "april" };

        System.out.println("Longest Common Prefix (Input 1): " + findLongestCommonPrefix(input1));
        System.out.println("Longest Common Prefix (Input 2): " + findLongestCommonPrefix(input2));
    }

    public static String findLongestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";

        // Step 1: Assume the first string is the common prefix
        String prefix = strs[0];

        // Step 2: Compare the prefix with the rest of the strings
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }

        return prefix;
    }
}
