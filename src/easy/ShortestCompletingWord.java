package easy;

/*
    Find the minimum length word from a given dictionary words, which has all the letters from the string licensePlate.

    Such a word is said to complete the given string licensePlate

    Here, for letters we ignore case. For example, "P" on the licensePlate still matches "p" on the word.

    It is guaranteed an answer exists. If there are multiple answers, return the one that occurs first in the array.
 */
public class ShortestCompletingWord {

    public static void main(String... args) {

        String[] words = {"step", "steps", "stripe", "stepple"};
        ShortestCompletingWord shortestCompletingWord = new ShortestCompletingWord();
        System.out.println(shortestCompletingWord.shortestCompletingWord("1s3 PSt", words));
    }

    public String shortestCompletingWord(String licensePlate, String[] words) {

        int p = 0;
        int min = 15;
        char[] a = licensePlate.toCharArray();

        for (int i = 0; i < words.length; i++) {

            int[] f = new int[123];
            boolean flag = true;
            for (char c : a) f[c >= 97 ? c : c + 32]++;
            int n = words[i].length();
            char[] b = words[i].toCharArray();
            for (char c : b) f[c]--;

            for (char j = 'a'; j <= 'z'; j++)
                if (f[j] > 0) {
                    flag = false;
                    break;
                }

            if (flag && n < min) {
                p = i;
                min = n;
            }
        }

        return words[p];
    }

}
