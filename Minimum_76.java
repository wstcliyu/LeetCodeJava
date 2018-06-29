public class Minimum_76 {
    public String minWindow(String s, String t) {
        String res = "";
        if (s.length() < t.length())
            return res;
        int[] freq = new int[256];
        for (char c:t.toCharArray())
            freq[c]++;
        int left = 0, right = 0, count = t.length();
        while (right < s.length()) {
            if (freq[s.charAt(right++)]-- > 0)
                count--;
            while (count == 0) {
                if (res.length() == 0 || res.length() > right-left)
                    res = s.substring(left, right);
                if (freq[s.charAt(left++)]++ == 0)
                    count++;
            }
        }
        return res;
    }
}
