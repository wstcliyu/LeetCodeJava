import java.util.PriorityQueue;
import java.util.Comparator;

public class Maximize_1005 {
	// My first solution
	public int largestSumAfterKNegations(int[] A, int K) {
        int sum = 0;
        int min = Integer.MAX_VALUE;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int a : A) {
            sum += a;
            if (a < 0) 
                maxHeap.add(a);
            else 
                min = Math.min(a, min);
            if (maxHeap.size() > K) 
                maxHeap.poll();
        }
        while (K > 0 && !maxHeap.isEmpty()) {
            int x = maxHeap.poll();
            K--;
            sum -= 2 * x;
            min = Math.min(-x, min);
        }
        if (K % 2 == 1)
            sum -= 2 * min;
        return sum;
    }


    // Most voted solution using sort
    /*
    public int largestSumAfterKNegations(int[] A, int K) {
        Arrays.sort(A);
        for (int i = 0; K > 0 && i < A.length && A[i] < 0; ++i, --K)
            A[i] = -A[i];
        int res = 0, min = Integer.MAX_VALUE;
        for (int a : A) {
            res += a;
            min = Math.min(min, a);
        }
        return res - (K % 2) * min * 2;
    }
	*/


    // Second voted solution using Priority Queue
	/*
    public int largestSumAfterKNegations(int[] A, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        
        for(int x: A) pq.add(x);
        while( K--  > 0) pq.add(-pq.poll());
  
        int sum  = 0;
        for(int i = 0; i < A.length; i++){
            sum += pq.poll();
        }
        return sum;
    }
    */
}