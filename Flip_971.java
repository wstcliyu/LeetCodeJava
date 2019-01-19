import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Flip_971 {
    // Recursion
    /*
    List<Integer> res = new ArrayList<>();
    int i = 0;

    public List<Integer> flipMatchVoyage(TreeNode root, int[] v) {
        return dfs(root, v) ? res : Arrays.asList(-1);
    }

    public boolean dfs(TreeNode node, int[] v) {
        if (node == null) return true;
        if (node.val != v[i++]) return false;
        if (node.left != null && node.left.val != v[i]) {
            res.add(node.val);
            return dfs(node.right, v) && dfs(node.left, v);
        }
        return dfs(node.left, v) && dfs(node.right, v);
    }
    */


    // Iterative version of the above method
    /*
    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        st.add(root);
        int i = 0;
        while (i < voyage.length) {
            TreeNode cur = st.pop();
            if (cur == null) continue;
            if (cur.val != voyage[i++])
                return Arrays.asList(-1);
            if (cur.left != null && i < voyage.length && cur.left.val != voyage[i]) {
                res.add(cur.val);
                st.push(cur.left);
                st.push(cur.right);
            } else {
                st.push(cur.right);
                st.push(cur.left);
            }
        }
        return res;
    }
    */


    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        List<Integer> path = new ArrayList<>();
        if (dfs(root, voyage, 0, path) == -1) return Arrays.asList(-1);
        return path;
    }

    private int dfs(TreeNode root, int[] voyage, int i, List<Integer> path) {
        if (root == null) return i;
        if (root.val != voyage[i])  return -1;
        int left = dfs(root.left, voyage, i + 1, path);
        if (left != -1) return dfs(root.right, voyage, left, path);
		// need a flip
        path.add(root.val);
        int right = dfs(root.right, voyage, i + 1, path);
        if (right != -1) return dfs(root.left, voyage, right, path);
        return -1;
    }
}
