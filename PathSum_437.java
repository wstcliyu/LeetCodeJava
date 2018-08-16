public class PathSum_437 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // Most voted solution
    // Time: O(n^2) in worst case (no branching); O(nlogn) in best case (balanced tree)
    // Space: O(n) due to recursion
    public int pathSum(TreeNode root, int sum) {
        if (root == null)
            return 0;
        return pathSumFrom(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }
    private int pathSumFrom(TreeNode root, int sum) {
        if (root == null)
            return 0;
        int tmp = root.val == sum ? 1 : 0;
        return tmp + pathSumFrom(root.left, sum - root.val) + pathSumFrom(root.right, sum - root.val);
    }
}
