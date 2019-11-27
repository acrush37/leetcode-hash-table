package easy;

/*
    Given a string which consists of lowercase or uppercase letters, find the
    length of the longest palindromes that can be built with those letters.
 */
public class LongestPalindrome {

    public static void main(String... args) {

        LongestPalindrome longestPalindrome = new LongestPalindrome();
        System.out.println(longestPalindrome.longestPalindrome("abccccdd"));
    }

    public int longestPalindrome(String s) {

        int odd = 0;
        int even = 0;
        int[] f = new int[123];
        char[] ch = s.toCharArray();
        for (char c : ch) f[c]++;

        for (char i = 'a'; i <= 'z'; i++)
            if ((f[i] & 1) == 0) even += f[i];
            else {
                odd = 1;
                even += f[i] - 1;
            }

        for (char i = 'A'; i <= 'Z'; i++)
            if ((f[i] & 1) == 0) even += f[i];
            else {
                odd = 1;
                even += f[i] - 1;
            }

        return even + odd;
    }

}
