class Number_323 {
    // My first solution: union find
    class UF {
        private int[] root;
        private int[] weight;
        private int unions;
        
        UF(int n) {
            root = new int[n];
            weight = new int[n];
            for (int i = 0; i < n; i++) {
                root[i] = i;
                weight[i] = 1;
            }
            unions = n;
        }
        
        public int find(int x) {
            if (x != root[x])
                root[x] = find(root[x]);
            return root[x];
        }
        
        public void connect(int x, int y) {
            int rx = find(x);
            int ry = find(y);
            if (rx == ry) return;
            if (weight[rx] < weight[ry]) {
                root[rx] = ry;
                weight[ry] += weight[rx];
            } else {
                root[ry] = rx;
                weight[rx] += weight[ry];
            }
            --unions;
        }
        
        public int getUnions() {
            return unions;
        }
    }
    
    public int countComponents(int n, int[][] edges) {
        UF uf = new UF(n);
        for (int[] e : edges) {
            uf.connect(e[0], e[1]);
        }
        return uf.getUnions();
    }

    public static void main(String[] args) {
        Number_323 test = new Number_323();
        int n = 5;
        int[][] edges = {{0, 1}, {1, 2}, {3, 4}};
        System.out.println(test.countComponents(n, edges));
    }
}