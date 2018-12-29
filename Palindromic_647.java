public class Palindromic_647 {
    // Use Manachar's Algorithm to find longest palindrome substring with time: O(n)
    // https://www.youtube.com/watch?v=nbTSfrEfo6M

    public int countSubstrings(String S) {
        char[] T = new char[2 * S.length() + 3];
        T[0] = '@';
        T[1] = '#';
        T[T.length - 1] = '$';
        int t = 2;
        for (char c: S.toCharArray()) {
            T[t++] = c;
            T[t++] = '#';
        }

        // P is the array to store the longest length of palindrome substring with center at each index

        int[] P = new int[T.length];
        int center = 0, right = 0;
        for (int i = 1; i < P.length - 1; i++) {
            // Note that i is always greater than center, so mirr is left to center, i is right to center
            int mirr = 2 * center - i;
            if (i < right)
                P[i] = Math.min(right - i, P[mirr]);

            // If P[mirr] < right - i, it means that the longest palindrome substring with center at mirr
            // is within the left boundary corresponding to center and right, then P[i] = P[mirr],
            // the following while loop will not execute

            // If P[mirr] >= right - i, it means that the longest palindrome substring with center at mirr
            // exceeds the left boundary corresponding to center and right, then P[i] >= right - i,
            // the following while loop will execute to expand the palindrome substring with center at i

            while (T[i + P[i] + 1] == T[i - P[i] - 1])
                P[i]++;
            if (i + P[i] > right) {
                center = i;
                right = i + P[i];
            }
        }

        // The above is an implementation of Manachar's Algorithm
        int ans = 0;
        for (int v: P) ans += (v + 1) / 2;
        return ans;
    }


    // Most voted solution using DP, with space: O(1)
    /*
    int count = 0;

    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) return 0;

        for (int i = 0; i < s.length(); i++) { // i is the mid point
            extendPalindrome(s, i, i); // odd length;
            extendPalindrome(s, i, i + 1); // even length
        }

        return count;
    }

    private void extendPalindrome(String s, int left, int right) {
        while (left >=0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++; left--; right++;
        }
    }
    */


    // My first solution using DP, very verbose, with space: O(n^2)
    /*
    public int countSubstrings(String s) {
        int N = s.length();
        if (N == 0) return 0;
        char[] c = s.toCharArray();
        int res = N;
        boolean[][] dp = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            dp[i][i] = true;
            if (i < N - 1) {
                dp[i][i + 1] = c[i] == c[i + 1];
                res += dp[i][i + 1] ? 1 : 0;
            }
        }
        for (int d = 2; d < N; d++) {
            for (int i = 0; i + d < N; i++) {
                dp[i][i + d] = dp[i + 1][i + d - 1] && c[i] == c[i + d];
                res += dp[i][i + d] ? 1 : 0;
            }
        }
        return res;
    }
    */
}
