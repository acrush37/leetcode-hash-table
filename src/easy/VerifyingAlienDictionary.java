package easy;

/*
    In an alien language, surprisingly they also use english lowercase letters, but possibly
    in a different order. The order of the alphabet is some permutation of lowercase letters.

    Given a sequence of words written in the alien language, and the order of the alphabet,
    return true if and only if the given words are sorted lexicographicaly in this alien language.
 */
public class VerifyingAlienDictionary {

    public static void main(String... args) {

        String[] words = {"hello", "leetcode"};
        VerifyingAlienDictionary verifyingAlienDictionary = new VerifyingAlienDictionary();
        System.out.println(verifyingAlienDictionary.isAlienSorted(words, "hlabcdefgijkmnopqrstuvwxyz"));
    }

    public boolean isAlienSorted(String[] words, String order) {

        int[] f = new int[123];
        char[] c = order.toCharArray();
        for (int i = 0; i < c.length; i++) f[c[i]] = i;
        int n = words.length-1;

        for (int i = 0; i < n; i++) {

            char[] a = words[i].toCharArray();
            char[] b = words[i+1].toCharArray();
            int k = Math.min(a.length, b.length);
            boolean flag = true;

            for (int j = 0; j < k; j++)
                if (f[a[j]] < f[b[j]]) {
                    flag = false;
                    break;
                } else if (f[a[j]] > f[b[j]]) return false;

            if (flag && a.length > b.length) return false;
        }

        return true;
    }

}
