public class Find_295 {
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;

    /** initialize your data structure here. */
    public Find_295() {
        maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        minHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        maxHeap.add(num);
        minHeap.add(maxHeap.poll());
        if (maxHeap.size() < minHeap.size())
            maxHeap.add(minHeap.poll());
    }
    
    public double findMedian() {
        return maxHeap.size() > minHeap.size() ? maxHeap.peek() : 0.5 * (maxHeap.peek() + minHeap.peek());
    }
}