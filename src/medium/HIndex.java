package medium;

import java.util.Arrays;

/*
    Given an array of citations (each citation is a non-negative integer)
    of a researcher, write a function to compute the researcher's h-index.

    According to the definition of h-index on Wikipedia: "A scientist has index h if h of his/her N
    papers have at least h citations each, and the other N − h papers have no more than h citations each."
 */
public class HIndex {

    public static void main(String... args) {

        int[] citations = {3, 0, 6, 1, 5};
        HIndex hIndex = new HIndex();
        System.out.println(hIndex.hIndex(citations));
    }

    public int hIndex(int[] citations) {

        Arrays.sort(citations);
        int n = citations.length;

        for (int i = n-1; i >= 0; i--)
            if (citations[i] >= n-i) {
                if (i == 0) return n;
                if (citations[i-1] <= n-i) return n-i;
            }

        return 0;
    }

}
