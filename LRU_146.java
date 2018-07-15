import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class LRU_146 {
    HashMap<Integer, Integer> map;
    Queue<Integer> q;
    int empty;
    public LRU_146(int capacity) {
        map = new HashMap<>();
        q = new LinkedList<>();
        empty = capacity;
    }

    public int get(int key) {
        if (!map.containsKey(key))
            return -1;
        q.remove(key);
        q.add(key);
        return map.get(key);
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.put(key, value);
            q.remove(key);
            q.add(key);
        }
        else {
            map.put(key, value);
            q.add(key);
            if (--empty < 0) {
                map.remove(q.peek());
                empty++;
            }
        }
    }
}
