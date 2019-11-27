package medium;

import java.util.ArrayList;
import java.util.List;

/*
    Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

    Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
 */
public class FindAllAnagramsInString {

    public static void main(String... args) {

        FindAllAnagramsInString findAllAnagramsInString = new FindAllAnagramsInString();
        System.out.println(findAllAnagramsInString.findAnagrams("cbaebabacd", "abc"));
    }

    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> result = new ArrayList<>();
        char[] a = p.toCharArray();
        char[] b = s.toCharArray();
        int m = s.length();
        int n = p.length();

        for (int i = 0; i <= m-n; i++) {

            boolean flag = true;
            int[] f = new int[123];
            for (char c : a) f[c]++;

            for (int j = i; j < i + n; j++)
                if (f[b[j]]-- == 0) {
                    flag = false;
                    break;
                }

            if (flag) result.add(i);
        }

        return result;
    }

}
