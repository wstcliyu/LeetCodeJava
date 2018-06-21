public class Symmetric_101 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return isMirrorPair(root.left, root.right);
    }
    private boolean isMirrorPair(TreeNode n1, TreeNode n2) {
        if (n1 == null && n2 == null)
            return true;
        if (n1 != null && n2 == null)
            return false;
        if (n1 == null)
            return false;
        if (n1.val != n2.val)
            return false;
        return isMirrorPair(n1.left, n2.right) && isMirrorPair(n1.right, n2.left);
    }
}
