class Graph_261 {
    // My first solution: Union Find
    private int find(int x, int[] root) {
        if (x == root[x]) return x;
        root[x] = find(root[x], root);
        return root[x];
    }
    
    
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) return false;
        int[] root = new int[n];
        for (int i = 0; i < n; i++) root[i] = i;
        for (int[] e : edges) {
            int x = find(e[0], root);
            int y = find(e[1], root);
            if (x == y) return false;
            root[x] = y;
        }
        return true;
    }
}