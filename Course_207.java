import java.util.*;

class Course_207 {
    // My first solution: Topological Sort (BFS) to detect cycle
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        int[] inDegree = new int[numCourses];
        for (int[] p : prerequisites) {
            adj.computeIfAbsent(p[1], k -> new ArrayList<>()).add(p[0]);
            inDegree[p[0]]++;
        }
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++)
            if (inDegree[i] == 0)
                q.add(i);
        int res = 0;
        while (!q.isEmpty()) {
            int p = q.removeFirst();
            res++;
            for (int c : adj.getOrDefault(p, new ArrayList<>())) {
                if (--inDegree[c] == 0) q.add(c);
            }
        }
        return res == numCourses;
    }



    // Rewrite Course_210: Topological Sort (DFS) to detect cycle
    /*
    private Map<Integer, List<Integer>> adj;
    private int[] color;
    private boolean isCycle;
    private static final int WHITE = 1;
    private static final int GRAY = 2;
    private static final int BLACK = 3;
    
    private void init(int numCourses, int[][] prerequisites) {
        adj = new HashMap<>();
        for (int[] p : prerequisites) {
            adj.computeIfAbsent(p[1], k -> new ArrayList<>()).add(p[0]);
        }
        color = new int[numCourses];
        Arrays.fill(color, WHITE);
        isCycle = false;
    }
    
    private void dfs(int i) {
        if (isCycle) return;
        color[i] = GRAY;
        for (int c : adj.getOrDefault(i, new ArrayList<>())) {
            if (color[c] == WHITE) {
                dfs(c);
            } else if (color[c] == GRAY) {
                isCycle = true;
                return;
            }
        }
        color[i] = BLACK;
    }
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        init(numCourses, prerequisites);
        for (int i = 0; i < numCourses && !isCycle; i++) {
            if (color[i] == WHITE) dfs(i);
        }
        return !isCycle;
    }
    */



    // DFS to detect cycle (not very good solution)
    /*
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        boolean[] visited = new boolean[numCourses];
        for (int[] p : prerequisites) {
            adj.computeIfAbsent(p[1], k -> new ArrayList<>()).add(p[0]);
        }

        for (int i = 0; i < numCourses; i++)
            if (!dfs(i, adj, visited))
                return false;
        return true;
    }

    private boolean dfs(int course, Map<Integer, List<Integer>> adj, boolean[] visited) {
        if (visited[course]) return false;
        visited[course] = true;
        for (int c : adj.getOrDefault(course, new ArrayList<>())) {
            if (!dfs(c, adj, visited)) return false;
        }
        visited[course] = false;
        return true;
    }
    */
}