import java.util.*;

public class Word_140 {
    // Most voted solution using dfs
    // dfs + memorization == top-down DP
    public List<String> wordBreak(String s, List<String> wordDict) {
        return dfs(s, wordDict, new HashMap<>());
    }

    // DFS function returns an array including all substrings derived from s.
    List<String> dfs(String s, List<String> wordDict, HashMap<String, List<String>> map) {
        if (map.containsKey(s)) return map.get(s);

        List<String> res = new ArrayList<>();
        if (s.length() == 0) {
            res.add("");
            return res;
        }

        for (String word : wordDict) {
            if (s.startsWith(word)) {
                List<String> sublist = dfs(s.substring(word.length()), wordDict, map);
                for (String sub : sublist)
                    res.add(word + (sub.isEmpty() ? "" : " ") + sub);
            }
        }
        map.put(s, res);
        return res;
    }

    // My first solution using backtrack (rejected because of TLE)
    // 31/39 test cases passed
    /*
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();
        backtrack(s, wordDict, res, 0, new StringBuilder());
        return res;
    }

    private void backtrack(String s, List<String> wordDict, List<String> res, int start, StringBuilder sb) {
        if (start == s.length()) res.add(sb.deleteCharAt(sb.length()-1).toString());
        for (String word : wordDict) {
            int end = start + word.length();
            if (end <= s.length() && word.equals(s.substring(start, end)))
                backtrack(s, wordDict, res, end, new StringBuilder(sb).append(s.substring(start, end)).append(" "));
        }
    }
    */
}
