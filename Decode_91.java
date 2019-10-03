class Decode_91 {
    // Most voted solution
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        if (s.charAt(0) != '0') dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int first = Integer.valueOf(s.substring(i - 1, i));
            int second = Integer.valueOf(s.substring(i - 2, i));
            if (first >= 1 && first <= 9)
                dp[i] += dp[i - 1];
            if (second >= 10 && second <= 26)
                dp[i] += dp[i - 2];
        }
        return dp[n];
    }



    // Rewrite most voted solution
    /*
    public int numDecodings(String s) {
        int a = 1;
        int b = 0;
        if (s.charAt(0) != '0') b = 1;
        for (int i = 1; i < s.length(); i++) {
            int first = Integer.valueOf(s.substring(i, i + 1));
            int second = Integer.valueOf(s.substring(i - 1, i + 1));
            int c = 0;
            if (first >= 1 && first <= 9)
                c += b;
            if (second >= 10 && second <= 26)
                c += a;
            a = b;
            b = c;
        }
        return b;
    }
    */
}