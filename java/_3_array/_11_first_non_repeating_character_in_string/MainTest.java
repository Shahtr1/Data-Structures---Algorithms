package _3_array._11_first_non_repeating_character_in_string;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class MainTest {
    @Test
    public void testGetFirstNonRepeatingCharacterInString() {
        char res = Main.getFirstNonRepeatingCharacterInString("Swiss");
        Assertions.assertEquals('w', res);

        res = Main.getFirstNonRepeatingCharacterInString("bubblue");
        Assertions.assertEquals('l', res);

        res = Main.getFirstNonRepeatingCharacterInString("ububblule");
        Assertions.assertEquals('e', res);

        res = Main.getFirstNonRepeatingCharacterInString("iububblulee");
        Assertions.assertEquals('i', res);
    }
}
