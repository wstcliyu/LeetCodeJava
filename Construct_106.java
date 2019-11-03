import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Construct_106 {
    // Refer to Construct_105
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        if (n == 0) return null;
        Stack<TreeNode> st = new Stack<>();
        TreeNode root = new TreeNode(postorder[n - 1]);
        st.push(root);
        for (int i = n - 2, j = n - 1; i >= 0; i--) {
            TreeNode node = new TreeNode(postorder[i]);
            if (inorder[j] != st.peek().val) {
                st.peek().right = node;
                st.push(node);
            } else {
                TreeNode pre = st.peek();
                while (!st.isEmpty() && inorder[j] == st.peek().val) {
                    pre = st.pop();
                    j--;
                }
                pre.left = node;
                st.push(node);
            }
        }
        return root;
    }


    /*
    private Map<Integer, Integer> map;
    private int[] post;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.post = postorder;
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) map.put(inorder[i], i);
        return helper(post.length - 1, 0, inorder.length - 1);
    }

    private TreeNode helper(int postStart, int inStart, int inEnd) {
        if (inStart > inEnd) return null;
        TreeNode res = new TreeNode(post[postStart]);
        int mid = map.get(post[postStart]);
        res.right = helper(postStart - 1, mid + 1, inEnd);
        res.left = helper(postStart - inEnd + mid - 1, inStart, mid - 1);
        return res;
    }
    */
}
