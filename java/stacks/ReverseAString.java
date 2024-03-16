package stacks;

public class ReverseAString {
    public static String reverse(String input) {
        StackWithArray stack = new StackWithArray();
        char[] chars = input.toCharArray();
        for (char c : chars) {
            stack.push(c);
        }

        for (int i = 0; i < input.length(); i++) {
            chars[i] = (char) stack.pop();
        }

        return new String(chars);
    }

    public static void main(String[] args) {
        System.out.println(reverse("hkurhahs"));
    }
}
