public class Design_705 {

    // My first solution using the framework of designing HashMap. Refer to Design_706
    /*
    class Bucket {
        ListNode head = new ListNode(-1);
    }

    class ListNode {
        int key;
        ListNode next;
        ListNode(int key) {
            this.key = key;
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

    public Design_705() {
        buckets = new Bucket[6789];
    }

    public void add(int key) {
        int i = idx(key);
        if (buckets[i] == null)
            buckets[i] = new Bucket();
        ListNode prev = find(buckets[i], key);
        if (prev.next == null)
            prev.next = new ListNode(key);
    }

    public void remove(int key) {
        int i = idx(key);
        if (buckets[i] == null)
            return;
        ListNode prev = find(buckets[i], key);
        if (prev.next != null)
            prev.next = prev.next.next;
    }


    public boolean contains(int key) {
        int i = idx(key);
        if (buckets[i] == null)
            return false;
        ListNode prev = find(buckets[i], key);
        if (prev.next == null)
            return false;
        else
            return true;
    }
    */


    // Most voted solution
    private int buckets = 1000;
    private int itemsPerBucket = 1001;
    private boolean[][] table;

    /** Initialize your data structure here. */
    public Design_705() {
        table = new boolean[buckets][];
    }

    public int hash(int key) {
        return key % buckets;
    }

    public int pos(int key) {
        return key / buckets;
    }

    public void add(int key) {
        int hashkey = hash(key);

        if (table[hashkey] == null) {
            table[hashkey] = new boolean[itemsPerBucket];
        }
        table[hashkey][pos(key)] = true;
    }

    public void remove(int key) {
        int hashkey = hash(key);

        if (table[hashkey] != null)
            table[hashkey][pos(key)] = false;
    }

    /** Returns true if this set did not already contain the specified element */
    public boolean contains(int key) {
        int hashkey = hash(key);
        return table[hashkey] != null && table[hashkey][pos(key)];
    }
}
