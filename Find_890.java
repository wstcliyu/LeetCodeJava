import java.util.*;

public class Find_890 {

    // Most voted solution
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        int[] p = F(pattern);
        List<String> res = new ArrayList<String>();
        for (String w : words)
            if (Arrays.equals(F(w), p)) res.add(w);
        return res;
    }

    // F(w) returns a string which denotes the first occurrence of each character in w
    // If w and pattern follow the same pattern, then F(w) = F(pattern)
    public int[] F(String w) {
        HashMap<Character, Integer> m = new HashMap<>();
        int n = w.length();
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            m.putIfAbsent(w.charAt(i), m.size());
            res[i] = m.get(w.charAt(i));
        }
        return res;
    }


    // Standard solution using two maps
    /*
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> ans = new ArrayList();
        for (String word: words)
            if (match(word, pattern))
                ans.add(word);
        return ans;
    }

    public boolean match(String word, String pattern) {
        Map<Character, Character> m1 = new HashMap();
        Map<Character, Character> m2 = new HashMap();

        for (int i = 0; i < word.length(); ++i) {
            char w = word.charAt(i);
            char p = pattern.charAt(i);
            if (!m1.containsKey(w)) m1.put(w, p);
            if (!m2.containsKey(p)) m2.put(p, w);
            if (m1.get(w) != p || m2.get(p) != w)
                return false;
        }

        return true;
    }
    */


    // Standard solution using one map
    /*
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> ans = new ArrayList();
        for (String word: words)
            if (match(word, pattern))
                ans.add(word);
        return ans;
    }

    public boolean match(String word, String pattern) {
        Map<Character, Character> M = new HashMap();
        for (int i = 0; i < word.length(); ++i) {
            char w = word.charAt(i);
            char p = pattern.charAt(i);
            if (!M.containsKey(w)) M.put(w, p);
            if (M.get(w) != p) return false;
        }

        // Use array seen to check whether the values in M.values() are distinct or not
        // If not, then it is not one-to-one mapping
        boolean[] seen = new boolean[26];
        for (char p: M.values()) {
            if (seen[p - 'a']) return false;
            seen[p - 'a'] = true;
        }
        return true;
    }
    */


    // My first solution using one map
    /*
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res = new ArrayList<>();
        HashMap<Character, Character> map = new HashMap<>();
        for (String word : words) {
            int i = 0;
            for (; i < pattern.length(); i++) {
                char key = pattern.charAt(i);
                char val = word.charAt(i);
                if (!map.containsKey(key)) {
                    if (!map.containsValue(val))
                        map.put(key, val);
                    else
                        break;
                }
                else if (map.get(key) != val)
                    break;
            }
            if (i == pattern.length())
                res.add(word);
            map.clear();
        }
        return res;
    }
    */
}
