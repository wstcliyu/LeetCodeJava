import java.util.*;

class Parallel_1136 {
    // Most voted solution: Topological Sort
    public int minimumSemesters(int N, int[][] relations) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] inDegree = new int[N + 1];
        for (int[] r : relations) {
            graph.computeIfAbsent(r[0], k -> new ArrayList<>()).add(r[1]);
            inDegree[r[1]]++;
        }
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= N; i++)
            if (inDegree[i] == 0)
                q.addLast(i);
        int res = 0;
        while (!q.isEmpty()) {
            N -= q.size();
            res++;
            for (int i = q.size(); i > 0; i--) {
                int c = q.removeFirst();
                if (!graph.containsKey(c)) continue;
                for (int course : graph.remove(c))
                    if (--inDegree[course] == 0)
                        q.addLast(course);
            }
        }
        return N == 0 ? res : -1;
    }
}