import java.util.HashMap;

public class Map_677 {
    // Read Standard Solution

    // Brutal Force
    HashMap<String, Integer> freq;

    public Map_677() {
        freq = new HashMap<>();
    }

    public void insert(String key, int val) {
        freq.put(key, freq.getOrDefault(key, 0) + val);
    }

    public int sum(String prefix) {
        int sum = 0;
        for (String s : freq.keySet())
            sum += s.startsWith(prefix) ? freq.get(s) : 0;
        return sum;
    }
}
