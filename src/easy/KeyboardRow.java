package easy;

import java.util.ArrayList;
import java.util.List;

/*
    Given a List of words, return the words that can be typed using letters
    of alphabet on only one row's of American keyboard like the image below.
 */
public class KeyboardRow {

    public static void main(String... args) {

        String[] words = {"Hello", "Alaska", "Dad", "Peace"};
        KeyboardRow keyboardRow = new KeyboardRow();
        System.out.println(keyboardRow.findWords(words));
    }

    public String[] findWords(String[] words) {

        int[] f = new int[123];
        char[] ch = "ASDFGHJKL".toCharArray();
        for (char c : ch) f[c] = f[c+32] = 1;
        ch = "ZXCVBNM".toCharArray();
        for (char c : ch) f[c] = f[c+32] = 2;
        List<String> list = new ArrayList<>();

        for (String word : words) {

            boolean flag = true;
            ch = word.toCharArray();

            for (int i = 1; i < ch.length; i++)
                if (f[ch[i]] != f[ch[0]]) {
                    flag = false;
                    break;
                }

            if (flag) list.add(word);
        }

        String[] result = new String[list.size()];
        list.toArray(result);
        return result;
    }

}
