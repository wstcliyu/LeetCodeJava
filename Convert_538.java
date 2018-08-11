import java.util.ArrayDeque;

public class Convert_538 {
    public class TreeNode {
        int val;
        TreeNode left;
         TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // https://leetcode.com/problems/convert-bst-to-greater-tree/solution/

    // Standard Solution Approach #1 Recursion
    // Inorder traversal
    /*
    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root == null)
            return root;
        convertBST(root.right);
        sum += root.val;
        root.val = sum;
        convertBST(root.left);
        return root;
    }
    */


    // Standard Solution Approach #2 Iteration with a stack
    // Similar with my annotation for inorder traversal in Binary_145
    public TreeNode convertBST(TreeNode root) {
        if (root == null)
            return root;
        int sum = 0;
        ArrayDeque<TreeNode> st = new ArrayDeque<>();
        TreeNode q = root;
        while (!st.isEmpty() || q != null) {
            if (q != null) {
                st.push(q);
                q = q.right;
            }
            else {
                q = st.pop();
                sum += q.val;
                q.val = sum;
                q = q.left;
            }
        }
        return root;
    }
}
