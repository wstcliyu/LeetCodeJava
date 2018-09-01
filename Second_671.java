public class Second_671 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // Standard Solution Approach #2
    // When traversing the tree at some node, if node.val > min,
    // we know all values in the subtree of node are at least node.val,
    // so there cannot be a better candidate for the second minimum in this subtree.
    // Thus, we do not need to search this subtree.

    int min;
    int res = Integer.MAX_VALUE;

    public int findSecondMinimumValue(TreeNode root) {
        min = root.val;
        dfs(root);
        return res == Integer.MAX_VALUE ? -1 : res;
    }
    private void dfs(TreeNode root) {
        if (root != null) {
            if (root.val > min)
                res = Math.min(res, root.val);
            else {
                dfs(root.left);
                dfs(root.right);
            }
        }
    }


    // Most voted solution using divide and conquer
    /*
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null)
            return -1;
        if (root.left == null && root.right == null)
            return -1;
        int left = root.left.val > root.val ? root.left.val : findSecondMinimumValue(root.left);
        int right = root.right.val > root.val ? root.right.val : findSecondMinimumValue(root.right);
        if (left != -1 && right != -1)
            return Math.min(left, right);
        else if (left != -1)
            return left;
        else
            return right;
    }
    */
}
