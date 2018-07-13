public class Lowest_235 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while((root.val-p.val) * (root.val-q.val) > 0)
            root = root.val<p.val ? root.right : root.left;
        return root;
    }
}
