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
}
