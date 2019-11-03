import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Construct_105 {
    // My solution using iteration and stack
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) return null;
        Stack<TreeNode> st = new Stack<>();
        TreeNode root = new TreeNode(preorder[0]);
        st.push(root);
        for (int i = 1, j = 0; i < preorder.length; i++) {
            
            TreeNode node = new TreeNode(preorder[i]);

            // 1. Keep pushing the nodes from the preorder into a stack
            // (and keep making the tree by adding nodes to the left of the previous node)
            // until the top of the stack matches the inorder.
            if (inorder[j] != st.peek().val) {
                st.peek().left = node;
                st.push(node);
            } else {
                // 2. Keep popping nodes from the stack until the stack becomes empty or
                // the top of the stack is different from inorder[j]. Keep track of the last
                // node popping out of the stack and add current new node to its right.
                TreeNode pre = st.peek();
                while (!st.isEmpty() && inorder[j] == st.peek().val) {
                    pre = st.pop();
                    j++;
                }
                pre.right = node;
                st.push(node);
            }
        }
        return root;
    }


    // Use a map to store the index of each node in inorder sequence
    // Create a TreeNode with preorder[preStart]
    // Split the inorder sequence to make its left and right subtree
    /*
    private Map<Integer, Integer> map;
    private int[] pre;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // this.pre = preorder;
        pre = preorder;
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) map.put(inorder[i], i);
        return helper(0, 0, inorder.length - 1);
    }

    private TreeNode helper(int preStart, int inStart, int inEnd) {
        if (inStart > inEnd) return null;
        TreeNode res = new TreeNode(pre[preStart]);
        int mid = map.get(pre[preStart]);
        res.left = helper(preStart + 1, inStart, mid - 1);
        res.right = helper(preStart + mid - inStart + 1, mid + 1, inEnd);
        return res;
    }
    */


    // Good submission without using map
    /*
    private int preIndex, inIndex;
    private int[] pre, in;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preIndex = 0;
        this.inIndex = 0;
        this.pre = preorder;
        this.in = inorder;
        return traverse(null);
    }

    private TreeNode traverse(TreeNode end) {
        if (preIndex == pre.length || (end != null && in[inIndex] == end.val))
            return null;
        TreeNode node = new TreeNode(pre[preIndex++]);
        node.left = traverse(node);
        inIndex++;
        node.right = traverse(end);
        return node;
    }
    */
}
