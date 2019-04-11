class Longest_424 {
    // maxCount is the upper bound for the local maxCount in any sliding window
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int res = 0, left = 0, right = 0, maxCount = 0;
        while (right < s.length()) {
            maxCount = Math.max(maxCount, ++freq[s.charAt(right++) - 'A']);
            if (right - left > maxCount + k)
                --freq[s.charAt(left++) - 'A'];
            res = Math.max(res, right - left);
        }
        return res;
    }




    // Good submission
    // Since the problem is to find the longest length of the sliding window,
    // we don't need to decrement the length of the sliding window.
    // Let the length of sliding window grow and finally we will get the longest length by N - left;
    /*
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int left = 0, right = 0, maxCount = 0, N = s.length();
        for (char[] S = s.toCharArray(); right < N; right++)
            if (right - left - (maxCount = Math.max(maxCount, ++freq[S[right] - 'A'])) >= k)
                --freq[S[left++] - 'A'];
        return N - left;
    }
    */
}