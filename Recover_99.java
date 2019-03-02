public class Recover_99 {
    // For example: 6, 3, 4, 5, 2
    // Inverse pairs with adjacent elements are (6,3) and (5,2)
    // So, first = 6, second = 2

    // For example: 1, 3, 2, 4
    // Only one inverse pair with adjacent elements (3, 2)
    // So, first = 3, second = 2

    private TreeNode first, second, prev;

    public void recoverTree(TreeNode root) {
        inorder(root);
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }

    private void inorder(TreeNode node) {
        if (node == null) return;
        inorder(node.left);
        if (prev != null && prev.val > node.val) {
            if (first == null) first = prev;
            second = node;
        }
        prev = node;
        inorder(node.right);
    }
}
