public class Distribute_979 {
    // This problem uses postorder traversal
    // Post traversal starts from leaf

    // Most voted solution #1: With global variable
    int res = 0;

    public int distributeCoins(TreeNode root) {
        dfs(root);
        return res;
    }

    // dfs(root) returns the coins minus number of nodes
    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int L = dfs(root.left), R = dfs(root.right);
        res += Math.abs(L) + Math.abs(R);
        return root.val + L + R - 1;
    }


    // Most voted solution #2: Without global variable
    // This method needs to modify original node value
    /*
    public int distributeCoins(TreeNode root) {
        int res = 0;
        if (root.left != null) {
            res += distributeCoins(root.left);
            res += Math.abs(root.left.val - 1);
            root.val += root.left.val - 1;
        }
        if (root.right != null) {
            res += distributeCoins(root.right);
            res += Math.abs(root.right.val - 1);
            root.val += root.right.val - 1;
        }
        return res;
    }
    */


    // Most voted solution #3: Keep track of parent node and
    // modify the original node value of parent
    /*
    public int distributeCoins(TreeNode root) {
        return distributeCoins(root, null);
    }

    private int distributeCoins(TreeNode root, TreeNode parent) {
        if (root == null) return 0;
        int res = distributeCoins(root.left, root) + distributeCoins(root.right, root);
        if (parent != null) parent.val += root.val - 1;
        return res + Math.abs(root.val - 1);
    }
    */
}
