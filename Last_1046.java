import java.util.Comparator;
import java.util.PriorityQueue;

class Last_1046 {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int a : stones)
            pq.offer(a);
        for (int i = 0; i < stones.length - 1; ++i)
            pq.offer(pq.poll() - pq.poll());
        return pq.poll();
    }
}