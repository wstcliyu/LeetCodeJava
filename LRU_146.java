import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;


// I submitted the code to the leetcode website, but it says cannot find symbol: class LRUCache.
// After I added "public" at the very beginning before "class LRUCache", the code got accepted.

public class LRU_146 {

    public class DLinkedNode {
        int key;
        int value;
        DLinkedNode pre;
        DLinkedNode post;
    }

    private void removeNode(DLinkedNode node) {
        DLinkedNode pre = node.pre;
        DLinkedNode post = node.post;
        pre.post = post;
        post.pre = pre;
    }

    private DLinkedNode popTail() {
        DLinkedNode res = tail.pre;
        removeNode(res);
        return res;
    }

    private void addNode(DLinkedNode node) {
        node.pre = head;
        node.post = head.post;

        node.post.pre = node;
        node.pre.post = node;
    }

    private int capacity;
    private int count;
    private DLinkedNode head;
    private DLinkedNode tail;
    private HashMap<Integer, DLinkedNode> cache;

    public LRU_146(int capacity) {
        this.capacity = capacity;
        count = 0;
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.post = tail;
        tail.pre = head;
        cache = new HashMap<>();
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            // Debug
            // System.out.println(-1);
            return -1;
        }
        DLinkedNode node = cache.get(key);
        removeNode(node);
        addNode(node);
        // Debug
        // System.out.println(node.value);
        return node.value;
    }

    public void put(int key, int value) {
        if (!cache.containsKey(key)) {
            DLinkedNode newNode = new DLinkedNode();
            newNode.key = key;
            newNode.value = value;
            cache.put(key, newNode);
            addNode(newNode);
            if (++count > capacity) {
                cache.remove(popTail().key);
                count--;
            }
        }
        else {
            DLinkedNode node = cache.get(key);
            node.value = value;
            removeNode(node);
            addNode(node);
        }
    }

    // My first solution
    /*
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
    */

    public static void main(String[] args) {
        LRU_146 cache = new LRU_146( 2 /* capacity */ );
        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // returns 1
        cache.put(3, 3);    // evicts key 2
        cache.get(2);       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        cache.get(1);       // returns -1 (not found)
        cache.get(3);       // returns 3
        cache.get(4);       // returns 4
    }
}
