package _3_array._11_first_non_repeating_character_in_string;

import java.util.LinkedHashMap;

public class Main {

    public static Character getFirstNonRepeatingCharacterInString(String str) {

        LinkedHashMap<Character, Integer> hashMap = new LinkedHashMap<>();

        char[] charArray = str.toLowerCase().toCharArray();

        for (char c : charArray) {
            Integer count = hashMap.get(c);
            if (count == null) {
                hashMap.put(c, 1);
            } else {
                hashMap.put(c, count + 1);
            }
        }

        return hashMap.entrySet().stream().filter(entry -> entry.getValue() == 1).findFirst().get().getKey();

    }
}
