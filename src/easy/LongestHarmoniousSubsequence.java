package easy;

import java.util.HashMap;
import java.util.Map;

/*
    We define a harmounious array as an array where the difference between its maximum value and its minimum value is exactly 1.

    Now, given an integer array, you need to find the length of its longest harmonious subsequence among all its possible subsequences.
 */
public class LongestHarmoniousSubsequence {

    public static void main(String... args) {

        int[] nums = {1, 3, 2, 2, 5, 2, 3, 7};
        LongestHarmoniousSubsequence longestHarmoniousSubsequence = new LongestHarmoniousSubsequence();
        System.out.println(longestHarmoniousSubsequence.findLHS(nums));
    }

    public int findLHS(int[] nums) {

        int result = 0;
        Map<Integer, Integer> m = new HashMap<>();

        for (int x : nums) {
            Integer y = m.get(x);
            m.put(x, y == null ? 1 : 1 + y);
        }

        for (int x : nums) {

            Integer y = m.get(x+1);
            if (y != null) result = Math.max(result, y + m.get(x));
        }

        return result;
    }

}
