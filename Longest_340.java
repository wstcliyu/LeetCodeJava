class Longest_340 {
    // My first solution: Sliding Window
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int left = 0, right = 0, count = 0, res = 0;
        int[] freq = new int[128];
        while (right < s.length()) {
            if (freq[s.charAt(right++)]++ == 0) count++;
            if (count <= k) res = Math.max(res, right - left);
            while (count > k) {
                if (--freq[s.charAt(left++)] == 0) count--;
            }
        }
        return res;
    }



    // My updated solution: Longest window, refer to 3, 159, 340, 1004, 424
    /*
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int left = 0, right = 0, res = 0;
        int[] freq = new int[128];
        while (right < s.length()) {
            if (freq[s.charAt(right++)]++ == 0) k--;
            if (k < 0 && --freq[s.charAt(left++)] == 0) k++;
        }
        return right - left;
    }
    */
}