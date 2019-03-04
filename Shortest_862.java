import java.awt.Point;

public class Shortest_862 {
	// My solution using array instead of deque
	// Of course this problem can also be solved using deque
	public int shortestSubarray(int[] A, int K) {
        Point[] q = new Point[A.length+1];
        q[0] = new Point(0, -1);
        int start = 0, end = 1, sum = 0, res = Integer.MAX_VALUE;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];

            // It is important that we can remove from the start
            // If some prefix sum is valid, then it cannot be optimal in the future.
            // So just remove them. This can reduce our search time in the future.
            while (end > start && q[start].x <= sum - K) 
                res = Math.min(res, i - q[start++].y);

            while (end > start && q[end-1].x >= sum) 
                end--;

            // This problem requires that K >= 1
            // If K <= 0, then the two while loops above will 
            // remove all the records in the queue every round 
            
            q[end++] = new Point(sum, i);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }



    // Standard solution using deque
    /* 
    public int shortestSubarray(int[] A, int K) {
        int N = A.length;
        long[] P = new long[N+1];
        for (int i = 0; i < N; ++i)
            P[i+1] = P[i] + (long) A[i];

        // Want smallest y-x with P[y] - P[x] >= K
        int ans = N+1; // N+1 is impossible
        Deque<Integer> monoq = new LinkedList(); // indices of P

        for (int y = 0; y < P.length; ++y) {
            while (!monoq.isEmpty() && P[y] <= P[monoq.getLast()])
                monoq.removeLast();
            while (!monoq.isEmpty() && P[y] >= P[monoq.getFirst()] + K)
                ans = Math.min(ans, y - monoq.removeFirst());

            monoq.addLast(y);
        }

        return ans < N+1 ? ans : -1;
    }
    */
}