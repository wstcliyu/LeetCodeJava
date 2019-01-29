import java.util.*;

public class Find_438 {
    // https://leetcode.com/problems/find-all-anagrams-in-a-string/discuss/92007/Sliding-Window-algorithm-template-to-solve-all-the-Leetcode-substring-search-problem.
    // Sliding Window Template
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new LinkedList<>();
        if (s.length() < p.length()) return res;
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : p.toCharArray()) map.put(c, 1 + map.getOrDefault(c, 0));
        int count = map.size(), begin = 0, end = 0;
        while (end < s.length()) {
            char c = s.charAt(end++);
            if (map.containsKey(c)) {
                map.put(c, -1 + map.get(c));
                if (map.get(c) == 0) count--;
            }

            while (count == 0) {
                if (end - begin == p.length()) res.add(begin);
                char tmp = s.charAt(begin++);
                if (map.containsKey(tmp)) {
                    map.put(tmp, 1 + map.get(tmp));
                    if (map.get(tmp) > 0) count++;
                }
            }

            /*
            while (end - begin == p.length()) {
                if (count == 0) res.add(begin);
                char tmp = s.charAt(begin++);
                if (map.containsKey(tmp)) {
                    if (map.get(tmp) == 0) count++;
                    map.put(tmp, 1 + map.get(tmp));
                }
            }
            */
        }
        return res;
    }


    // Good solution
    /*
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new LinkedList<>();
        if (s.length() < p.length()) return res;
        int[] freq = new int[256];
        for (char c : p.toCharArray()) freq[c]++;
        int left = 0, right = 0, count = p.length();
        while (right < s.length()) {
            if (freq[s.charAt(right++)]-- > 0) count--;
            if (count == 0) res.add(left);
            if (right - left == p.length() && ++freq[s.charAt(left++)] > 0) count++;
        }
        return res;
    }
    */


    public static void main(String[] args) {
        Find_438 test = new Find_438();
        String s = "aabaa";
        String p = "aa";
        List<Integer> res = test.findAnagrams(s, p);
        System.out.println(res.toString());
    }
}
