import java.util.*;

class Kill_582 {
    // My solution: HashMap + DFS (Standard solution #3)
    /*
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        HashMap<Integer, List<Integer>> tree = new HashMap<>();
        for (int i = 0; i < ppid.size(); i++) {
            if (ppid.get(i) > 0) {
                tree.computeIfAbsent(ppid.get(i), k -> new ArrayList<>()).add(pid.get(i));
            }
        }
        List<Integer> res = new ArrayList<>();
        dfs(kill, res, tree);
        return res;
    }
    
    private void dfs(int kill, List<Integer> res, HashMap<Integer, List<Integer>> tree) {
        res.add(kill);
        if (tree.containsKey(kill)) {
            for (int child : tree.get(kill)) {
                dfs(child, res, tree);
            }
        }
    }
    */



    // Rewrite good submission: Union Find
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        int N = 0;
        for (int i = 0; i < pid.size(); i++) {
            N = Math.max(N, Math.max(pid.get(i), ppid.get(i)));
        }
        int[] root = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            root[i] = i;
        }

        for (int i = 0; i < pid.size(); i++) {
            if (pid.get(i) == kill) continue;
            int root1 = find(pid.get(i), root);
            int root2 = find(ppid.get(i), root);
            root[root1] = root2;
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            if (find(i, root) == kill) {
                res.add(i);
            }
        }
        return res;
    }

    private int find(int x, int[] root) {
        if (x != root[x]) {
            root[x] = find(root[x], root);
        }
        return root[x];
    }
}