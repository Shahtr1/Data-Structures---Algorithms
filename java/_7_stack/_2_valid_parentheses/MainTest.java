package _7_stack._2_valid_parentheses;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class MainTest {

    @Test
    public void testAreValidParentheses() {
        String str1 = "[{({([(([{}]))])})}]";
        String str2 = "[{({[[([(([{}}}]))])})}]";
        String str3 = "{()";
        Assertions.assertTrue(Main.areValidParentheses(str1));
        Assertions.assertFalse(Main.areValidParentheses(str2));
        Assertions.assertFalse(Main.areValidParentheses(str3));
    }
}
