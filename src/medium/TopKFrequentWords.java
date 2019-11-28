package medium;

import java.util.*;

import static java.util.Map.Entry;

/*
    Given a non-empty list of words, return the k most frequent elements.

    Your answer should be sorted by frequency from highest to lowest.

    If two words have the same frequency, then the word with the lower alphabetical order comes first.
 */
public class TopKFrequentWords {

    public static void main(String... args) {

        String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
        TopKFrequentWords topKFrequentWords = new TopKFrequentWords();
        System.out.println(topKFrequentWords.topKFrequent(words, 2));
    }

    public List<String> topKFrequent(String[] words, int k) {

        List<String> result = new ArrayList<>();
        Map<String, Integer> m = new HashMap<>();

        for (String word : words) {
            Integer x = m.get(word);
            m.put(word, x == null ? 1 : 1 + x);
        }

        List<Entry<String, Integer>> list = new ArrayList<>(m.entrySet());

        list.sort((x, y) -> {

            int a = x.getValue();
            int b = y.getValue();
            if (a != b) return b-a;
            return x.getKey().compareTo(y.getKey());
        });

        for (int i = 0; i < k; i++) result.add(list.get(i).getKey());
        return result;
    }

}
