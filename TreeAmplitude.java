public class TreeAmplitude {

    // Amazon OA 2: Tree Amplitude
    // Given a tree of N nodes, return the amplitude of the tree
    // Amplitude is the max - min from root to leaf
    public int Solution(TreeNode root) {
        if (root == null)   return 0;
        return helper(root, root.val, root.val);
    }

    private int helper(TreeNode root, int min, int max) {
        if (root == null)   return max - min;

        if (root.val < min) min = root.val;
        if (root.val > max) max = root.val;

        return Math.max(helper(root.left, min, max), helper(root.right, min, max));
    }
}
