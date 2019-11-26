package easy;

/*
    Given an array of integers arr, write a function that returns true if and
    only if the number of occurrences of each value in the array is unique.
 */
public class UniqueNumberOfOccurrences {

    public static void main(String... args) {

        int[] arr = {1, 2, 2, 1, 1, 3};
        UniqueNumberOfOccurrences uniqueNumberOfOccurrences = new UniqueNumberOfOccurrences();
        System.out.println(uniqueNumberOfOccurrences.uniqueOccurrences(arr));
    }

    public boolean uniqueOccurrences(int[] arr) {

        int[] f = new int[2001];
        boolean[] g = new boolean[1001];
        boolean[] t = new boolean[2001];
        for (int x : arr) f[x+1000]++;

        for (int x : arr)
            if (!t[x+1000]) {
                if (g[f[x+1000]]) return false;
                t[x+1000] = g[f[x+1000]] = true;
            }

        return true;
    }

}
