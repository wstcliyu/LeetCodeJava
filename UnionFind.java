public class UnionFind {
    // Weighted Quick Union With Path Compression

    private int[] parent;
    private int[] size;
    private int count;

    // O(N)
    public UnionFind(int N) {
        parent = new int[N];
        size = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = i;
            size[i] = 1;
            count++;
        }
    }

    // O(lg* N)
    // lg* 65535  = 4, lg* 2^65536 = 5
    public int find(int x) {
        if (x == parent[x]) return x;
        parent[x] = find(parent[x]);
        return parent[x];
    }

    // O(lg* N)
    public boolean isConnected(int x, int y) {
        return find(x) == find(y);
    }

    // O(lg* N)
    public void union(int x, int y) {
        int i = find(x);
        int j = find(y);
        if (i == j) return;
        count--;
        if (size[i] < size[j]) {
            parent[i] = j;
            size[j] += size[i];
        } else {
            parent[j] = i;
            size[i] += size[j];
        }
    }

    public int getCount() {
        return count;
    }
}
