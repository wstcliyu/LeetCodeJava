import java.util.ArrayDeque;

public class Binary_173 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    ArrayDeque<TreeNode> st = new ArrayDeque<>();

    private void pushAll(TreeNode root) {
        while (root != null) {
            st.push(root);
            root = root.left;
        }
    }

    public Binary_173(TreeNode root) {
        pushAll(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !st.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode tmp = st.pop();
        pushAll(tmp.right);
        return tmp.val;
    }
}
