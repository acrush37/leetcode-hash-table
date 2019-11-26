package easy;

import java.util.HashSet;
import java.util.Set;

/*
    Given two arrays, write a function to compute their intersection.
 */
public class IntersectionOfTwoArrays {

    public static void main(String... args) {

        int[] nums1 = {4, 9, 5};
        int[] nums2 = {9, 4, 9, 8, 4};
        IntersectionOfTwoArrays intersectionOfTwoArrays = new IntersectionOfTwoArrays();
        System.out.println(intersectionOfTwoArrays.intersection(nums1, nums2));
    }

    public int[] intersection(int[] nums1, int[] nums2) {

        Set<Integer> f = new HashSet<>();
        Set<Integer> t = new HashSet<>();
        for (int x : nums1) t.add(x);
        for (int x : nums2) if (t.contains(x)) f.add(x);
        int[] result = new int[f.size()];
        int n = 0;
        for (int x : f) result[n++] = x;
        return result;
    }

}
