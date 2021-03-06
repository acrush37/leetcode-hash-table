package medium;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/*
    Given a matrix consisting of 0s and 1s, we may choose any number
    of columns in the matrix and flip every cell in that column.

    Flipping a cell changes the value of that cell from 0 to 1 or from 1 to 0.
    Return the maximum number of rows that have all values equal after some number of flips.
 */
public class FlipColumnsForMaximumqualRows {

    public static void main(String... args) {

        int[][] matrix = {{0, 0, 0}, {0, 0, 1}, {1, 1, 0}};
        FlipColumnsForMaximumqualRows flipColumnsForMaximumqualRows = new FlipColumnsForMaximumqualRows();
        System.out.println(flipColumnsForMaximumqualRows.maxEqualRowsAfterFlips(matrix));
    }

    public int maxEqualRowsAfterFlips(int[][] matrix) {

        int result = 0;
        Map<String, Integer> t = new HashMap<>();

        for (int[] x : matrix) {

            StringBuilder a = new StringBuilder();
            StringBuilder b = new StringBuilder();

            for (int y : x) {
                a.append(y);
                b.append(y^1);
            }

            String c = a.toString(), d = b.toString();
            t.put(c, 1 + t.getOrDefault(c, 0));
            t.put(d, 1 + t.getOrDefault(d, 0));
        }

        Iterator<Integer> it= t.values().iterator();
        while (it.hasNext()) result = Math.max(result, it.next());
        return result;
    }

}
