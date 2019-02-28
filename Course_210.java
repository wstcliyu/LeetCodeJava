import java.util.*;

public class Course_210 {
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
