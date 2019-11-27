package easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
    Suppose Andy and Doris want to choose a restaurant for dinner, and they both have a list of favorite restaurants represented by strings.

    You need to help them find out their common interest with the least list index sum.

    If there is a choice tie between answers, output all of them with no order requirement.
 */
public class MinimumIndexSumOfTwoLists {

    public static void main(String... args) {

        String[] list1 = {"Shogun","Tapioca Express","Burger King","KFC"};
        String[] list2 = {"KFC","Shogun","Burger King"};
        MinimumIndexSumOfTwoLists minimumIndexSumOfTwoLists = new MinimumIndexSumOfTwoLists();
        System.out.println(minimumIndexSumOfTwoLists.findRestaurant(list1, list2));
    }

    public String[] findRestaurant(String[] list1, String[] list2) {

        int min = 2000;
        int n = list2.length;
        int[] f = new int[n];
        Map<String, Integer> m = new HashMap<>();
        for (int i = 0; i < list1.length; i++) m.put(list1[i], i);

        for (int i = 0; i < n; i++) {
            Integer x = m.get(list2[i]);
            if (x != null && x + i <= min) f[i] = (min = x + i) + 1;
        }

        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) if (f[i] == min + 1) list.add(list2[i]);
        String[] result = new String[list.size()];
        list.toArray(result);
        return result;
    }
}
