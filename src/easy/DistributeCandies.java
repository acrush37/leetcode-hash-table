package easy;

/*
    Given an integer array with even length, where different numbers in this array represent
    different kinds of candies. Each number means one candy of the corresponding kind.

    You need to distribute these candies equally in number to brother and sister.
    Return the maximum number of kinds of candies the sister could gain.
 */
public class DistributeCandies {

    public static void main(String... arg) {

        int[] candies = {1,1,1,1,2,2,2,3,3,3};
        DistributeCandies distributeCandies = new DistributeCandies();
        System.out.println(distributeCandies.distributeCandies(candies));
    }

    public int distributeCandies(int[] candies) {

        int count = 0;
        boolean[] t = new boolean[200001];

        for (int x : candies)
            if (!t[x+100000]) {
                count++;
                t[x+100000] = true;
            }

        return Math.min(count, candies.length >> 1);
    }

}
