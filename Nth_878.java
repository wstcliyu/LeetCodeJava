class Nth_878 {
    // My first solution using binary search (same as standard solution #2)
    public int nthMagicalNumber(int N, int A, int B) {
        int lca = A * B / gcd(A, B);
        long lo = 2, hi = Long.MAX_VALUE;
        while (lo < hi) {
            long mid = lo + (hi - lo) / 2;
            long count = mid / A + mid / B - mid / lca;
            if (count < N)
                lo = mid + 1;
            else
                hi = mid;
        }
        return (int)(lo % 1_000_000_007);
    }
    
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a%b);
    }
}