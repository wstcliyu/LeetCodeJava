import javafx.util.Pair;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Maximum_662 {
    // My first solution using BFS (refer to my annotation in 958)
    /*
    public int widthOfBinaryTree(TreeNode root) {
        int res = 0;
        if (root == null) return 0;
        LinkedList<Pair<TreeNode, Integer>> q = new LinkedList<>();
        q.add(new Pair<>(root, 1));
        while (!q.isEmpty()) {
            int len = q.size();
            int start = 0, end = 0;
            for (int i = 0; i < len; i++) {
                Pair<TreeNode, Integer> tmp = q.poll();
                TreeNode node = tmp.getKey();
                int code = tmp.getValue();
                if (i == 0) start = code;
                if (i == len - 1) end = code;
                if (node.left != null)
                    q.add(new Pair<>(node.left, 2 * code));
                if (node.right != null)
                    q.add(new Pair<>(node.right, 2 * code + 1));
            }
            res = Math.max(res, end - start + 1);
        }
        return res;
    }
    */


    // Standard solution #2:
    int ans;
    Map<Integer, Integer> left;
    public int widthOfBinaryTree(TreeNode root) {
        ans = 0;
        left = new HashMap();

        // dfs(root, 0, 1);
        // It is OK to set root as 0 or 1
        dfs(root, 0, 0);
        return ans;
    }
    public void dfs(TreeNode root, int depth, int pos) {
        if (root == null) return;
        left.computeIfAbsent(depth, x-> pos);
        ans = Math.max(ans, pos - left.get(depth) + 1);
        dfs(root.left, depth + 1, 2 * pos);
        dfs(root.right, depth + 1, 2 * pos + 1);
    }
}
