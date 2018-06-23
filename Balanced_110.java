public class Balanced_110 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public boolean isBalanced(TreeNode root) {
        // Most voted solution #2, time O(n)
        return isBalancedHelper(root) != -1;

        // My first solution, same as most voted solution #1, time O(n^2)
        /*
        if (root == null)
            return true;
        return  isBalanced(root.left) && isBalanced(root.right) && Math.abs(getDepth(root.left) - getDepth(root.right)) < 2;
        */
    }
    private int getDepth(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + Math.max(getDepth(root.left), getDepth(root.right));
    }
    private int isBalancedHelper(TreeNode root) {
        if (root == null)
            return 0;
        int l = isBalancedHelper(root.left);
        int r = isBalancedHelper(root.right);
        if (l == -1 || r == -1 || Math.abs(l-r) > 1)
            return -1;
        return 1 + Math.max(l,r);
    }
}
