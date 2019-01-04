import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Binary_257 {
    
    // Refer to the following link for two iterative solutions: dfs+stack and bfs+queue
    // https://leetcode.com/problems/binary-tree-paths/discuss/68272/Python-solutions-(dfs%2Bstack-bfs%2Bqueue-dfs-recursively).
    
    public List<String> binaryTreePaths(TreeNode root) {
        // My first solution using recursion
        /*
        if (root == null)
            return Arrays.asList();
        if (root.left == null && root.right == null)
            return Arrays.asList(String.valueOf(root.val));
        ArrayList<String> res = new ArrayList<>();
        if (root.left != null) {
            for (String s : binaryTreePaths(root.left))
                res.add(root.val + "->" + s);
        }
        if (root.right != null) {
            for (String s : binaryTreePaths(root.right))
                res.add(root.val + "->" + s);
        }
        return res;
        */
        List<String> res = new ArrayList<>();
        if (root != null)
            searchBT(root, "", res);
        return res;
    }
    private void searchBT(TreeNode root, String path, List<String> res) {
        if (root.left == null && root.right == null)
            res.add(path+root.val);
        if (root.left != null)
            searchBT(root.left, path+root.val+"->", res);
        if (root.right != null)
            searchBT(root.right, path+root.val+"->", res);
    }
}
