package medium;

import java.util.*;

import static java.util.Map.Entry;
/*
    Given a non-empty array of integers, return the k most frequent elements.
 */
public class TopKFrequentElements {

    public static void main(String... args) {

        int[] nums = {1, 1, 1, 2, 2, 3, 3, 3, 4, 4, 5};
        TopKFrequentElements topKFrequentElements = new TopKFrequentElements();
        System.out.println(topKFrequentElements.topKFrequent(nums, 4));
    }

    public List<Integer> topKFrequent(int[] nums, int k) {

        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> m = new HashMap<>();

        for (int x : nums) {
            Integer y = m.get(x);
            m.put(x, y == null ? 1 : 1 + y);
        }

        List<Entry<Integer, Integer>> list = new ArrayList<>(m.entrySet());
        Collections.sort(list, Comparator.comparingInt(x -> -x.getValue()));
        for (int i = 0; i < k; i++) result.add(list.get(i).getKey());
        return result;
    }

}
