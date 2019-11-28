package medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
    Now, given a dictionary consisting of many roots and a sentence.
    You need to replace all the successor in the sentence with the root forming it.
    If a successor has many roots can form it, replace it with the root with the shortest length.
 */
public class ReplaceWords {

    public static void main(String... args) {

        List<String> dict = Arrays.asList("cat", "bat", "rat");
        ReplaceWords replaceWords = new ReplaceWords();
        System.out.println(replaceWords.replaceWords(dict, "the cattle was rattled by the battery"));
    }

    public String replaceWords(List<String> dict, String sentence) {

        dict.sort(Comparator.comparingInt(x -> x.length()));
        String[] s = sentence.split(" ");
        StringBuilder sb = new StringBuilder();

        for (String word : s) {

            boolean flag = true;

            for (String d : dict)
                if (word.startsWith(d)) {
                    sb.append(d).append(" ");
                    flag = false;
                    break;
                }

            if (flag) sb.append(word).append(" ");
        }

        return sb.toString().trim();
    }

}
