public class Kth_230 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // Inroder traversal
    /*
    int count = 0, res = 0;

    public int kthSmallest(TreeNode root, int k) {
        count = k;
        inorder(root);
        return res;
    }

    private void inorder(TreeNode root) {
        if (root == null || count < 0)
            return;
        inorder(root.left);
        if (--count == 0) {
            res = root.val;
            return;
        }
        inorder(root.right);
    }
    */


    // Binary Search
    public int kthSmallest(TreeNode root, int k) {
        int count = countNodes(root.left);
        if (k <= count)
            return kthSmallest(root.left, k);
        else if (k > count + 1)
            return kthSmallest(root.right, k-1-count);
        return root.val;
    }

    public int countNodes(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
