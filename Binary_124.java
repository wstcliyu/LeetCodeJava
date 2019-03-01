public class Binary_124 {
    // My first solution (same as the most voted solution)
    int res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        helper(root);
        return res;
    }

    private int helper(TreeNode node) {
        if (node == null) return 0;
        int l = Math.max(0, helper(node.left));
        int r = Math.max(0, helper(node.right));
        int pathSum = node.val + l + r;
        res = Math.max(res, pathSum);
        return node.val + Math.max(l, r);
    }
}
