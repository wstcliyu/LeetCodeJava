import java.util.Stack;

class TwoSum_1214 {
    // My first solution: BST iterator (refer to Bianry_173)
    // Similar to most voted solution
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        pushAll1(root1, s1);
        pushAll2(root2, s2);
        while (!s1.isEmpty() && !s2.isEmpty()) {
            int v1 = s1.peek().val;
            int v2 = s2.peek().val;
            if (v1 + v2 < target) {
                TreeNode node = s1.pop();
                pushAll1(node.right, s1);
            } else if (v1 + v2 > target) {
                TreeNode node = s2.pop();
                pushAll2(node.left, s2);
            } else {
                return true;
            }
        }
        return false;
    }
    
    private void pushAll1(TreeNode root1, Stack<TreeNode> s1) {
        while (root1 != null) {
            s1.push(root1);
            root1 = root1.left;
        }
    }
    
    private void pushAll2(TreeNode root2, Stack<TreeNode> s2) {
        while (root2 != null) {
            s2.push(root2);
            root2 = root2.right;
        }
    }



    // Most voted solution
    /*
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        // if either of the tree is empty
        if (root1 == null || root2 == null)
            return false;

        // stack 'stack1' used for the inorde traversal of root 1
        // stack 'stack2' used for the reverse inorder traversal of root 2
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        TreeNode t1, t2;

        while (true) {
            // LeftMost Node.
            while (root1 != null) {
                stack1.push(root1);
                root1 = root1.left;
            }
            // RighMost Node.
            while (root2 != null) {
                stack2.push(root2);
                root2 = root2.right;
            }
            // If either is empty then break.
            if (stack1.empty() || stack2.empty())
                break;

            t1 = stack1.peek();
            t2 = stack2.peek();

            // if the sum of the node's is equal to 'target'
            if ((t1.val + t2.val) == target) {
                return true;
            }

            // move to next possible node in the inorder traversal of root 1
            else if ((t1.val + t2.val) < target) {
                stack1.pop();
                root1 = t1.right;
            }

            // move to next possible node in the reverse inorder traversal of root 2
            else {
                stack2.pop();
                root2 = t2.left;
            }
        }

        return false;
    }
    */
}