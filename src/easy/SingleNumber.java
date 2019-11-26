package easy;

/*
    Given a non-empty array of integers, every element appears twice except for one. Find that single one.

    Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */
public class SingleNumber {

    public static void main(String... args) {

        int[] nums = {2, 2, 1};
        SingleNumber singleNumber = new SingleNumber();
        System.out.println(singleNumber.singleNumber(nums));
    }

    public int singleNumber(int[] nums) {

        int result = 0;
        for (int x : nums) result ^= x;
        return result;
    }
}
