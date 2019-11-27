package easy;

/*
    In a array A of size 2N, there are N+1 unique elements, and exactly one of these elements is repeated N times.

    Return the element repeated N times.
 */
public class NRepeatedElementInSize2NArray {

    public static void main(String... args) {

        int[] A = {5, 1, 5, 2, 5, 3, 5, 4};
        NRepeatedElementInSize2NArray nRepeatedElementInSize2NArray = new NRepeatedElementInSize2NArray();
        System.out.println(nRepeatedElementInSize2NArray.repeatedNTimes(A));
    }

    public int repeatedNTimes(int[] A) {

        boolean[] t = new boolean[10000];

        for (int x : A)
            if (t[x]) return x;
            else t[x] = true;

        return 0;
    }

}
