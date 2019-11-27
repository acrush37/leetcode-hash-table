package easy;

import java.util.HashMap;
import java.util.Map;

/*
    Given a pattern and a string str, find if str follows the same pattern.

    Here follow means a full match, such that there is a bijection between
    a letter in pattern and a non-empty word in str.
 */
public class WordPattern {

    public static void main(String... args) {

        WordPattern wordPattern = new WordPattern();
        System.out.println(wordPattern.wordPattern("abba", "dog cat cat dog"));
    }

    public boolean wordPattern(String pattern, String str) {

        String[] s = str.split(" ");
        if (s.length != pattern.length()) return false;
        Map<String, String> a = new HashMap<>();
        Map<String, String> b = new HashMap<>();
        char[] c = pattern.toCharArray();

        for (int i = 0; i < c.length; i++) {

            String x = a.get(c[i]+"");

            if (x == null) {

                String y = b.get(s[i]);

                if (y == null) {
                    a.put(c[i] + "", s[i]);
                    b.put(s[i], c[i] + "");
                } else if (!y.equals(c[i]+"")) return false;
            } else if (!x.equals(s[i])) return false;
        }

        return true;
    }

}
