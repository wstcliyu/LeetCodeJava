import java.util.Arrays;

public class Design_706 {

    // My first solution
    /*
    int[] map;

    public Design_706() {
        map = new int[1000001];
        Arrays.fill(map, -1);
    }

    public void put(int key, int value) {
        map[key] = value;
    }

    public int get(int key) {
        return map[key];
    }

    public void remove(int key) {
        map[key] = -1;
    }
    */


    // Most voted solution
    class Bucket {
        ListNode head = new ListNode(-1, -1);
    }

    class ListNode {
        int key, val;
        ListNode next;
        ListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private int idx(int key) {
        return Integer.hashCode(key) % buckets.length;
    }

    private ListNode find(Bucket bucket, int key) {
        ListNode node = bucket.head;
        ListNode prev = null;
        while (node != null && node.key != key) {
            prev = node;
            node = node.next;
        }
        return prev;
    }

    Bucket[] buckets;

    public Design_706() {
        buckets = new Bucket[6789];
    }

    public void put(int key, int value) {
        int i = idx(key);
        if (buckets[i] == null)
            buckets[i] = new Bucket();
        ListNode prev = find(buckets[i], key);
        if (prev.next == null)
            prev.next = new ListNode(key, value);
        else
            prev.next.val = value;
    }

    public int get(int key) {
        int i = idx(key);
        if (buckets[i] == null)
            return -1;
        ListNode prev = find(buckets[i], key);
        if (prev.next == null)
            return -1;
        else
            return prev.next.val;
    }

    public void remove(int key) {
        int i = idx(key);
        if (buckets[i] == null)
            return;
        ListNode prev = find(buckets[i], key);
        if (prev.next == null)
            return;
        else
            prev.next = prev.next.next;
    }
}
