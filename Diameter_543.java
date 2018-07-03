import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Diameter_543 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    // Store the max diameter by a global variable
    // Update its value while traversing the tree and calculating the depth of each node
    int res = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return res;
    }
    private int depth(TreeNode root) {
        if (root == null)
            return 0;
        int L = depth(root.left);
        int R = depth(root.right);
        res = Math.max(res, L+R);
        return 1 + Math.max(L, R);
    }
    // My first solution, very slow
    /*
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;
        int sum = depthOfBST(root.left) + depthOfBST(root.right);
        int max = Math.max(diameterOfBinaryTree(root.left), diameterOfBinaryTree(root.right));
        return Math.max(sum, max);
    }

    private static int depthOfBST(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + Math.max(depthOfBST(root.left), depthOfBST(root.right));
    }
    */
    // My second solution (with cache), also slow
    /*
    Map<TreeNode, Integer> map = new HashMap<>();
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;
        int sum = helper(root.left, map) + helper(root.right, map);
        int max = Math.max(diameterOfBinaryTree(root.left), diameterOfBinaryTree(root.right));
        return Math.max(sum, max);
    }

    private static int helper(TreeNode root, Map<TreeNode, Integer> map) {
        if (root == null)
            return 0;
        if (map.containsKey(root))
            return map.get(root);
        int res = 1 + Math.max(helper(root.left, map), helper(root.right, map));
        map.put(root, res);
        return res;
    }
    */
}
