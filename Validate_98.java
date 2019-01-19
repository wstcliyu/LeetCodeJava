public class Validate_98 {
    // My solution using preorder traversal
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    private boolean isValidBST(TreeNode root, Integer min, Integer max) {
        return root == null || (min == null || root.val > min) &&
                (max == null || root.val < max) &&
                isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }


    // My solution using inorder traversal
    /*
    Integer prev;

    public boolean isValidBST(TreeNode root) {
        return inorder(root);
    }

    private boolean inorder(TreeNode root) {
         if (root == null) return true;
         if (!inorder(root.left)) return false;
         if (prev != null && prev >= root.val) return false;
         prev = root.val;
         return inorder(root.right);
    }
    */
}
