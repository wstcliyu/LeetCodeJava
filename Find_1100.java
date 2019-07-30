class Find_1100 {
    // My first solution: sliding window
    public int numKLenSubstrNoRepeats(String S, int K) {
        if (S.length() < K) return 0;
        int n = S.length();
        int[] freq = new int[26];
        int repeat = 0;
        int left = 0, right = 0;
        int res = 0;
        while (right < n) {
            if (freq[S.charAt(right++) - 'a']++ == 1) repeat++;
            if (right - left == K) {
                if (repeat == 0) res++;
                if (--freq[S.charAt(left++) - 'a'] == 1) repeat--;
            }
        }
        return res;
    }
}