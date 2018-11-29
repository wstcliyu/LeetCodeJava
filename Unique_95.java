import java.util.ArrayList;
import java.util.List;

public class Unique_95 {
    // Standard solution using recursion
    /*
    public List<TreeNode> generateTrees(int n) {
        if(n == 0) return new ArrayList<>();
        return generateBST(1, n);
    }

    private List<TreeNode> generateBST(int lo, int hi) {
        List<TreeNode> ret = new ArrayList<>();
        if(lo > hi) {
            ret.add(null);
            return ret;
        }
        for(int i = lo; i <= hi; ++i) {
            for(TreeNode left : generateBST(lo, i-1)) {
                for(TreeNode right : generateBST(i+1, hi)) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    ret.add(root);
                }
            }
        }
        return ret;
    }
    */

    // My first solution using DP, similar with the following link
    // https://leetcode.com/problems/unique-binary-search-trees-ii/discuss/31493/Java-Solution-with-DP
    public List<TreeNode> generateTrees(int n) {
        List<ArrayList<TreeNode>> dp = new ArrayList<>();
        dp.add(new ArrayList<>());
        if (n == 0)
            return dp.get(0);
        dp.get(0).add(null);
        for (int len = 1; len <= n; len++) {
            ArrayList<TreeNode> tmp = new ArrayList<>();
            for (int j = 0; j < len; j++) {
                for (TreeNode left : dp.get(j)) {
                    for (TreeNode right : dp.get(len - 1 - j)) {
                        TreeNode root = new TreeNode(j + 1);
                        root.left = left;
                        root.right = clone(right, j + 1);
                        tmp.add(root);
                    }
                }
            }
            dp.add(tmp);
        }
        return dp.get(n);
    }

    private TreeNode clone(TreeNode root, int offset) {
        if (root == null)
            return null;
        TreeNode res = new TreeNode(root.val + offset);
        res.left = clone(root.left, offset);
        res.right = clone(root.right, offset);
        return res;
    }
}
