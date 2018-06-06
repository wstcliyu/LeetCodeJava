public class SuperPow_372 {
    final int base = 1337;
    public int superPow(int a, int[] b) {
        return helper(a, b, b.length-1);
    }
    private int helper(int a, int[] b, int end) {
        if (end == 0)
            return powMod(a, b[0]);
        return powMod(helper(a, b, end-1), 10) * powMod(a, b[end]) % base;
    }
    private int powMod(int a, int k) {
        int res = 1;
        a %= base;
        for (int i=0; i<k; i++)
            res = (res * a) % base;
        return res;
    }
}
