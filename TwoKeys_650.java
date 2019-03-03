public class TwoKeys_650 {
    // Standard solution
    /*
    public int minSteps(int n) {
        int res = 0, d = 2;
        while (n > 1) {
            while (n % d == 0) {
                res += d;
                n /= d;
            }
            d++;
        }
        return res;
    }
    */


    // Recursive version
    public int minSteps(int n) {
        for (int d = 2; d <= n; d++)
            if (n % d == 0) return d + minSteps(n/d);
        return 0;
    }
}
