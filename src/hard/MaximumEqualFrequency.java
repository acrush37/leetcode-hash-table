package hard;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import static java.util.Map.Entry;
/*
    Given an array nums of positive integers, return the longest possible length of an array
    prefix of nums, such that it is possible to remove exactly one element from this prefix
    so that every number that has appeared in it will have the same number of occurrences.

    If after removing one element there are no remaining elements, it's still
    considered that every appeared number has the same number of occurrences (0).
 */
public class MaximumEqualFrequency {

    public static void main(String... args) {

        int[] nums = {1, 1, 1, 2, 2, 2};
        MaximumEqualFrequency maximumEqualFrequency = new MaximumEqualFrequency();
        System.out.println(maximumEqualFrequency.maxEqualFreq(nums));
    }

    public int maxEqualFreq(int[] nums) {

        int n = nums.length;
        if (n <= 4) return n;
        int[] f = new int[100001];
        int min = nums[0], max = nums[0];
        Map<Integer, Integer> t = new HashMap<>();

        for (int x : nums) {
            f[x]++;
            min = Math.min(min, x);
            max = Math.max(max, x);
        }

        for (int i = min; i <= max; i++)
            if (f[i] > 0)
                t.put(f[i], t.getOrDefault(f[i], 0) + 1);

        for (int i = n-1; i >= 4; i--) {

            if (t.size() <= 2) {

                Iterator<Entry<Integer, Integer>> it = t.entrySet().iterator();
                Entry<Integer, Integer> x = it.next();
                int a = x.getKey(), b = x.getValue();

                if (t.size() == 1) {
                    if (a == 1 || b == 1) return i+1;
                } else {
                    Entry<Integer, Integer> y = it.next();
                    int c = y.getKey(), d = y.getValue();
                    if (a == 1 && b == 1) return i+1;
                    if (c == 1 && d == 1) return i+1;
                    if (a == 2 && b == 1 && c == 1) return i+1;
                    if (b == 1 && a == c+1) return i+1;
                    if (d == 1 && c == a+1) return i+1;
                }
            }

            Integer s = t.get(f[nums[i]]);

            if (s == 1) t.remove(f[nums[i]]);
            else t.put(f[nums[i]], s-1);

            if (--f[nums[i]] != 0) t.put(f[nums[i]], t.getOrDefault(f[nums[i]], 0)+1);
        }

        return 4;
    }

}
