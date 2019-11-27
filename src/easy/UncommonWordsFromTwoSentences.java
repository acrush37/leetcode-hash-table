package easy;

import java.util.*;

/*
    We are given two sentences A and B.
    (A sentence is a string of space separated words.  Each word consists only of lowercase letters.)

    A word is uncommon if it appears exactly once in one of the sentences, and does not appear in the other sentence.

    Return a list of all uncommon words.
 */
public class UncommonWordsFromTwoSentences {

    public static void main(String... args) {

        String A = "this apple is sweet";
        String B = "this apple is sour";
        UncommonWordsFromTwoSentences uncommonWordsFromTwoSentences = new UncommonWordsFromTwoSentences();
        System.out.println(uncommonWordsFromTwoSentences.uncommonFromSentences(A,  B));
    }

    public String[] uncommonFromSentences(String A, String B) {

        String[] a = A.split(" ");
        String[] b = B.split(" ");
        Map<String, Boolean> x = new HashMap<>();
        Map<String, Boolean> y = new HashMap<>();

        for (String s : a) {

            Boolean t = x.get(s);
            if (t == null) x.put(s, true);
            else if (t) x.put(s, false);
        }

        for (String s : b) {

            Boolean t = y.get(s);
            if (t == null) y.put(s, true);
            else if (t) y.put(s, false);
        }

        Set<String> set = new HashSet<>();

        for (String s : a)
            if (x.get(s) == Boolean.TRUE && y.get(s) == null)
                set.add(s);

        for (String s : b)
            if (y.get(s) == Boolean.TRUE && x.get(s) == null)
                set.add(s);

        String[] result = new String[set.size()];
        set.toArray(result);
        return result;
    }

}
