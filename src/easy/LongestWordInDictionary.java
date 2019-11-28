package easy;

import java.util.*;

/*
    Given a list of strings words representing an English Dictionary, find the longest
    word in words that can be built one character at a time by other words in words.

    If there is more than one possible answer, return the longest word with the smallest lexicographical order.
    If there is no answer, return the empty string.
 */
public class LongestWordInDictionary {

    public static void main(String... args) {

        String[] words = {"yo","ew","fc","zrc","yodn","fcm","qm","qmo","fcmz","z","ewq","yod","ewqz","y"};
        LongestWordInDictionary longestWordInDictionary = new LongestWordInDictionary();
        System.out.println(longestWordInDictionary.longestWord(words));
    }

    public String longestWord(String[] words) {

        String result = "";
        Set<String> t = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.offer("");
        Map<Integer, Set<String>> m = new HashMap<>();

        for (String word : words) {

            int x = word.length();
            Set<String> set = m.get(x);
            if (set == null) set = new HashSet<>();
            set.add(word);
            m.put(x, set);
        }

        while (!q.isEmpty()) {

            String x = q.poll();
            Set<String> set = m.get(x.length() + 1);
            if (set == null) continue;

            for (String word : set) {

                if (t.contains(word) || !word.contains(x)) continue;
                t.add(word);
                q.offer(word);
                if (word.length() > result.length() || word.compareTo(result) < 0) result = word;
            }
        }

        return result;
    }

}
