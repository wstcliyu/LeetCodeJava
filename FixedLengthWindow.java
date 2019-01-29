import java.util.*;

public class FixedLengthWindow {
    // Sliding window with a fixed length and distinct elements
    // Refer to Longest_3 for more
    // Refer to Find_438 for sliding window template


    public static void main(String[] args) {
        FixedLengthWindow test = new FixedLengthWindow();
        String s = "adfgkg";
        int k = 4;
        System.out.println(test.noReapeat(s, k).toString());
    }


    // DP with a map storing the index of last appearance of the current character
    /*
    public List<Integer> noReapeat(String s, int k) {
        List<Integer> res = new LinkedList<>();
        int start = -1;
        HashMap<Character, Integer> index = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            start = Math.max(start, index.getOrDefault(s.charAt(i), -1));
            if (i - start >= k) res.add(i - k + 1);
            index.put(s.charAt(i), i);
        }
        return res;
    }
    */


    // Sliding window using map
    /*
    public List<Integer> noReapeat(String s, int k) {
        List<Integer> res = new LinkedList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        int begin = 0, end = 0, count = 0;
        while (end < s.length()) {
            char c = s.charAt(end++);
            map.put(c, 1 + map.getOrDefault(c, 0));
            if (map.get(c) > 1) count++;

            while (count > 0 || end - begin > k) {
                char tmp = s.charAt(begin++);
                if (map.get(tmp) > 1) count--;
                map.put(tmp, -1 + map.get(tmp));
            }

            if (end - begin == k) res.add(begin);
        }
        return res;
    }
    */


    // Sliding window using set
    public List<Integer> noReapeat(String s, int k) {
        List<Integer> res = new LinkedList<>();
        HashSet<Character> set = new HashSet<>();
        int begin = 0, end = 0;
        while (end < s.length()) {
            char c = s.charAt(end);
            if (!set.contains(c)) {
                set.add(c);
                end++;
                if (end - begin >= k) res.add(end - k);
            } else
                set.remove(s.charAt(begin++));
        }
        return res;
    }

}
