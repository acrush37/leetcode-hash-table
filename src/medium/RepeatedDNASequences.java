package medium;

import java.util.*;

import java.util.Map.Entry;
/*
    All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG".
    When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.

    Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.
 */
public class RepeatedDNASequences {

    public static void main(String... args) {

        RepeatedDNASequences repeatedDNASequences = new RepeatedDNASequences();
        System.out.println(repeatedDNASequences.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
    }

    public List<String> findRepeatedDnaSequences(String s) {

        int n = s.length();
        if (n <= 10) return Collections.EMPTY_LIST;
        StringBuilder sb = new StringBuilder(s.substring(0, 10));
        Map<String, Integer> m = new HashMap<>();
        char[] c = s.toCharArray();
        m.put(sb.toString(), 1);

        for (int i = 10; i < n; i++) {

            String str = sb.deleteCharAt(0).append(c[i]).toString();
            Integer x = m.get(str);
            m.put(str, x == null ? 1 : 1 + x);
        }

        List<String> result = new ArrayList<>();
        Set<Entry<String, Integer>> entries = m.entrySet();

        for (Entry<String, Integer> entry : entries)
            if (entry.getValue() >= 2)
                result.add(entry.getKey());

        return result;
    }

}
