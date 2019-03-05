public class Design_641 {
	private int size, capacity;
    private int start, end;
    private int[] A;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public Design_641(int k) {
        capacity = k;
        size = 0;
        A = new int[k];

        // Use this trick so that we do not need method insertEmpty(value)
        start = 0;
        end = capacity - 1;
    }


    /*
    private boolean insertEmpty(int value) {
    	start = 0;
        end = 0;
        A[0] = value;
        size++;
        return true;
    }
    */


    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (isFull()) return false;
        // if (isEmpty()) return insertEmpty(value);
        size++;
        start = (start + capacity - 1) % capacity;
        A[start] = value;
        return true;
    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (isFull()) return false;
        // if (isEmpty()) return insertEmpty(value);
        size++;
        end = (end + 1) % capacity;
        A[end] = value;
        return true;
    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (isEmpty()) return false;
        size--;
        start = (start + 1) % capacity;
        return true;
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (isEmpty()) return false;
        size--;
        end = (end + capacity - 1) % capacity;
        return true;
    }
    
    /** Get the front item from the deque. */
    public int getFront() {
        if (isEmpty()) return -1;
        return A[start];
    }
    
    /** Get the last item from the deque. */
    public int getRear() {
        if (isEmpty()) return -1;
        return A[end];
    }
    
    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return size == 0;
    }
    
    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return size == capacity;
    }


    public static void main(String[] args) {
    	Design_641 test = new Design_641(3);
    	test.insertLast(1);
    	test.insertLast(2);
    	test.insertFront(3);
    	System.out.println(test.getRear());
    }
}