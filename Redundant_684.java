import java.util.Arrays;

public class Redundant_684 {
    class UnionFind {
        private int[] parent, weight;

        UnionFind(int N) {
            parent = new int[N + 1];
            for (int i = 1; i <= N; i++) parent[i] = i;
            weight = new int[N + 1];
            Arrays.fill(weight, 1);
        }

        int find(int x) {
            if (x != parent[x])
                parent[x] = find(parent[x]);
            return parent[x];
        }

        boolean union(int x, int y) {
            int px = find(x);
            int py = find(y);
            if (px == py) return true;
            if (weight[px] < weight[py]) {
                parent[px] = py;
                weight[py] += weight[px];
            } else {
                parent[py] = px;
                weight[px] += weight[py];
            }
            return false;
        }
    }

    public int[] findRedundantConnection(int[][] edges) {
        // A tree which has N nodes must have N-1 edges
        // Since the problem says there is one redundant edge
        // The number of edges is equal to the number of nodes
        int N = edges.length;
        UnionFind uf = new UnionFind(N);
        for (int[] e : edges) {
            if (uf.union(e[0], e[1]))
                return new int[]{e[0], e[1]};
        }
        return new int[]{0, 0};
    }
}
