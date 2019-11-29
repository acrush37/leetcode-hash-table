package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
    Create a timebased key-value store class TimeMap, that supports two operations.

    1. set(string key, string value, int timestamp)
    Stores the key and value, along with the given timestamp.

    2. get(string key, int timestamp)
    Returns a value such that set(key, value, timestamp_prev) was called previously, with timestamp_prev <= timestamp.
    If there are multiple such values, it returns the one with the largest timestamp_prev.
    If there are no values, it returns the empty string ("").
 */
public class TimeBasedKeyValueStore {

    private Map<String, List<Integer>> a = new HashMap<>();

    private Map<String, List<String>> b = new HashMap<>();

    public static void main(String... args) {

        TimeBasedKeyValueStore timeBasedKeyValueStore = new TimeBasedKeyValueStore();
        timeBasedKeyValueStore.set("love", "high", 10);
        timeBasedKeyValueStore.set("love", "low", 20);
        System.out.println(timeBasedKeyValueStore.get("love", 5));
        System.out.println(timeBasedKeyValueStore.get("love", 10));
        System.out.println(timeBasedKeyValueStore.get("love", 15));
        System.out.println(timeBasedKeyValueStore.get("love", 20));
        System.out.println(timeBasedKeyValueStore.get("love", 25));
    }

    private int find(int left, int right, List<Integer> list, int timestamp) {

        if (left == right) return left;
        int mid = (left + right) >> 1;
        int x = list.get(mid);
        if (x == timestamp) return mid;
        if (x > timestamp) return find(left, mid-1, list, timestamp);
        return find(mid+1, right, list, timestamp);
    }

    public void set(String key, String value, int timestamp) {

        List<Integer> x = a.get(key);
        List<String> y = b.get(key);

        if (x == null) {
            x = new ArrayList<>();
            y = new ArrayList<>();
        }

        int z = find(0, x.size(), x, timestamp);
        x.add(z, timestamp);
        y.add(z, value);
        a.put(key, x);
        b.put(key, y);
    }

    public String get(String key, int timestamp) {

        List<Integer> x = a.get(key);
        if (x == null) return "";
        int p = find(0, x.size(), x, timestamp);
        if (p == 0) return x.get(0) <= timestamp ? b.get(key).get(0) : "";
        return b.get(key).get(Math.min(p, x.size()-1));
    }

}
