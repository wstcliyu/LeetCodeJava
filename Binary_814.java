public class Binary_814 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // Refer to the standard solution and discuss and the replies under them.
    public TreeNode pruneTree(TreeNode root) {
        if (root == null)
            return root;
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        if (root.val == 0 && root.left == null && root.right == null)
            return null;
        return root;
    }
}
