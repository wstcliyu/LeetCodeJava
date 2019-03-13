import java.util.*;

class Is_392 {
    // My first solution using Collections.binarySearch(list, key)
    // similar with the most voted 
    // This solution is for the follow-up question
    // Original question can be solved by two pointers
    public boolean isSubsequence(String s, String t) {
        List<List<Integer>> ls = new ArrayList<>();
        for (int i = 0; i < 26; i++) ls.add(new ArrayList<>());
        for (int i = 0; i < t.length(); i++) ls.get(t.charAt(i) - 'a').add(i);
        int prev = 0;
        for (char c : s.toCharArray()) {
            List<Integer> tmp = ls.get(c - 'a');
            int p = Collections.binarySearch(tmp, prev);
            if (p < 0) p = - p - 1;
            if (p == tmp.size()) return false;
            prev = tmp.get(p) + 1;
        }
        return true;
    }
}