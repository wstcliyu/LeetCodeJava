import java.util.HashMap;

public class X_914 {
    // Time: O(NlogN)
    // Space: O(N)
    public boolean hasGroupsSizeX(int[] deck) {
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int card : deck)
            count.put(card, 1 + count.getOrDefault(card, 0));
        int g = 0;
        for (int freq : count.values())
            g = gcd(g, freq);
        return g > 1;
    }

    // Greatest Common Divisor
    // How to write gcd
    private int gcd(int x, int y) {
        return x == 0 ? y : gcd(y % x, x);
    }
}
