public class Most_947 {
    // Union find
    // My solution inspired by good submission
    public int removeStones(int[][] stones) {
        int[] roots = new int[20000];
        for (int[] stone : stones) {
            int x = stone[0], y = stone[1] + 10000;
            roots[x] = x;
            roots[y] = y;
            // roots[x] = -1;
            // roots[y] = -1;
        }
        for (int[] stone : stones) {
            int x = find(roots, stone[0]);
            int y = find(roots, stone[1] + 10000);
            // Make root of y be the parent of root of x
            if (x != y) roots[x] = y;
        }
        int unions = 0;
        // Only root nodes have value -1
        // for (int root : roots) if (root == -1) unions++;
        for (int i = 10000; i < roots.length; i++) if (roots[i] == i) unions++;
        return stones.length - unions;
    }

    public int find(int[] roots, int x) {
        // Only root nodes have value -1
        // If roots[x] >= 0, it means it is a child node
        // if (roots[x] == -1) return x;
        if (roots[x] == x) return x;
        roots[x] = find(roots, roots[x]);
        return roots[x];
    }


    // My solution inspired by standard solution #1
    // Count the number of connected subsets (Each subset can be removed to only one element)
    // Then it is like Friend Circle
    /*
    public int removeStones(int[][] stones) {
        int N = stones.length;
        boolean[][] connected = new boolean[N][N];
        for (int i = 0; i < N; i++) for (int j = i + 1; j < N; j++)
            if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                connected[i][j] = true;
                connected[j][i] = true;
            }
        boolean[] seen = new boolean[N];
        for (int i = 0; i < stones.length; i++)
            if (!seen[i]) {
                N--;
                dfs(i, seen, connected);
            }
        return N;
    }

    private void dfs(int i, boolean[] seen, boolean[][] connected) {
        seen[i] = true;
        for (int j = 0; j < seen.length; j++)
            if (!seen[j] && connected[i][j]) dfs(j, seen, connected);
    }
    */
}
