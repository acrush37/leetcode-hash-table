package easy;

/*
    Design a HashMap without using any built-in hash table libraries.
 */
public class DesignHashMap {

    private Integer[] f = new Integer[1000001];

    public static void main(String... args) {

        DesignHashMap designHashMap = new DesignHashMap();
        System.out.println(designHashMap.get(1));
        designHashMap.put(1, 2);
        System.out.println(designHashMap.get(1));
    }

    public void put(int key, int value) {
        f[key] = value;
    }

    public int get(int key) {
        return f[key] == null ? -1 : f[key];
    }

    public void remove(int key) {
        f[key] = null;
    }

}
