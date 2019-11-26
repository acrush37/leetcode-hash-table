package easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
    Given two arrays, write a function to compute their intersection.
 */
public class IntersectionOfTwoArraysII {

    public static void main(String... args) {

        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        IntersectionOfTwoArraysII intersectionOfTwoArraysII = new IntersectionOfTwoArraysII();
        System.out.println(intersectionOfTwoArraysII.intersect(nums1, nums2));
    }

    public int[] intersect(int[] nums1, int[] nums2) {

        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> m = new HashMap<>();

        for (int x : nums1) {
            Integer y = m.get(x);
            m.put(x, y == null ? 1 : 1 + y);
        }

        for (int x : nums2) {

            Integer y = m.get(x);

            if (y != null && y > 0) {
                list.add(x);
                m.put(x, y - 1);
            }
        }

        int n = list.size();
        if (n == 0) return new int[0];
        int[] result = new int[n];
        for (int x : list) result[--n] = x;
        return result;
    }
}
