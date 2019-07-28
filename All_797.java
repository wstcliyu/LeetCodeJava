import java.util.*;

class All_797 {
    // My solution: DFS/Backtrack
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        backtrack(res, path, 0, n - 1, graph);
        return res;
    }
    
    private void backtrack(List<List<Integer>> res, List<Integer> path, int start, int end, int[][] graph) {
        if (start == end) {
            res.add(new ArrayList<>(path));
        } else {
            for (int neighbor : graph[start]) {
                path.add(neighbor);
                backtrack(res, path, neighbor, end, graph);
                path.remove(path.size() - 1);
            }
        }
    }



    // My solution: BFS
    /*
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        path.add(0);
        Deque<LinkedList<Integer>> q = new ArrayDeque<>();
        q.add(path);
        while (!q.isEmpty()) {
            LinkedList<Integer> ls = q.removeFirst();
            if (ls.getLast() == n - 1) {
                res.add(ls);
            } else {
                for (int neighbor : graph[ls.getLast()]) {
                    ls.add(neighbor);
                    q.add(new LinkedList<>(ls));
                    ls.removeLast();
                }
            }
        }
        return res;
    }
    */



    // Standard solution: Recursion
    /*
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        return solve(graph, 0);
    }

    public List<List<Integer>> solve(int[][] graph, int node) {
        int N = graph.length;
        List<List<Integer>> ans = new ArrayList();
        if (node == N - 1) {
            List<Integer> path = new ArrayList();
            path.add(N-1);
            ans.add(path);
            return ans;
        }

        for (int nei: graph[node]) {
            for (List<Integer> path: solve(graph, nei)) {
                path.add(0, node);
                ans.add(path);
            }
        }
        return ans;
    }
    */
}