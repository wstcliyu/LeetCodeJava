import java.util.ArrayList;
import java.util.List;

public class Flip_951 {
    // Standard Solution Approach #1: Recursion
    // Time: O(min(N1, N2)), where N1,N2 are the lengths of root1 and root2
    // Space: O(min(H1, H2)), where H1,H2 are the heights of root1 and root2
    /*
    public boolean flipEquiv(TreeNode r1, TreeNode r2) {
        if (r1 == null || r2 == null) return r1 == r2;
        if (r1.val != r2.val) return false;
        return flipEquiv(r1.left, r2.left) && flipEquiv(r1.right, r2.right) || flipEquiv(r1.left, r2.right) && flipEquiv(r1.right, r2.left);
    }
    */


    // Standard Solution Approach #2: Canonical Representation
    // Time: O(N1 + N2), Space: O(N1 + N2)
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        List<Integer> vals1 = new ArrayList();
        List<Integer> vals2 = new ArrayList();
        dfs(root1, vals1);
        dfs(root2, vals2);
        return vals1.equals(vals2);
    }

    public void dfs(TreeNode node, List<Integer> vals) {
        if (node != null) {
            vals.add(node.val);
            int L = node.left != null ? node.left.val : -1;
            int R = node.right != null ? node.right.val : -1;

            if (L < R) {
                dfs(node.left, vals);
                dfs(node.right, vals);
            } else {
                dfs(node.right, vals);
                dfs(node.left, vals);
            }

            vals.add(null);
        }
    }
}
