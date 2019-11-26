package easy;

/*
    You're given strings J representing the types of stones that are jewels, and S representing the stones you have.
    Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.

    The letters in J are guaranteed distinct, and all characters in J and S are letters.
    Letters are case sensitive, so "a" is considered a different type of stone from "A".
 */
public class JewelsAndStones {

    public static void main(String... args) {

        JewelsAndStones jewelsAndStones = new JewelsAndStones();
        System.out.println(jewelsAndStones.numJewelsInStones("aA", "aAAbbbb"));
    }

    public int numJewelsInStones(String J, String S) {

        boolean[] t = new boolean[123];
        char[] ch = J.toCharArray();
        for (char c : ch) t[c] = true;
        int result = 0;
        ch = S.toCharArray();
        for (char c : ch) if (t[c]) result++;
        return result;
    }

}
