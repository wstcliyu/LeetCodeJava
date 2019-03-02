import java.util.Arrays;

public class Redundant_685 {
    class UnionFind {
        private int[] root, weight;

        UnionFind(int N) {
            root = new int[N+1];
            for (int i = 1; i <= N; i++) root[i] = i;
            weight = new int[N+1];
            Arrays.fill(weight, 1);
        }

        int find(int x) {
            if (x != root[x])
                root[x] = find(root[x]);
            return root[x];
        }

        boolean union(int x, int y) {
            int rx = find(x);
            int ry = find(y);
            if (rx == ry) return true;
            if (weight[rx] < weight[ry]) {
                root[rx] = ry;
                weight[ry] += weight[rx];
            } else {
                root[ry] = rx;
                weight[rx] += weight[ry];
            }
            return false;
        }
    }

    public int[] findRedundantDirectedConnection(int[][] edges) {
        // Since the number of edges is equal to the number of nodes, there must be a circle
        int N = edges.length;
        int[] parent = new int[N+1];
        int[] canA = new int[2];
        int[] canB = new int[2];
        // This loop is for checking whether there is a node having two parents
        // If there is such a node, then one of the two edges connecting it to its two parents must be redundant
        // And we keep them in canA and canB (canB occurs later than canA)
        for (int[] e : edges) {
            if (parent[e[1]] != 0) {
                canA = new int[]{parent[e[1]], e[1]};
                canB = Arrays.copyOf(e, 2);
            } else {
                parent[e[1]] = e[0];
            }
        }

        // This loop is for checking whether there is still a circle if we ignore the edge canB
        // If there is not a circle anymore, then return canB
        // If there is still a circle, then we check whether canA/canB has been filled in the first loop
        // If canA/canB has been filled, then return canA
        // If canA/canB has not been filled, then it is the case that every node has exactly one parent,
        // so return the current edge
        UnionFind uf = new UnionFind(N);
        for (int[] e : edges) {
            if (Arrays.equals(e, canB))
                continue;
            if (uf.union(e[0], e[1])) {
                if (canA[0] != 0)
                    return canA;
                else
                    return e;
            }
        }

        return canB;
    }
}
