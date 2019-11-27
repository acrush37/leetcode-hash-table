package easy;

import java.util.ArrayList;
import java.util.List;

/*
    Given words first and second, consider occurrences in some text of the form "first second third", where second comes immediately after first, and third comes immediately after second.

    For each such occurrence, add "third" to the answer, and return the answer.
 */
public class OccurrencesAfterBigram {

    public static void main(String... args) {

        String text = "alice is a good girl she is a good student";
        String first = "a";
        String second = "good";
        OccurrencesAfterBigram occurrencesAfterBigram = new OccurrencesAfterBigram();
        System.out.println(occurrencesAfterBigram.findOcurrences(text, first, second));
    }

    public String[] findOcurrences(String text, String first, String second) {

        List<String> list = new ArrayList<>();
        String[] s = text.split(" ");
        int n = s.length;

        for (int i = 0; i < n-2; i++)
            if (s[i].equals(first) && s[i+1].equals(second))
                list.add(s[i+2]);

        String[] result = new String[list.size()];
        list.toArray(result);
        return result;
    }

}
