package medium;

import java.util.HashMap;
import java.util.Map;

/*
    Given four lists A, B, C, D of integer values, compute how many tuples (i, j, k, l) there are such that A[i] + B[j] + C[k] + D[l] is zero.

    To make problem a bit easier, all A, B, C, D have same length of N where 0 ≤ N ≤ 500.
    All integers are in the range of -228 to 228 - 1 and the result is guaranteed to be at most 231 - 1.
 */
public class FourSumII {

    public static void main(String... args) {

        int[] A = {1, 2};
        int[] B = {-2, -1};
        int[] C = {-1, 2};
        int[] D = {0, 2};
        FourSumII fourSumII = new FourSumII();
        System.out.println(fourSumII.fourSumCount(A, B, C, D));
    }

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {

        int result = 0;
        int n = A.length;
        Map<Integer, Integer> m = new HashMap<>();

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                Integer x = m.get(A[i] + B[j]);
                m.put(A[i] + B[j], x == null ? 1 : 1 + x);
            }

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                Integer x = m.get(-C[i] - D[j]);
                if (x != null) result += x;
            }

        return result;
    }

}
