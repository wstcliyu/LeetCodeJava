import java.util.*;

public class Binary_94 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // Iterative using a stack (Template can be found in Binary_145)
    // Time: O(n)
    // Space: O(n)
    
    public List<Integer> inorderTraversal(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while (!stack.empty() || p != null) {
            if (p != null) {
                stack.push(p);
                p = p.left;
            } else {
                TreeNode node = stack.pop();
                result.add(node.val);
                p = node.right;
            }
            /*
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            TreeNode node = stack.pop();
            result.add(node.val);
            p = node.right;
            */
        }
        return result;
    }
    


    // Morris traversal
    // Iterative without stack
    // Time: O(n)
    // Space: O(n)
    /*
    Step 1: Initialize current as root

    Step 2: While current is not NULL,

    If current does not have left child

        a. Add current’s value

        b. Go to the right, i.e., current = current.right

    Else

        a. In current's left subtree, make current the right child of the rightmost node

        b. Go to this left child, i.e., current = current.left
    */

    /*
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode cur = root;
        while (cur != null) {
            TreeNode left = cur.left;
            if (left == null) {
                res.add(cur.val);
                cur = cur.right; // move to next right node
            } else { // has a left subtree
                TreeNode pre = left;
                while (pre.right != null) { // find rightmost
                    pre = pre.right;
                }
                pre.right = cur; // put cur after the pre node
                cur.left = null; // original cur left be null, avoid infinite loops
                cur = left; // move cur to the top of the new tree
            }
        }
        return res;
    }
    */




    // Morrise inorder traversal without changing the structure of the tree
    /*
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode current = root;
        while (current != null) {
            if (current.left == null) {
                res.add(current.val);
                current = current.right; // move to next right node
            } else { // has a left subtree
                TreeNode predecessor = current.left;
                while (predecessor.right != current && predecessor.right != null) { // find rightmost
                    predecessor = predecessor.right;
                }
                
                if (predecessor.right == null) { 
                    // current needs to be put at the right child of predecessor 
                    predecessor.right = current;
                    current = current.left;
                } else { 
                    // current was previously put at the right child of predecessor
                    // now we need to unlink them
                    predecessor.right = null;
                    res.add(current.val);
                    current = current.right;
                }
            }
        }
        return res;
    }
    */
}
