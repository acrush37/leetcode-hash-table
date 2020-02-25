package hard;

import java.util.*;

/*
    You are given a string, s, and a list of words, words, that are all of the same length.

    Find all starting indices of substring(s) in s that is a concatenation of
    each word in words exactly once and without any intervening characters.
 */
public class SubstringWithConcatenationOfAllWords {

    public static void main(String... args) {

        String[] words = {"foo", "bar"};
        SubstringWithConcatenationOfAllWords substringWithConcatenationOfAllWords = new SubstringWithConcatenationOfAllWords();
        System.out.println(substringWithConcatenationOfAllWords.findSubstring("barfoothefoobarman", words));
    }

    private boolean find(int k, int m, int p, String s, Map<String, Integer> f) {

        Map<String, Integer> a = new HashMap<>();
        a.putAll(f);

        while (--m >= 0) {

            String t = s.substring(k, k += p);
            int x = a.getOrDefault(t, 0);
            if (x == 0) return false;
            a.put(t, x-1);
        }

        return true;
    }

    public List<Integer> findSubstring(String s, String[] words) {

        List<Integer> result = new ArrayList<>();
        int m = words.length;
        if (m == 0) return result;
        int n = s.length(), p = words[0].length(), q = m * p;
        if (q > n) return result;
        Map<String, Integer> f = new HashMap<>();
        for (String word : words) f.put(word, 1 + f.getOrDefault(word, 0));

        for (int i = 0; i <= n-q; i++)
            if (find(i, m, p, s, f))
                result.add(i);

        return result;
    }

}
