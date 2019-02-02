import java.util.PriorityQueue;

public class Kth_703 {
    private PriorityQueue<Integer> heap;
    private int capacity;

    public Kth_703(int k, int[] nums) {
        this.heap = new PriorityQueue<>();
        this.capacity = k;
        for (int num : nums) {
            heap.add(num);
            if (heap.size() > capacity) heap.poll();
        }
    }

    public int add(int val) {
        heap.add(val);
        if (heap.size() > capacity) heap.poll();
        return heap.peek();
    }
}
