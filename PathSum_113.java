import java.util.LinkedList;
import java.util.List;

public class PathSum_113 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new LinkedList<>();
        helper(res, new LinkedList<>(), root, sum);
        return res;
    }
    private void helper(List<List<Integer>> ls, List<Integer> tmp, TreeNode root, int target) {
        if (root == null)
            return;
        tmp.add(root.val); // Add and remove outside the if ... else ...
        if (root.val == target && root.left == null && root.right == null)
            ls.add(new LinkedList<>(tmp)); // Must not use ls.add(tmp);
        else {
            helper(ls, tmp, root.left, target - root.val);
            helper(ls, tmp, root.right, target - root.val);
        }
        tmp.remove(tmp.size() - 1); // Remove the last integer
    }
}
