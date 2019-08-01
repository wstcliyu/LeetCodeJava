import java.util.Arrays;
import java.util.Comparator;

class The_1101 {
    // My first solution using Union Find
    private int[] root, weight;
    private int groups;
    
    private int find(int x) {
        if (x == root[x]) return x;
        root[x] = find(root[x]);
        return root[x];
    }
    
    private void connect(int x, int y) {
        int X = find(x);
        int Y = find(y);
        if (X == Y) return;
        groups--;
        if (weight[X] < weight[Y]) {
            root[X] = Y;
            weight[Y] += weight[X];
        } else {
            root[Y] = X;
            weight[X] += weight[Y];
        }
    }
    
    public int earliestAcq(int[][] logs, int N) {
        root = new int[N];
        for (int i = 0; i < N; i++) root[i] = i;
        weight = new int[N];
        Arrays.fill(weight, 1);
        groups = N;
        Arrays.sort(logs, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        for (int[] log : logs) {
            connect(log[1], log[2]);
            if (groups == 1) return log[0];
        }
        return -1;
    }
}