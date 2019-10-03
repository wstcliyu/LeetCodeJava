import java.util.*;

class Closest_742 {
    // Standard solution #1: BFS
    private TreeNode start;
    
    public int findClosestLeaf(TreeNode root, int k) {
        Map<TreeNode, TreeNode> parents = new HashMap<>();
        dfs(parents, root, null, k);
        Deque<TreeNode> q = new ArrayDeque<>();
        Set<TreeNode> visited = new HashSet<>();
        q.add(start);
        visited.add(start);
        while (!q.isEmpty()) {
            TreeNode node = q.removeFirst();
            if (node.left == null && node.right == null)
                return node.val;
            if (node.left != null && visited.add(node.left))
                q.add(node.left);
            if (node.right != null && visited.add(node.right))
                q.add(node.right);
            TreeNode parent = parents.get(node);
            if (parent != null && visited.add(parent))
                q.add(parent);
        }
        return -1;
    }
    
    private void dfs(Map<TreeNode, TreeNode> parents, TreeNode node, TreeNode parent, int k) {
        if (node.val == k) start = node;
        parents.put(node, parent);
        if (node.left != null)
            dfs(parents, node.left, node, k);
        if (node.right != null)
            dfs(parents, node.right, node, k);
    }
}