import java.util.ArrayList;
import java.util.Arrays;

public class Loud_851 {
    // Cached DFS with postorder traversal
    ArrayList<Integer>[] graph;
    int[] res;
    int[] quiet;

    public int[] loudAndRich(int[][] richer, int[] quiet) {
        this.quiet = quiet;
        int N = quiet.length;
        graph = new ArrayList[N];
        res = new int[N];
        Arrays.fill(res, -1);
        for (int i = 0; i < N; i++) graph[i] = new ArrayList<>();
        for (int[] edge : richer) graph[edge[1]].add(edge[0]);
        for (int i = 0; i < N; i++) dfs(i);
        return res;
    }

    public int dfs(int i) {
        if (res[i] >= 0) return res[i];
        res[i] = i;
        for (int j : graph[i]) if (quiet[res[i]] > quiet[dfs(j)]) res[i] = res[j];
        return res[i];
    }

    public static void main(String[] args) {
        Loud_851 test = new Loud_851();
        int[] quiet = {3,2,5,4,6,1,7,0};
        int[][] richer = {{1, 0}, {2, 1}, {3, 1}, {3, 7}, {4, 3}, {5, 3}, {6, 3}};
        int[] ans = test.loudAndRich(richer, quiet);
        System.out.println(Arrays.toString(ans));
    }

    // My solution TLE (71/86 test cases passed)
    /*
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int N = quiet.length;
        boolean[][] comp = new boolean[N][N];
        for (int[] pair : richer) dfs(comp, pair[0], pair[1]);
        int[] res = new int[N];
        for (int i = 0; i < N; i++) {
            int cur = i;
            int quietest = quiet[i];
            res[i] = i;
            for (int j = 0; j < N; j++) {
                if (comp[j][cur] && quiet[j] < quietest) {
                    quietest = quiet[j];
                    res[i] = j;
                }
            }
        }
        return res;
    }

    private void dfs(boolean[][] comp, int higher, int lower) {
        comp[higher][lower]  = true;
        for (int i = 0; i < comp[lower].length; i++)
            if (comp[lower][i]) dfs(comp, higher, i);
        for (int i = 0; i < comp.length; i++)
            if (comp[i][higher]) dfs(comp, i, lower);
    }
    */
}
