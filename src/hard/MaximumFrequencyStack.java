package hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
    Implement FreqStack, a class which simulates the operation of a stack-like data structure.

    FreqStack has two functions:
    push(int x), which pushes an integer x onto the stack.
    pop(), which removes and returns the most frequent element in the stack.

    If there is a tie for most frequent element, the element closest to the top of the stack is removed and returned.
 */
public class MaximumFrequencyStack {

    private int max;

    private List<Integer> t = new ArrayList<>();

    private Map<Integer, Integer> a = new HashMap<>();

    private Map<Integer, List<Integer>> b = new HashMap<>();

    public static void main(String... args) {

        MaximumFrequencyStack maximumFrequencyStack = new MaximumFrequencyStack();
        maximumFrequencyStack.push(5);
        maximumFrequencyStack.push(7);
        maximumFrequencyStack.push(5);
        maximumFrequencyStack.push(7);
        maximumFrequencyStack.push(4);
        maximumFrequencyStack.push(5);
        System.out.println(maximumFrequencyStack.pop());
        System.out.println(maximumFrequencyStack.pop());
        System.out.println(maximumFrequencyStack.pop());
        System.out.println(maximumFrequencyStack.pop());
    }

    public void push(int x) {

        int y = a.getOrDefault(x, 0) + 1;
        b.putIfAbsent(y, new ArrayList<>());
        b.get(y).add(t.size());
        max = Math.max(max, y);
        a.put(x, y);
        t.add(x);
    }

    public int pop() {

        List<Integer> x = b.get(max);
        int y = x.remove(x.size()-1);
        if (x.isEmpty()) b.remove(max--);
        int z = t.get(y), s = a.get(z);

        if (s == 1) a.remove(z);
        else a.put(z, s-1);

        return z;
    }

}
