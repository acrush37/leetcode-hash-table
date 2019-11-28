package easy;

/*
    Write a function to return a hint according to the secret number and friend's guess,
    use A to indicate the bulls and B to indicate the cows.

    Please note that both secret number and friend's guess may contain duplicate digits.
 */
public class BullsAndCows {

    public static void main(String... args) {

        BullsAndCows bullsAndCows = new BullsAndCows();
        System.out.println(bullsAndCows.getHint("1123", "0111"));
    }

    public String getHint(String secret, String guess) {

        int[] f = new int[58], g = new int[58];
        int bulls = 0, cows = 0, n = secret.length();
        char[] a = secret.toCharArray(), b = guess.toCharArray();

        for (int i = 0; i < n; i++)
            if (a[i] == b[i]) bulls++;
            else {
                f[a[i]]++;
                g[b[i]]++;
            }

        for (char i = '0'; i <= '9'; i++) cows += Math.min(f[i], g[i]);
        return bulls + "A" + cows + "B";
    }

}
