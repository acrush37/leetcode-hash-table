package medium;

import java.util.HashSet;
import java.util.Set;

/*
    Given a list of daily temperatures T, return a list such that, for each day in the input, tells you how many days
    you would have to wait until a warmer temperature. If there is no future day for which this is possible, put 0 instead.

    For example, given the list of temperatures T = [73, 74, 75, 71, 69, 72, 76, 73], your output should be [1, 1, 4, 2, 1, 1, 0, 0].
 */
public class DailyTemperatures {

    public static void main(String... args) {

        int[] T = {73, 74, 75, 71, 69, 72, 76, 73};
        DailyTemperatures dailyTemperatures = new DailyTemperatures();
        System.out.println(dailyTemperatures.dailyTemperatures(T));
    }

    private void scan(int k, int n, int[] T, boolean[] t, int[] result) {

        t[k] = true;

        for (int i = k+1; i < n; i++)
            if (T[i] > T[k]) {
                result[k] = i-k;
                if (i <= n-2) scan(i, n, T, t, result);
                break;
            }
    }

    public int[] dailyTemperatures(int[] T) {

        int n = T.length;
        int[] result = new int[n];
        boolean[] t = new boolean[n];

        for (int i = 0; i < n-1; i++)
            if (!t[i]) scan(i, n, T, t, result);

        return result;
    }

}
