public class Binary_563 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    int tilt = 0;

    public int findTilt(TreeNode root) {
        sum(root);
        return tilt;
    }
    private int sum(TreeNode root) {
        if (root == null)
            return 0;
        int L = sum(root.left), R = sum(root.right);
        tilt += Math.abs(L - R);
        return L + R + root.val;
    }
}
