package easy;

/*
    Design a HashSet without using any built-in hash table libraries.
 */
public class DesignHashSet {

    private boolean[] t = new boolean[1000001];

    public static void main(String... args) {

        DesignHashSet designHashSet = new DesignHashSet();
        System.out.println(designHashSet.contains(10));
        designHashSet.add(10);
        System.out.println(designHashSet.contains(10));
    }

    public void add(int key) {
        t[key] = true;
    }

    public void remove(int key) {
        t[key] = false;
    }

    public boolean contains(int key) {
        return t[key];
    }

}
