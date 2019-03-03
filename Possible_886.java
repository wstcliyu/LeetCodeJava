import java.util.*;

public class Possible_886 {
    // Standard solution
    // Store the graph using adjacent lists and dfs
    // Time: O(V+E), Space: O(V+E)
    // where V is the number of people (V == N), E is the number of edges (E == dislikes.length)

    List<List<Integer>> graph;
    int[] group;

    public boolean possibleBipartition(int N, int[][] dislikes) {
        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());
        for (int[] e : dislikes) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }

        group = new int[N+1];
        for (int i = 1; i <= N; i++) {
            if (group[i] == 0 && !dfs(i, 1)) return false;
        }
        return true;
    }

    private boolean dfs(int i, int g) {
        if (group[i] != 0) return g == group[i];
        group[i] = g;
        for (int hate : graph.get(i)) {
            if (!dfs(hate, 3-g)) return false;
        }
        return true;
    }

    // My first solution (TLE)
    /*
    public boolean possibleBipartition(int N, int[][] dislikes) {
        return dfs(0, dislikes, new int[N+1]);
    }

    private boolean dfs(int i, int[][] dislikes, int[] group) {
        if (i == dislikes.length) return true;
        int p1 = dislikes[i][0], p2 = dislikes[i][1];
        if (group[p1] == 1 && group[p2] == 1 || group[p1] == 2 && group[p2] == 2) return false;
        int g1 = group[p1], g2 = group[p2];
        boolean res = false;
        if (g1 != 0) {
            group[p2] = 3 - g1;
            res = dfs(i+1, dislikes, group);
            group[p2] = g2;
            return res;
        }

        if (g2 != 0) {
            group[p1] = 3 - g2;
            res = dfs(i+1, dislikes, group);
            group[p1] = g1;
            return res;
        }

        group[p1] = 1;
        group[p2] = 2;
        boolean res1 = dfs(i+1, dislikes, group);

        group[p1] = 2;
        group[p2] = 1;
        boolean res2 = dfs(i+1, dislikes, group);

        group[p1] = g1;
        group[p2] = g2;
        return res1 || res2;
    }
    */

    public static void main(String[] args) {
        Possible_886 test = new Possible_886();
        int[][] dislikes = {{1, 2}, {1, 3}, {2, 3}};
        System.out.println(test.possibleBipartition(3, dislikes));
    }
}
