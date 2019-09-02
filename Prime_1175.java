class Prime_1175 {
    // My solution
    public final int MOD = 1_000_000_007;
    
    public int numPrimeArrangements(int n) {
        boolean[] prime = new boolean[n + 1];
        Arrays.fill(prime, true);
        int count = 0;
        for (int i = 2; i <= n; i++) {
            if (prime[i]) {
                count++;
                for (int j = 2; j * i <= n; j++) {
                    prime[j * i] = false;
                }
            }
        }
        
        // Pay attention here long res = 1
        long res = 1;
        for (int i = count; i > 1; i--)
            res = (res * i) % MOD;
        for (int i = n - count; i > 1; i--)
            res = (res * i) % MOD;
        return (int)res;
    }
}