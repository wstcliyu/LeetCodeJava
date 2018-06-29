import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Find_438 {
    public List<Integer> findAnagrams(String s, String p) {
        ArrayList<Integer> res = new ArrayList<>();
        if (s.length() < p.length())
            return res;
        int[] freq = new int[256];
        for (char c:p.toCharArray())
            freq[c]++;
        int left = 0, right = 0, count = p.length();
        while (right < s.length()) {
            if (freq[s.charAt(right++)]-- >= 0)
                count--;
            if (count == 0)
                res.add(left);
            if (right - left == p.length() && freq[s.charAt(left++)]++ >= 0)
                count++;
        }
        return res;
    }
}
