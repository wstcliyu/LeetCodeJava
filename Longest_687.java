public class Longest_687 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // Most voted solution
    // https://leetcode.com/problems/longest-univalue-path/discuss/108175/java-solution-with-global-variable

    int len = 0;

    public int longestUnivaluePath(TreeNode root) {
        if (root == null)
            return 0;
        genLen(root, root.val);
        return len;
    }

    // genLen(node, val) denotes the number of nodes of longest path ending in "node"
    // with the same value "val"
    private int genLen(TreeNode node, int val) {
        if (node == null)
            return 0;
        int left = genLen(node.left, node.val);
        int right = genLen(node.right, node.val);
        len = Math.max(len, left + right);
        if (node.val == val)
            return Math.max(left, right) + 1;
        return 0;
    }

    // My solution (I think it is easier to understand)
    /*
    int res = 0; 

    public int longestUnivaluePath(TreeNode root) {
        getUniDepth(root);
        return res;
    }

    private int getUniDepth(TreeNode root) {
        if (root == null) return 0;

        // int left = (root.left != null && root.left.val == root.val) ? 1 + getUniDepth(root.left) : 0;
        // We cannot use the above code because we must execute getUniDepth(root.left) in any case
        // Otherwise, we cannot traverse the whole tree and we will get wrong answer

        int left = 1 + getUniDepth(root.left);
        int right = 1 + getUniDepth(root.right);
        if (root.left == null || root.left.val != root.val) left = 0;
        if (root.right == null || root.right.val != root.val) right = 0;
        res = Math.max(res, left + right);
        return Math.max(left, right);   
    }
    */
}
