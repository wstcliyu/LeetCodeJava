import java.util.Stack;

public class Flatten_114 {
    // Most voted solution using postorder traversal, recursion and global variable
    /*
    private TreeNode prev = null;

    public void flatten(TreeNode root) {
        if (root == null)
            return;
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }
    */


    // version that does not use the global variable
    public void flatten(TreeNode root) {
        helper(root, null);
    }

    // helper function takes in the previous head, do the flattening and returns the head of the flatten binary tree
    private TreeNode helper(TreeNode root, TreeNode prev) {
        if (root == null) return prev;
        root.right = helper(root.left, helper(root.right, prev));
        root.left = null;
        return root;
    }




    // My solution using preorder traversal, recursion and global variable
    /*
    TreeNode dummy = new TreeNode(0);

    public void flatten(TreeNode root) {
        if (root == null) return;
        dummy.right = root;
        dummy = dummy.right;
        TreeNode right = root.right;
        flatten(root.left);
        flatten(right);
        root.left = null;
    }
    */


    // My solution using preorder traversal and iteration
    /*
    public void flatten(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        TreeNode dummy = new TreeNode(0);
        while (!st.empty()) {
            TreeNode tmp = st.pop();
            if (tmp.right != null) st.push(tmp.right);
            if (tmp.left != null) st.push(tmp.left);
            dummy.right = tmp;
            dummy = tmp;
            tmp.left = null;
        }
    }
    */




    // My solution using iteration
    /*
    public void flatten(TreeNode root) {
        TreeNode now = root;
        while(now != null) {
            if (now.left != null) {
                TreeNode p = now.left;
                while(p.right != null)
                    p = p.right;
                p.right = now.right;
                now.right = now.left;
                now.left = null;
            }
            now = now.right;
        }
    }
    */
}
