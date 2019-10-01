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



    // Standard solution #1: Topological Sort (DFS)
    private boolean isCycle;
    private final int WHITE = 1;
    private final int GRAY = 2;
    private final int BLACK = 3;

    private int[] color;
    private Map<Integer, List<Integer>> adj;
    private List<Integer> topOrder;

    private void init(int numCourses) {
        isCycle = false;
        adj = new HashMap<>();
        topOrder = new ArrayList<>();
        color = new int[numCourses];
        Arrays.fill(color, WHITE);
    }

    private void dfs(int node) {
        if (isCycle) return;
        color[node] = GRAY;
        for (int i : adj.getOrDefault(node, new ArrayList<>())) {
            if (color[i] == WHITE) dfs(i);
            else if (color[i] == GRAY) {
                isCycle = true;
                return;
            }
        }
        color[node] = BLACK;
        topOrder.add(node);
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        init(numCourses);
        for (int[] pair : prerequisites) {
            adj.putIfAbsent(pair[1], new ArrayList<>());
            adj.get(pair[1]).add(pair[0]);
        }
        for (int i = 0; i < numCourses && !isCycle; i++) {
            if (color[i] == WHITE) dfs(i);
        }
        if (isCycle) return new int[0];
        int[] res = new int[numCourses];
        for (int i = 0; i < numCourses; i++)
            res[i] = topOrder.get(numCourses - 1 - i);
        return res;
    }
}
