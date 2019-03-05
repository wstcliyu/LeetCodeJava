import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Iterator;
import javafx.util.Pair;

public class Smallest_632 {
    // My first solution using Priority Queue and Iterator
    // My idea is from Design Twitter (Design_355)
    // It is also similar with merge k sorted list

    // Standard solution is similar with my solution
    // But it keeps the pointers for each row using an array
    // When you need to move the pointer rightwards, just increase the value in this array by one
    // If the value is equal to the end of that row, then break

	int max;
    
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<Pair<Integer, Iterator<Integer>>> minHeap = new PriorityQueue<>(Comparator.comparing((Pair<Integer, Iterator<Integer>> p) -> p.getKey()));
        max = Integer.MIN_VALUE;
        for (List<Integer> ls : nums)
            updateHeap(minHeap, ls.iterator());
        
        int[] res = new int[]{-10_000, max};
        while (!minHeap.isEmpty()) {
            Pair<Integer, Iterator<Integer>> pair = minHeap.poll();

            int[] tmp = new int[]{pair.getKey(), max};
            if (compareRes(tmp, res)) 
            	res = tmp;

            Iterator<Integer> it = pair.getValue();
            if (it.hasNext()) 
            	updateHeap(minHeap, it);
            else 
            	break;
        }
        return res;
    }
    
    private void updateHeap(PriorityQueue<Pair<Integer, Iterator<Integer>>> minHeap, Iterator<Integer> it) {
        int head = it.next();
        max = Math.max(max, head);
        minHeap.add(new Pair<>(head, it));
    }
    
    private boolean compareRes(int[] x, int[] y) {
        return x[1] - x[0] < y[1] - y[0] || x[1] - x[0] == y[1] - y[0] && x[0] < y[0];
    }

}