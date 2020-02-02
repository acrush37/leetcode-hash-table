package medium;

import java.util.*;

/*
    Given a set of points in the xy-plane, determine the minimum area of a
    rectangle formed from these points, with sides parallel to the x and y axes.

    If there isn't any rectangle, return 0.
 */
public class MinimumAreaRectangle {

    public static void main(String... args) {

        int[][] points = {{1, 1}, {1, 3}, {3, 1}, {3, 3}, {4, 1}, {4, 3}};
        MinimumAreaRectangle minimumAreaRectangle = new MinimumAreaRectangle();
        System.out.println(minimumAreaRectangle.minAreaRect(points));
    }

    public int minAreaRect(int[][] points) {

        int result = Integer.MAX_VALUE;
        Map<Integer, List<Integer>> a = new HashMap<>();
        Map<Integer, List<Integer>> b = new HashMap<>();

        for (int[] p : points) {

            a.putIfAbsent(p[0], new ArrayList<>());
            b.putIfAbsent(p[1], new ArrayList<>());
            a.get(p[0]).add(p[1]);
            b.get(p[1]).add(p[0]);
        }

        Iterator<Integer> it = a.keySet().iterator();

        while (it.hasNext()) {

            int x = it.next();
            List<Integer> t = a.getOrDefault(x, new ArrayList<>());
            int n = t.size();

            for (int i = 0; i < n-1; i++) {

                int y1 = t.get(i);
                List<Integer> c = b.getOrDefault(y1, new ArrayList<>());
                if (c.size() <= 1) continue;

                for (int j = i + 1; j < n; j++) {

                    int y2 = t.get(j);
                    List<Integer> d = b.getOrDefault(y2, new ArrayList<>());
                    if (d.size() <= 1) continue;
                    int k = Math.abs(y1 - y2);

                    for (int u : c)
                        if (u != x)
                            for (int v : d)
                                if (u == v)
                                    result = Math.min(result, k * Math.abs(u - x));
                }
            }
        }

        return result == Integer.MAX_VALUE ? 0 : result;
    }

}
