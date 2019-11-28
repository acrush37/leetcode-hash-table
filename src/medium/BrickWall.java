package medium;

import java.util.*;

/*
    There is a brick wall in front of you.
    The wall is rectangular and has several rows of bricks.
    The bricks have the same height but different width.
     You want to draw a vertical line from the top to the bottom and cross the least bricks.

    The brick wall is represented by a list of rows.
    Each row is a list of integers representing the width of each brick in this row from left to right.

    If your line go through the edge of a brick, then the brick is not considered as crossed.
    You need to find out how to draw the line to cross the least bricks and return the number of crossed bricks.
 */
public class BrickWall {

    public static void main(String... args) {

        List<Integer> a = Arrays.asList(1, 2, 2, 1);
        List<Integer> b = Arrays.asList(3, 1, 2);
        List<Integer> c = Arrays.asList(1, 3, 2);
        List<Integer> d = Arrays.asList(2, 4);
        List<Integer> e = Arrays.asList(3, 1, 2);
        List<Integer> f = Arrays.asList(1, 3, 1, 1);
        List<List<Integer>> wall = Arrays.asList(a, b, c, d, e, f);
        BrickWall brickWall = new BrickWall();
        System.out.println(brickWall.leastBricks(wall));
    }

    public int leastBricks(List<List<Integer>> wall) {

        int max = 0;
        int s = 0;
        int n = wall.size();
        Map<Integer, Integer> m = new HashMap<>();

        for (List<Integer> list : wall) {

            s = 0;

            for (int x : list) {
                Integer y = m.get(s += x);
                m.put(s, y == null ? 1 : 1 + y);
            }
        }

        m.remove(s);
        Collection<Integer> c = m.values();
        for (int x : c) max = Math.max(max, x);
        return n - max;
    }

}
