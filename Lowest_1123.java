import javafx.util.Pair;

// Most voted solution from lee215
// https://leetcode.com/problems/lowest-common-ancestor-of-deepest-leaves/discuss/334577/JavaC%2B%2BPython-Two-Recursive-Solution

class Lowest_1123 {
    // Most voted solution #1
    // Time: O(N), Space: O(H)
    // helper function return the tree height and lca at the same time
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        return helper(root, 0).getKey();
    }
    
    private Pair<TreeNode, Integer> helper(TreeNode root, int depth) {
        if (root == null) return new Pair<>(null, depth);
        Pair<TreeNode, Integer> l = helper(root.left, depth + 1);
        Pair<TreeNode, Integer> r = helper(root.right, depth + 1);
        if (l.getValue() == r.getValue()) return new Pair<>(root, l.getValue());
        return l.getValue() > r.getValue() ? l : r;
    }



    // Most voted solution #2
    // Time: O(N), Space: O(H)
    // helper function return the deepest depth of descendants.
    // deepest represent the deepest depth.
    // We use a global variable lca to represent the result.
    /*
    private int deepest;
    private TreeNode lca;
    
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        helper(root, 0);
        return lca;
    }
    
    private int helper(TreeNode root, int depth) {
        deepest = Math.max(deepest, depth);
        if (root == null) return depth;
        int l = helper(root.left, depth + 1);
        int r = helper(root.right, depth + 1);
        if (l == deepest && r == deepest) lca = root;
        return l > r ? l : r;
    }
    */
}