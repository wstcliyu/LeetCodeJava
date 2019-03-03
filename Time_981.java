import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;

public class Time_981 {
	Map<String, TreeMap<Integer, String>> M;

    public Time_981() {
        M = new HashMap();
    }

    public void set(String key, String value, int timestamp) {
        M.putIfAbsent(key, new TreeMap());
        M.get(key).put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        if (!M.containsKey(key)) return "";
        TreeMap<Integer, String> tree = M.get(key);
        // Integer t = tree.floorKey(timestamp);
        // return t != null ? tree.get(t) : "";
        Map.Entry<Integer, String> entry = tree.floorEntry(timestamp);
        return entry != null ? entry.getValue() : "";
    }
}