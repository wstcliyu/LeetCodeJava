public class Permutation_567 {
    // Refer to sliding window in Find_438
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        int[] freq = new int[256];
        for (char c : s1.toCharArray()) freq[c]++;
        int left = 0, right = 0, count = s1.length();
        while (right < s2.length()) {
            if (freq[s2.charAt(right++)]-- > 0) count--;
            if (count == 0) return true;
            if (right - left == s1.length() && ++freq[s2.charAt(left++)] > 0) count++;
        }
        return false;
    }
}
