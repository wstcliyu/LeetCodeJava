import java.util.*;

class Campus_1066 {
    // My first solution: backtrack (brutal force)
    // Time: O(M**N), M = bikes.length, N = workers.length
    // Space: O(M)
    /*
    private int res;
    
    public int assignBikes(int[][] workers, int[][] bikes) {
        res = Integer.MAX_VALUE;
        backtrack(workers, bikes, 0, new boolean[bikes.length], 0);
        return res;
    }
    
    private int distance(int[] w, int[] b) {
        return Math.abs(w[0] - b[0]) + Math.abs(w[1] - b[1]);
    }
    
    private void backtrack(int[][] workers, int[][] bikes, int idx, boolean[] bikesUsed, int sum) {
        if (idx == workers.length) {
            res = Math.min(res, sum);
            return;
        }

        if (sum >= res) return; // pruning
        
        for (int j = 0; j < bikes.length; j++) {
            if (bikesUsed[j]) continue;
            bikesUsed[j] = true;
            backtrack(workers, bikes, idx + 1, bikesUsed, sum + distance(workers[idx], bikes[j]));
            bikesUsed[j] = false;
        }
    }
    */



    // Rewrite most voted solution using DP
    // Time: O(M N 2**M), Space: O(N 2**M)
    /*
    public int assignBikes(int[][] workers, int[][] bikes) {
        int res = Integer.MAX_VALUE;
        int N = workers.length;
        int M = bikes.length;
        int[][] dp = new int[N + 1][1 << M];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i + 1], Integer.MAX_VALUE);
            for (int s = 0; s < 1 << (i == 0 ? 0 : M); s++) {
                if (dp[i][s] < Integer.MAX_VALUE) {
                    for (int j = 0; j < M; j++) {
                        if ((s & (1 << j)) != 0) continue;
                        int ns = s | (1 << j);
                        dp[i + 1][ns] = Math.min(dp[i + 1][ns], dp[i][s] + distance(workers[i], bikes[j]));
                    }
                }
            }
        }
        for (int v : dp[N]) res = Math.min(res, v);
        return res;
    }

    
    private int distance(int[] w, int[] b) {
        return Math.abs(w[0] - b[0]) + Math.abs(w[1] - b[1]);
    }
    */



    // Rewrite second voted solution from lee215: Priority Queue (I think it is like BFS)
    class Tuple implements Comparable<Tuple> {
        int dist, idx, state;

        Tuple(int _dist, int _idx, int _state) {
            dist = _dist;
            idx = _idx;
            state = _state;
        }

        @Override
        public int compareTo(Tuple that) {
            return this.dist - that.dist;
        }

        @Override
        public int hashCode() {
            int res = 17;
            res = res * 31 + Integer.hashCode(idx);
            res = res * 31 + Integer.hashCode(state);
            return res;
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Tuple)) return false;
            if (o == this) return true;
            Tuple t = (Tuple)o;
            return this.idx == t.idx && this.state == t.state;
        }
    }
    
    private int distance(int[] w, int[] b) {
        return Math.abs(w[0] - b[0]) + Math.abs(w[1] - b[1]);
    }

    public int assignBikes(int[][] workers, int[][] bikes) {
        PriorityQueue<Tuple> pq = new PriorityQueue<>();
        Set<Tuple> seen = new HashSet<>();
        pq.add(new Tuple(0, 0, 0));
        int res = 0;
        while (true) {
            Tuple tuple = pq.poll();
            if (seen.contains(tuple)) continue;
            seen.add(tuple);
            if (tuple.idx == workers.length) return tuple.dist;
            for (int j = 0; j < bikes.length; j++) {
                if ((tuple.state & (1 << j)) == 0)
                    pq.add(new Tuple(tuple.dist + distance(workers[tuple.idx], bikes[j]), 1 + tuple.idx, tuple.state | (1 << j)));
        }
    }
}