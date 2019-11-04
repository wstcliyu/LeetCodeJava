import java.util.*;

public class Course_210 {
    // Standard solution #2: Topological Sort (BFS)
    /*
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        int[] inDegree = new int[numCourses];
        for (int[] p : prerequisites) {
            adj.computeIfAbsent(p[1], k -> new ArrayList<>()).add(p[0]);
            inDegree[p[0]]++;
        }
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0)
                q.add(i);
        }
        int idx = 0;
        int[] res = new int[numCourses];
        while (!q.isEmpty()) {
            int p = q.removeFirst();
            res[idx++] = p;
            for (int c : adj.getOrDefault(p, new ArrayList<>())) {
                if (--inDegree[c] == 0)
                    q.add(c);
            }
        }
        return idx == numCourses ? res : new int[0];
    }
    */



    // Rewrite standard solution #1: Topological Sort (DFS)
    private static final int WHITE = 0;
    private static final int GREY = 1;
    private static final int BLACK = 2;
    private boolean isCycle;
    private int[] topOrder, color;
    private int idx;
    private Map<Integer, List<Integer>> graph;
    
    private void init(int n, int[][] prerequisites) {
        isCycle = false;
        topOrder = new int[n];
        color = new int[n];
        idx = n - 1;
        graph = new HashMap<>();
        for (int[] p : prerequisites) {
            graph.computeIfAbsent(p[1], k -> new ArrayList<>()).add(p[0]);
        }
    }
    
    private void dfs(int i) {
        if (isCycle) return;
        color[i] = GREY;
        if (graph.containsKey(i)) {
            for (int c : graph.get(i)) {
                if (color[c] == WHITE) {
                    dfs(c);
                } else if (color[c] == GREY) {
                    isCycle = true;
                    return;
                }
            }
        }
        color[i] = BLACK;
        topOrder[idx--] = i;
    }
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        init(numCourses, prerequisites);
        for (int i = 0; !isCycle && i < numCourses; i++)
            if (color[i] == WHITE)
                dfs(i);
        return isCycle ? new int[0] : topOrder;
    }
}
