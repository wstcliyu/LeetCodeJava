class Numbers_902 {
    // My first solution (similar with Numbers_1012) 
    public int atMostNGivenDigitSet(String[] D, int N) {
        List<Integer> digits = new ArrayList<>();
        for (int x = N + 1; x > 0; x /= 10)
            digits.add(0, x % 10);
        
        int n = digits.size();
        int m = D.length;
        int res = 0;
        for (int i = 1; i < n; i++)
            res += (int)Math.pow(m, i);
        
        int[] A = new int[m];
        for (int i = 0; i < m; i++)
            A[i] = Integer.valueOf(D[i]);
        
        for (int i = 0; i < n; i++) {
            int digit = digits.get(i);
            int j = 0;
            while (j < m && A[j] < digit) j++;
            res += j * (int)Math.pow(m, n - i - 1);
            if (j == m || A[j] > digit) break;
        }
        
        return res;
    }




    // Standard solution #1: DP
    // Let dp[i] be the number of ways to write a valid number if N became N[i], N[i+1], .... 
    // For example, if N = 2345, then dp[0] would be the number of valid numbers at most 2345, 
    // dp[1] would be the ones at most 345, dp[2] would be the ones at most 45, 
    // and dp[3] would be the ones at most 5.
    /*
    public int atMostNGivenDigitSet(String[] D, int N) {
        String S = String.valueOf(N);
        int K = S.length();
        int[] dp = new int[K+1];
        dp[K] = 1;

        for (int i = K-1; i >= 0; --i) {
            // compute dp[i]
            int Si = S.charAt(i) - '0';
            for (String d: D) {
                if (Integer.valueOf(d) < Si)
                    dp[i] += Math.pow(D.length, K-i-1);
                else if (Integer.valueOf(d) == Si)
                    dp[i] += dp[i+1];
            }
        }

        for (int i = 1; i < K; ++i)
            dp[0] += Math.pow(D.length, i);
        return dp[0];
    }
    */




    // Standard solution #2: Mathematical
    // Now let B = D.length. There is a bijection between valid integers and so called "bijective-base-B" numbers. 
    // For example, if D = ['1', '3', '5', '7'], then we could write the numbers '1', '3', '5', '7', '11', '13', '15', '17', '31', ... 
    // as (bijective-base-B) numbers '1', '2', '3', '4', '11', '12', '13', '14', '21', ....

    // Continuing our example, if N = 64, then the valid numbers are '1', '3', ..., '55', '57', 
    // which can be written as bijective-base-4 numbers '1', '2', ..., '33', '34'. 
    // Converting this last entry '34' to decimal, the answer is 16 (3 * 4 + 4).
    /*
    public int atMostNGivenDigitSet(String[] D, int N) {
        int B = D.length; // bijective-base B
        char[] ca = String.valueOf(N).toCharArray();
        int K = ca.length;
        int[] A = new int[K];
        int t = 0;

        for (char c: ca) {
            int c_index = 0;  // Largest such that c >= D[c_index - 1]
            boolean match = false;
            for (int i = 0; i < B; ++i) {
                if (c >= D[i].charAt(0))
                    c_index = i+1;
                if (c == D[i].charAt(0))
                    match = true;
            }

            A[t++] = c_index;
            if (match) continue;

            if (c_index == 0) { // subtract 1
                for (int j = t-1; j > 0; --j) {
                    if (A[j] > 0) break;
                    A[j] += B;
                    A[j-1]--;
                }
            }

            while (t < K)
                A[t++] = B;
            break;
        }

        int ans = 0;
        for (int x: A)
            ans = ans * B + x;
        return ans;
    }
    */
}
