import java.util.*;

public class Longest_3 {
    // My updated solution: Longest window, refer to 3, 159, 340, 1004, 424
    public int lengthOfLongestSubstring(String s) {
        int[] freq = new int[128];
        int l = 0, r = 0, repeat = 0;
        for (; r < s.length(); r++) {
            if (++freq[s.charAt(r)] == 2) repeat++;
            if (repeat > 0 && --freq[s.charAt(l++)] == 1) repeat--;
        }
        return r - l;
    }



    // Sliding window using map
    /*
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int begin = 0, end = 0, counter = 0, d = 0;

        while (end < s.length()) {
            // > 0 means repeating character
            // if(map[s.charAt(end++)]-- > 0) counter++;
            char c = s.charAt(end++);
            map.put(c, 1 + map.getOrDefault(c, 0));
            if(map.get(c) > 1) counter++;

            while (counter > 0) {
                //if (map[s.charAt(begin++)]-- > 1) counter--;
                char charTemp = s.charAt(begin++);
                if (map.get(charTemp) > 1) counter--;
                map.put(charTemp, -1 + map.get(charTemp));
            }
            d = Math.max(d, end - begin);
        }
        return d;
    }
    */



    // Sliding window using set
    /*
    public int lengthOfLongestSubstring(String s) {
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
    }
    */



    // DP with a map storing the index of last appearance of the current character
    /*
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        int res = 0, start = -1;
        // int[] index = new int[128]; // int[128(256)] for (Extended) ASCII
        // Arrays.fill(index, -1);
        HashMap<Character, Integer> index = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            // start = Math.max(start, index[s.charAt(i)]);
            start = Math.max(start, index.getOrDefault(s.charAt(i), -1));
            res = Math.max(res, i - start);
            // index[s.charAt(i)] = i;
            index.put(s.charAt(i), i);
        }
        return res;
    }
    */
}
