import java.util.HashMap;

public class Longest_3 {
    public int lengthOfLongestSubstring(String s) {
        /* Two Pointers, Sliding Window
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else
                set.remove(s.charAt(i++));
        }
        return ans;
        */
        if (s == null || s.length() == 0)
            return 0;
        int res = 0, start = -1;
        // int[] index = new int[128]; // int[128(256)] for (Extended) ASCII
        // Arrays.fill(index, -1);
        HashMap<Character,Integer> index = new HashMap<>();
        for (int i=0; i<s.length(); i++) {
            // start = Math.max(start, index[s.charAt(i)]);
            start = Math.max(start, index.getOrDefault(s.charAt(i), -1));
            res = Math.max(res, i-start);
            // index[s.charAt(i)] = i;
            index.put(s.charAt(i), i);
        }
        return res;
    }
}
