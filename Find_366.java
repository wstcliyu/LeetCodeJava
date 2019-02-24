import java.util.*;

public class Find_366 {
    // Most voted solution
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        height(root, res);
        return res;
    }

    private int height(TreeNode node, List<List<Integer>> res){
        if (node == null)  return -1;
        int level = 1 + Math.max(height(node.left, res), height(node.right, res));
        if (level == res.size()) res.add(new ArrayList<>());
        res.get(level).add(node.val);
        // If the problem require us to remove all leaves, we can add the following code
        // node.left = node.right = null;
        return level;
    }
}
