import java.util.*;

class Optimize_1168 {
    // My first solution: Union Find
    // Same as most voted solution from lee215
    /*  
    I take it this way:
    We cannot build any well.
    There is one and only one hidding well in my house (house 0).
    The cost to lay pipe between house[i] and my house is wells[i]
    */
    class UnionFind {
        int[] root;
        int size;
        UnionFind(int n) {
            root = new int[n + 1];
            size = 0;
            for (int i = 1; i <= n; i++) {
                root[i] = i;
            }
        }
        
        int find(int x) {
            if (root[x] != x) {
                root[x] = find(root[x]);
            }
            return root[x];
        }
        
        boolean union(int x, int y) {
            int rx = find(x);
            int ry = find(y);
            if (rx != ry) {
                root[rx] = ry;
                size++;
                return true;
            }
            return false;
        }
    }
    
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing((int[] a) -> a[2]));
        for (int i = 0; i < wells.length; i++) {
            pq.add(new int[]{i + 1, 0, wells[i]});
        }
        for (int[] p : pipes) {
            pq.add(p);
        }
        UnionFind uf = new UnionFind(n);
        int res = 0;
        while (uf.size < n && !pq.isEmpty()) {
            int[] p = pq.poll();
            if (uf.union(p[0], p[1])) {
                res += p[2];
            }
        }
        return res;
    }
}