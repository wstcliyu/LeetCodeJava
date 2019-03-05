public class Design_622 {
	private int size, capacity;
    private int start, end;
    private int[] A;

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public Design_622(int k) {
        size = 0;
        capacity = k;
        A = new int[k];
        
        start = 0;
        end = k - 1;
    }
    
    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if (isFull()) return false;
        size++;
        end = (end + 1) % capacity;
        A[end] = value;
        return true;
    }
    
    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if (isEmpty()) return false;
        size--;
        start = (start + 1) % capacity;
        return true;
    }
    
    /** Get the front item from the queue. */
    public int Front() {
        if (isEmpty()) return -1;
        return A[start];
    }
    
    /** Get the last item from the queue. */
    public int Rear() {
        if (isEmpty()) return -1;
        return A[end];
    }
    
    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return size == 0;
    }
    
    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return size == capacity;
    }
}