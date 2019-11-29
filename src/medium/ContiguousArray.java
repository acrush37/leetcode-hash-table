package medium;

/*
    Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.
 */
public class ContiguousArray {

    public static void main(String... args) {

        int[] nums = {0, 1, 1, 1, 0, 0};
        ContiguousArray contiguousArray = new ContiguousArray();
        System.out.println(contiguousArray.findMaxLength(nums));
    }

    public int findMaxLength(int[] nums) {

        int result = 0, n = nums.length, count = n;
        Integer[] f = new Integer[1 + (n << 1)];
        int[] a = {-1, 1};

        for (int i = 0; i < n; i++)
            if ((count += a[nums[i]]) == n) result = i + 1;
            else if (f[count] == null) f[count] = i;
            else result = Math.max(result, i - f[count]);

        return result;
    }

}
