import java.util.LinkedList;

public class Invert_226 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode invertTree(TreeNode root) {
        // Iteration (BFS)
        // Similar to Binary_102
        // Time: O(n), Space: O(n)
        // n is the number of all the nodes
        /*
        if (root == null)
            return root;
        LinkedList<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int len = q.size();
            for (int i=0; i<len; i++) {
                TreeNode tmp = q.poll();
                TreeNode l = tmp.left;
                if (l != null)
                    q.add(l);
                TreeNode r = tmp.right;
                if (r != null)
                    q.add(r);
                tmp.left = r;
                tmp.right = l;
            }
        }
        return root;
        */


        // Recursion (DFS)
        // Time: O(n), n is the number of all the nodes
        // Space: O(h). h is the height of the tree
        /*
        if (root == null)
            return root;
        TreeNode tmp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(tmp);
        return root;
        */


        // Iteration (DFS)
        // The above solution is correct, but it is also bound to the application stack,
        // which means that it's no so much scalable -
        // (you can find the problem size that will overflow the stack and crash your application),
        // so more robust solution would be to use stack data structure.

        if (root == null)
            return root;

        final LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);

        while(!stack.isEmpty()) {
            final TreeNode node = stack.pop();
            final TreeNode left = node.left;
            node.left = node.right;
            node.right = left;

            if(node.left != null)
                stack.push(node.left);
            if(node.right != null)
                stack.push(node.right);
        }
        return root;
    }
}
