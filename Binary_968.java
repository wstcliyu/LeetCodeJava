import java.util.HashSet;
import java.util.Set;

public class Binary_968 {

    // Standard solution #1: DP
    public int minCameraCover(TreeNode root) {
        int[] ans = solve(root);
        return Math.min(ans[1], ans[2]);
    }

    // 0: Strict ST; All nodes below this are covered, but not this one
    // 1: Normal ST; All nodes below and incl this are covered - no camera
    // 2: Placed camera; All nodes below this are covered, plus camera here
    // To cover a strict subtree, the children of this node must be in state 1.
    // To cover a normal subtree without placing a camera here, the children of this node must be in states 1 or 2, and at least one of those children must be in state 2.
    // To cover the subtree when placing a camera here, the children can be in any state
    public int[] solve(TreeNode node) {
        if (node == null) return new int[]{0, 0, 1000};

        int[] L = solve(node.left);
        int[] R = solve(node.right);
        int mL12 = Math.min(L[1], L[2]);
        int mR12 = Math.min(R[1], R[2]);

        int d0 = L[1] + R[1];
        int d1 = Math.min(L[2] + mR12, R[2] + mL12);
        int d2 = 1 + Math.min(L[0], mL12) + Math.min(R[0], mR12);
        return new int[]{d0, d1, d2};
    }


    // Standard solution #2: Greedy
    // Bottom-up (postorder traversal)
    /*
    int ans;
    Set<TreeNode> covered;
    public int minCameraCover(TreeNode root) {
        ans = 0;
        covered = new HashSet<>();
        covered.add(null);

        dfs(root, null);
        return ans;
    }

    public void dfs(TreeNode node, TreeNode par) {
        if (node != null) {
            dfs(node.left, node);
            dfs(node.right, node);

            if (par == null && !covered.contains(node) ||
                    !covered.contains(node.left) ||
                    !covered.contains(node.right)) {
                ans++;
                covered.add(node);
                covered.add(par);
                covered.add(node.left);
                covered.add(node.right);
            }
        }
    }
    */


    // Most voted solution: Greedy
    // https://leetcode.com/problems/binary-tree-cameras/discuss/211180/JavaC%2B%2BPython-Greedy-DFS
    // If we set a camera at the leaf, the camera can cover the leaf and its parent.
    // If we set a camera at its parent, the camera can cover the leaf, its parent and its sibling.
    // We can see that the second plan is always better than the first.
    // 1. Set cameras on all leaves' parents, then remove all covered nodes.
    // 2. Repeat step 1 until all nodes are covered.
    /*
    Apply a recursion function dfs.
    Return 0 if it's a leaf. (Node with both of its children returning 2 can be seen as leaf)
    Return 1 if it's a parent of a leaf, with a camera on this node.
    Return 2 if it's covered by its children, without a camera on this node. (TreeNode null also belongs to this state)

    For each node,
    if it has a child, which is leaf (node 0), then it needs camera.
    if it has a child, which is the parent of a leaf (node 1), then it's covered.

    If it needs camera, then res++ and we return 1.
    If it's covered, we return 2.
    Otherwise, we return 0.
     */

    /*
    int res = 0;
    public int minCameraCover(TreeNode root) {
        return (dfs(root) < 1 ? 1 : 0) + res;
    }

    public int dfs(TreeNode root) {
        if (root == null) return 2;
        int left = dfs(root.left), right = dfs(root.right);
        if (left == 0 || right == 0) {
            res++;
            return 1;
        }
        return left == 1 || right == 1 ? 2 : 0;
    }
    */
}
