package medium;

/*
    In an array A of 0s and 1s, how many non-empty subarrays have sum S?
 */
public class BinarySubarraysWithSum {

    public static void main(String... args) {

        int[] A = {0, 1, 0, 0, 1, 0, 1, 0};
        BinarySubarraysWithSum binarySubarraysWithSum = new BinarySubarraysWithSum();
        System.out.println(binarySubarraysWithSum.numSubarraysWithSum(A, 2));
    }

    public int numSubarraysWithSum(int[] A, int S) {

        int m = 0;
        int result = 0;
        int n = A.length;
        int[] f = new int[n+2];

        for (int i = 1; i <= n; i++)
            if (A[i-1] == 1)
                f[++m] = i;

        f[m+1] = n+1;

        if (S == 0) {

            for (int i = 1; i <= m+1; i++) {
                int x = f[i] - f[i-1] - 1;
                result += (x * (x + 1)) >> 1;
            }

            return result;
        }

        for (int i = 1; i <= m - S + 1; i++)
            result += (f[i] - f[i-1]) * (f[i+S] - f[i+S-1]);

        return result;
    }

}
