import java.util.*;

public class All_863 {
    // Standard solution #2: DFS
    List<Integer> ans;
    TreeNode target;
    int K;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        ans = new LinkedList();
        this.target = target;
        this.K = K;
        dfs(root);
        return ans;
    }

    // Return vertex distance from node to target if exists, else -1
    // Vertex distance: the number of vertices on the path from node to target
    public int dfs(TreeNode node) {
        if (node == null)
            return -1;
        else if (node == target) {
            subtree_add(node, 0);
            return 1;
        } else {
            int L = dfs(node.left), R = dfs(node.right);
            if (L != -1) {
                if (L == K)
                    ans.add(node.val);
                else if (L < K)
                    subtree_add(node.right, L + 1);
                return L + 1;
            } else if (R != -1) {
                if (R == K)
                    ans.add(node.val);
                else if (R < K)
                    subtree_add(node.left, R + 1);
                return R + 1;
            } else
                return -1;
        }
    }

    // Add all nodes 'K - dist' from the node to res.
    public void subtree_add(TreeNode node, int dist) {
        if (node == null) return;
        if (dist == K)
            ans.add(node.val);
        else {
            subtree_add(node.left, dist + 1);
            subtree_add(node.right, dist + 1);
        }
    }


    // My solution inspired by standard solution #1: BFS
    /*
    Map<TreeNode, TreeNode> parent;

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        parent = new HashMap<>();
        dfs(root, null);
        LinkedList<TreeNode> q = new LinkedList<>();
        q.add(target);
        HashSet<TreeNode> seen = new HashSet<>();
        seen.add(target);
        for (int i = 0; i < K; i++) {
            int len = q.size();
            for (int j = 0; j < len; j++)
                bfs(q.removeFirst(), q, seen);
        }
        ArrayList<Integer> res = new ArrayList<>();
        for (TreeNode node : q)
            res.add(node.val);
        return res;
    }

    private void bfs(TreeNode root, LinkedList<TreeNode> q, HashSet<TreeNode> seen) {
        TreeNode par = parent.get(root);
        if (par != null && seen.add(par)) q.add(par);
        if (root.left != null && seen.add(root.left)) q.add(root.left);
        if (root.right != null && seen.add(root.right)) q.add(root.right);
    }

    private void dfs(TreeNode root, TreeNode par) {
        if (root != null) {
            parent.put(root, par);
            dfs(root.left, root);
            dfs(root.right, root);
        }
    }
    */
}
