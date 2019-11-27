package easy;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/*
    Given n points in the plane that are all pairwise distinct, a "boomerang" is a tuple of points
    (i, j, k) such that the distance between i and j equals the distance between i and k (the order of the tuple matters).

    Find the number of boomerangs. You may assume that n will be at most 500 and coordinates of points are all in the range [-10000, 10000] (inclusive).
 */
public class NumberOfBoomerangs {

    public static void main(String... args) {

        int[][] points = {{0, 0}, {1, 0}, {2, 0}};
        NumberOfBoomerangs numberOfBoomerangs = new NumberOfBoomerangs();
        System.out.println(numberOfBoomerangs.numberOfBoomerangs(points));
    }

    public int numberOfBoomerangs(int[][] points) {

        int result = 0;
        int n = points.length;
        int[][] a = new int[n][n];
        Map<Integer,Integer>[] f = new Map[n];

        for (int i = 0; i < n-1; i++)
            for (int j = i+1; j < n; j++) {
                int x = points[i][0] - points[j][0];
                int y = points[i][1] - points[j][1];
                a[i][j] = a[j][i] = x * x + y * y;
            }

        for (int i = 0; i < n; i++) {

            f[i] = new HashMap<>();

            for (int j = 0; j < n; j++) {
                Integer x = f[i].get(a[i][j]);
                f[i].put(a[i][j], x == null ? 1 : 1 + x);
            }

            Collection<Integer> c = f[i].values();
            for (int x : c) result += x * (x-1);
        }

        return result;
    }

}
