package easy;

/*
    Given two strings s and t , write a function to determine if t is an anagram of s.
 */
public class ValidAnagram {

    public static void main(String... args) {

        ValidAnagram validAnagram = new ValidAnagram();
        System.out.println(validAnagram.isAnagram("anagram", "nagaram"));
    }

    public boolean isAnagram(String s, String t) {

        int[] f = new int[123];
        char[] ch = s.toCharArray();
        for (char c : ch) f[c]++;
        ch = t.toCharArray();
        for (char c : ch) f[c]--;
        for (char i = 'a'; i <= 'z'; i++) if (f[i] != 0) return false;
        return true;
    }

}
