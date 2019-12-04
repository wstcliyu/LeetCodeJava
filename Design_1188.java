import java.util.concurrent.locks.ReentrantLock; 
import java.util.concurrent.locks.Condition; 

class Design_1188 {
    // Most voted solution
    // https://leetcode.com/problems/design-bounded-blocking-queue/discuss/380140/Java-ReentrantLock-%2B-Condition-Solution
    // https://monkeysayhi.github.io/2017/10/08/Java%E5%AE%9E%E7%8E%B0%E7%94%9F%E4%BA%A7%E8%80%85-%E6%B6%88%E8%B4%B9%E8%80%85%E6%A8%A1%E5%9E%8B/
    // https://blog.csdn.net/ns_code/article/details/17225469
    private ReentrantLock lock = new ReentrantLock();
    private Condition full = lock.newCondition();
    private Condition empty = lock.newCondition();
    private int[] queue;
    private int tail = 0;
    private int head = 0;
    private int size = 0;

    public BoundedBlockingQueue(int capacity) {
        queue = new int[capacity];
    }
    
    public void enqueue(int element) throws InterruptedException {
		lock.lock();
        try {
            while(size == queue.length) {
                full.await();
            }
            queue[tail++] = element;
            tail %= queue.length;
            size++;
            empty.signal();
        } finally {
            lock.unlock();
        }
    }
    
    public int dequeue() throws InterruptedException {
		lock.lock();
        try {
            while(size == 0) {
                empty.await();
            }
            int res = queue[head++];
            head %= queue.length;
            size--;
            full.signal();
            return res;
        } finally {
            lock.unlock();
        }
    }
    
    public int size() throws InterruptedException {
        lock.lock();
		try {
			return this.size;
		} finally {
			lock.unlock();
		}
    }
}