import java.util.List;

public class Longest_524 {
    public String findLongestWord(String s, List<String> d) {
        String res = "";
        for (String candidate : d) {
            if (helper(s, candidate)) {
                if (candidate.length() > res.length() ||
                        candidate.length() == res.length() && candidate.compareTo(res) < 0)
                    res = candidate;
            }
        }
        return res;
    }

    private boolean helper(String s, String candidate) {
        int i = 0, j = 0;
        while (i < s.length() && j < candidate.length()) {
            if (s.charAt(i++) == candidate.charAt(j)) j++;
        }
        return j == candidate.length();
    }
}
