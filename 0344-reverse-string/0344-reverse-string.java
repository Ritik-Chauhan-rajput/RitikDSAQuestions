import java.util.*;

class Solution {

    public static String reverString(String s) {
        Stack<Character> str = new Stack<>();

        int idx = 0;
        while (idx < s.length()) {
            str.push(s.charAt(idx));
            idx++;
        }

        StringBuilder result = new StringBuilder();

        while (!str.isEmpty()) {
            result.append(str.pop());
        }

        return result.toString();
    }

    public void reverseString(char[] s) {
        String result = reverString(new String(s));

        for (int i = 0; i < s.length; i++) {
            s[i] = result.charAt(i);
        }
    }
}