import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Find_1002 {
	public List<String> commonChars(String[] A) {
        int[] count = new int[26];
        Arrays.fill(count, 100);
        for (String s : A) updateCount(s, count);
        List<String> res = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            char c = (char)('a' + i);
            for (int j = 0; j < count[i]; j++)
                res.add(c + "");
        }
        return res;
    }
    
    
    private void updateCount(String s, int[] count) {
        int[] tmp = new int[26];
        for (int i = 0; i < s.length(); i++)
            tmp[s.charAt(i) - 'a']++;
        for (int i = 0; i < 26; i++)
            count[i] = Math.min(count[i], tmp[i]);
    }
}