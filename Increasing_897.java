import java.util.ArrayDeque;

public class Increasing_897 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    // This problem should refer to in-order traversal
    // Refer to Binary_94


    // Morris inorder traversal
    public TreeNode increasingBST(TreeNode root) {
        TreeNode dummy = new TreeNode(0);
        TreeNode prev = dummy;
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left == null) {
                prev.right = curr;
                prev = curr;
                curr = curr.right;
            } else {
                TreeNode predecessor = curr.left;
                while (predecessor.right != null && predecessor.right != curr) {
                    predecessor = predecessor.right;
                }
                if (predecessor.right == null) {
                    predecessor.right = curr;
                    curr = curr.left;
                } else {
                    prev.right = curr;
                    prev = curr;
                    curr.left = null;
                    curr = curr.right;
                }
            }
        }
        return dummy.right;
    }



    // Iteration using stack
    /*
    public TreeNode increasingBST(TreeNode root) {
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        TreeNode dummy = new TreeNode(0), p = dummy;
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                TreeNode cur = stack.pop();
                root = cur.right;
                cur.left = null;
                p.right = cur;
                p = p.right;
            }
        }
        return dummy.right;
    }
    */



    // Most voted solution using recursion
    /*
    public TreeNode increasingBST(TreeNode root) {
        return increasingBST(root, null);
    }

    public TreeNode increasingBST(TreeNode root, TreeNode tail) {
        if (root == null) return tail;
        TreeNode res = increasingBST(root.left, root);
        root.left = null;
        root.right = increasingBST(root.right, tail);
        return res;
    }
    */
}
