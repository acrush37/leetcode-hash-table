package easy;

/*
    Given two strings s and t, determine if they are isomorphic.

    Two strings are isomorphic if the characters in s can be replaced to get t.

    All occurrences of a character must be replaced with another character while preserving the order of characters.

    No two characters may map to the same character but a character may map to itself.
 */
public class IsomorphicStrings {

    public static void main(String... args) {

        IsomorphicStrings isomorphicStrings = new IsomorphicStrings();
        System.out.println(isomorphicStrings.isIsomorphic("egg", "add"));
    }

    public boolean isIsomorphic(String s, String t) {

        int n = s.length();
        int[] f = new int[255];
        int[] g = new int[255];
        char[] a = s.toCharArray();
        char[] b = t.toCharArray();

        for (int i = 0; i < n; i++)
            if (f[a[i]] == 0) {
                if (g[b[i]] == 0) {
                    f[a[i]] = b[i];
                    g[b[i]] = a[i];
                } else if (g[b[i]] != a[i]) return false;
            } else if (f[a[i]] != b[i]) return false;

        return true;
    }

}
