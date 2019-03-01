public class Maximum_998 {
	public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        if (root.val > val) {
            root.right = insertIntoMaxTree(root.right, val);
            return root;
        }
        TreeNode newRoot = new TreeNode(val);
        newRoot.left = root;
        return newRoot;
    }
}