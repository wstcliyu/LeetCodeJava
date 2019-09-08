import java.util.*;

class Longest_1048 {
    // My first solution
    /*
    public int longestStrChain(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words)
            map.put(word, 1);
        int res = 1;
        for (String word : words) {
            res = Math.max(res, helper(word, map));
        }
        return res;
    }
    
    private int helper(String word, Map<String, Integer> map) {
        if (map.get(word) > 1)
            return map.get(word);
        int res = 1;
        for (int i = 0; i < word.length(); i++) {
            String pre = word.substring(0, i) + word.substring(i + 1);
            if (map.containsKey(pre))
                res = Math.max(res, 1 + helper(pre, map));
        }
        map.put(word, res);
        return res;
    }
    */



    // Most voted solution from lee215 (slower than mine)
    public int longestStrChain(String[] words) {
        Map<String, Integer> dp = new HashMap<>();
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        int res = 0;
        for (String word : words) {
            int best = 0;
            for (int i = 0; i < word.length(); ++i) {
                String prev = word.substring(0, i) + word.substring(i + 1);
                best = Math.max(best, dp.getOrDefault(prev, 0) + 1);
            }
            dp.put(word, best);
            res = Math.max(res, best);
        }
        return res;
    }



    // Good submission
    /*
    private boolean match(String cur, String next) {
        if (next.length() - cur.length() != 1) return false;
        int i = 0, j = 0;
        boolean inserted = false;
        while (i < cur.length()) {
            if (cur.charAt(i) != next.charAt(j)) {
                if (inserted) return false;
                inserted = true;
                j++;
            } else {
                i++;
                j++;
            }
        }
        return true;
    }

    private int test(String cur, int idx, List<List<String>> strings) {
        if (idx == 15) return 1;
        int res = 1;
        for (String next : strings.get(idx + 1)) {
            if (match(cur, next))
                res = Math.max(res, 1 + test(next, idx + 1, strings));
        }
        return res;
    }

    public int longestStrChain(String[] words) {
        List<List<String>> strings = new ArrayList<>();
        for (int i = 0; i < 16; i++)
            strings.add(new ArrayList<>());
        for (String word : words)
            strings.get(word.length() - 1).add(word);
        int res = 0;
        for (int i = 0; i < 16 && res < 16 - i; i++) {
            for (String cur : strings.get(i))
                res = Math.max(res, test(cur, i, strings));
        }
        return res;
    }
    */
}