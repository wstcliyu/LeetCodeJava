import java.util.Arrays;
import java.util.LinkedList;

public class Perfect_279 {
    // DFS
    // Time: O(n * sqrt(n))
    /*
    public int numSquares(int n) {
        int[] res = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            res[i] = i;
            for (int j = 1; j * j <= i; j++)
                res[i] = Math.min(res[i], 1 + res[i - j * j]);
        }
        return res[n];
    }
    */
    // BFS
    // Time: O(n * sqrt(n)), but faster than DFS
    public int numSquares(int n) {
        int[] res = new int[n + 1];
        Arrays.fill(res, n);
        res[0] = 0; // Must not ignore set res[0] == 0
        LinkedList<Integer> q = new LinkedList<>();
        q.add(0);
        while (!q.isEmpty()) {
            int s = q.poll();
            for (int i = 1; s + i * i <= n; i++) {
                int t = s + i * i;
                if (res[t] > 1 + res[s]) {
                    res[t] = 1 + res[s];
                    q.add(t);
                }
                if (t == n)
                    return res[n];
            }
        }
        return res[n];
    }
}
