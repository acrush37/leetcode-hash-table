package medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
    Given a string, sort it in decreasing order based on the frequency of characters.
 */
public class SortCharactersByFrequency {

    public static void main(String... args) {

        SortCharactersByFrequency sortCharactersByFrequency = new SortCharactersByFrequency();
        System.out.println(sortCharactersByFrequency.frequencySort("Aabb"));
    }

    public String frequencySort(String s) {

        String result = "";
        int[] f = new int[256];
        char[] ch = s.toCharArray();
        for (char c : ch) f[c]++;
        int n = ch.length;
        Set<Character>[] t = new Set[n+1];

        for (char c : ch) {
            if (t[f[c]] == null) t[f[c]] = new HashSet<>();
            t[f[c]].add(c);
        }

        for (int i = n; i >= 1; i--)
            if (t[i] != null)
                for (char c : t[i])
                    for (int j = 0; j < i; j++)
                        result += c;

        return result;
    }

}
