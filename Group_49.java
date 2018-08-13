import java.util.*;

public class Group_49 {
    // https://leetcode.com/problems/group-anagrams/solution/

    // Standard Solution #1 Sorted String
    // Time: O(NKlogK), where N is the length of strs, and K is the maximum length of a string in strs
    // Space: O(NK)
    /*
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0)
            return new LinkedList<>();
        HashMap<String, List<String>> ans = new HashMap<>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String key = new String(ca); // String key = String.valueOf(ca);
            if (!ans.containsKey(key))
                ans.put(key, new LinkedList<>());
            ans.get(key).add(s);
        }
        return new LinkedList<>(ans.values());
    }
    */

    // Standard Solution #2 Count Characters
    // Time: O(NK)
    // Space: O(NK)
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0)
            return new ArrayList<>();
        Map<String, List<String>> ans = new HashMap<>();
        int[] count = new int[26];
        for (String s : strs) {
            Arrays.fill(count, 0);
            for (char c : s.toCharArray())
                count[c - 'a']++;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                sb.append('#');
                sb.append(count[i]);
            }
            String key = sb.toString();
            if (!ans.containsKey(key))
                ans.put(key, new ArrayList<>());
            ans.get(key).add(s);
        }
        return new ArrayList<>(ans.values());
    }
}
