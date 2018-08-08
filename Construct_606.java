import java.util.Set;
import java.util.Stack;
import java.util.HashSet;

public class Construct_606 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // https://leetcode.com/problems/construct-string-from-binary-tree/solution/


    // Standard Solution Approach #1 Using Recursion
    // Time: O(n). The preorder traversal is done over the nn nodes of the given Binary Tree.
    // Space: O(n). The depth of the recursion tree can go upto nn in case of a skewed tree.
    /*
    public String tree2str(TreeNode t) {
        if(t==null)
            return "";
        if(t.left==null && t.right==null)
            return t.val+"";
        if(t.right==null)
            return t.val+"("+tree2str(t.left)+")";
        return t.val+"("+tree2str(t.left)+")("+tree2str(t.right)+")";
    }
    */


    // Standard Solution Approach #2 Using Iteration, Stack and Set
    // Time: O(n)
    // Space: O(n)
    /*
    public String tree2str(TreeNode t) {
        if (t == null)
            return "";
        Stack< TreeNode > stack = new Stack < > ();
        stack.push(t);
        Set< TreeNode > visited = new HashSet < > ();
        StringBuilder s = new StringBuilder();
        while (!stack.isEmpty()) {
            t = stack.peek();
            if (visited.contains(t)) {
                stack.pop();
                s.append(")");
            } else {
                visited.add(t);
                s.append("(" + t.val);
                if (t.left == null && t.right != null)
                    s.append("()");
                if (t.right != null)
                    stack.push(t.right);
                if (t.left != null)
                    stack.push(t.left);
            }
        }
        return s.substring(1, s.length() - 1);
    }
    */


    // My solution using StringBuilder, faster than just using String
    // Complexity same as Approach #1 Using Recursion
    public String tree2str(TreeNode t) {
        StringBuilder sb = new StringBuilder();
        helper(t, sb);
        return sb.toString();
    }
    private void helper(TreeNode t, StringBuilder sb) {
        if(t == null)
            return;
        if(t.left == null && t.right == null)
            sb.append(t.val);
        else if(t.right == null) {
            sb.append(t.val + "(");
            helper(t.left, sb);
            sb.append(")");
        }
        else {
            sb.append(t.val + "(");
            helper(t.left, sb);
            sb.append(")(");
            helper(t.right, sb);
            sb.append(")");
        }
    }
}
