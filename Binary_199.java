import javafx.util.Pair;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Binary_199 {
    // My first solutoin using iteration (DFS/Preorder traversal)
    public List<Integer> rightSideView(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        if (root == null) return res;
        Stack<Pair<TreeNode, Integer>> st = new Stack<>();
        st.push(new Pair<>(root, 1));
        while(!st.empty()) {
            Pair<TreeNode, Integer> tmp = st.pop();
            TreeNode node = tmp.getKey();
            int level = tmp.getValue();
            if (level > res.size())
                res.add(node.val);
            if (node.left != null)
                st.push(new Pair<>(node.left, 1 + level));
            if (node.right != null)
                st.push(new Pair<>(node.right, 1 + level));
        }
        return res;
    }

    
    // My first solutoin using recursion (DFS/Preorder traversal)
    /*
    public List<Integer> rightSideView(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        if (root == null) return res;
        dfs(root, 0, res);
        return res;
    }

    private void dfs(TreeNode root, int level, LinkedList<Integer> res) {
        if (root == null) return;
        if (level == res.size()) res.add(root.val);
        dfs(root.right, 1 + level, res);
        dfs(root.left, 1 + level, res);
    }
    */


    // My first solutoin using BFS
    /*
    public List<Integer> rightSideView(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        if (root == null) return res;
        LinkedList<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                TreeNode tmp = q.removeFirst();
                if (tmp.right != null)
                    q.add(tmp.right);
                if (tmp.left != null)
                    q.add(tmp.left);
                if (i == 0)
                    res.add(tmp.val);
            }
        }
        return res;
    }
    */
}
