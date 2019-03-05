public class All_432 {
	Map<String, Integer> count;
    Map<Integer, Bucket> buckets;
    Bucket head, tail;
    
    class Bucket {
        int val;
        Set<String> keys;
        Bucket prev, next;
        Bucket() {}
        Bucket(int _val) {
            val = _val;
            keys = new HashSet<>();
        }
    }

    /** Initialize your data structure here. */
    public AllOne() {
        count = new HashMap<>();
        buckets = new HashMap<>();  
        head = new Bucket();
        tail = new Bucket();
        head.next = tail;
        tail.prev = head;
    }
    

    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
    	int val = updateCountMap(key, 1);
    	updateBucketList(key, val, 1);
    }
    
    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        if (!count.containsKey(key)) return;
        int val = updateCountMap(key, -1);
        updateBucketList(key, val, -1);
    }

    private void updateBucketList(String key, int val, int incr) {
    	Bucket curBuc = buckets.getOrDefault(val, head);
    	
    	val += incr;

    	if (buckets.containsKey(val)) buckets.get(val).keys.add(key);
    	else if (incr > 0) addBefore(curBuc.next, key, val);
    	else if (val > 0) addBefore(curBuc, key, val);

    	removeFromBucket(curBuc, key);
    }

    private int updateCountMap(String key, int incr) {
    	int val = count.getOrDefault(key, 0);
    	count.remove(key);
    	if (val + incr > 0) count.put(key, val + incr);
    	return val;
    }

    
    private void addBefore(Bucket curBuc, String key, int val) {
        Bucket newBuc = new Bucket(val);
        newBuc.val = val;
        newBuc.keys.add(key);
        newBuc.next = curBuc;
        newBuc.prev = curBuc.prev;
        
        newBuc.next.prev = newBuc;
        newBuc.prev.next = newBuc;
        
        buckets.put(val, newBuc);
    }
    
    private void removeFromBucket(Bucket curBuc, String key) {
    	if (curBuc.keys == null) return;
    	
    	curBuc.keys.remove(key);
    	if (curBuc.keys.isEmpty()) {
    		curBuc.prev.next = curBuc.next;
	        curBuc.next.prev = curBuc.prev;
	        buckets.remove(curBuc.val);
    	}      
    }
    
    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        return tail.prev == head ? "" : tail.prev.keys.iterator().next();
    }
    
    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        return head.next == tail ? "" : head.next.keys.iterator().next();
    }
}