class Longest_159 {
	// My updated solution: Longest window, refer to 3, 159, 340, 1004, 424
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int[] freq = new int[128];
        int l = 0, r = 0, distinct = 0;
        for (; r < s.length(); r++) {
            if (++freq[s.charAt(r)] == 1) distinct++;
            if (distinct > 2 && --freq[s.charAt(l++)] == 0) distinct--;
        }
        return r - l;
    }
}