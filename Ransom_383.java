import java.util.HashMap;

public class Ransom_383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        // My first solution, why HashMap is much slower than Array
        /*
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c:magazine.toCharArray())
            map.put(c, 1+map.getOrDefault(c, 0));
        for (char c:ransomNote.toCharArray()) {
            if (!map.containsKey(c) || map.get(c) <= 0)
                return false;
            else
                map.put(c, map.get(c) - 1);
        }
        return true;
        */
        int[] freq = new int[26];
        for (char c:magazine.toCharArray())
            freq[c-'a']++;
        for (char c:ransomNote.toCharArray()) {
            if (--freq[c-'a'] < 0)
                return false;
        }
        return true;
    }
}
