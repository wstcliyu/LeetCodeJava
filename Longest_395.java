class Longest_395 {
    public int longestSubstring(String s, int k) {
        if (s == null || s.length() == 0) return 0;
        int[] freq = new int[26];
        for (char c : s.toCharArray()) freq[c - 'a']++;
        boolean flag = true;
        for (int f : freq) if (f > 0 && f < k) flag = false;
        if (flag) return s.length();
        int res = 0, start = 0;
        for (int i = 0; i <= s.length(); i++) {
            if (i == s.length() || freq[s.charAt(i) - 'a'] < k) {
                res = Math.max(res, longestSubstring(s.substring(start, i), k));
                start = i + 1;
            }
        }
        return res;
    }
}