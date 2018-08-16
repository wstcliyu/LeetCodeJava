import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Minimum_530 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // Most voted solution
    // https://leetcode.com/problems/minimum-absolute-difference-in-bst/discuss/99905/Two-Solutions-in-order-traversal-and-a-more-general-way-using-TreeSet
    // The most common idea is to first inOrder traverse the tree and
    // compare the delta between each of the adjacent values.
    // It's guaranteed to have the correct answer because it is a BST
    // thus inOrder traversal values are sorted
    // Solution 1 - In-Order traverse, time complexity O(N), space complexity O(1).
    Integer prev = null;
    int min = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        if (root == null)
            return min;
        getMinimumDifference(root.left);
        if (prev != null)
            min = Math.min(min, root.val - prev);
        prev = root.val;
        getMinimumDifference(root.right);
        return min;
    }

    // What if it is not a BST? (Follow up of the problem)
    // The idea is to put values in a TreeSet and
    // then every time we can use O(lgN) time to lookup for the nearest values
    // Solution 2 - Pre-Order traverse, time complexity O(NlgN), space complexity O(N)
    /*
    TreeSet<Integer> set = new TreeSet<>();
    int min = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        if (root == null) return min;

        if (!set.isEmpty()) {
            if (set.floor(root.val) != null) {
                min = Math.min(min, root.val - set.floor(root.val));
            }
            if (set.ceiling(root.val) != null) {
                min = Math.min(min, set.ceiling(root.val) - root.val);
            }
        }

        set.add(root.val);

        getMinimumDifference(root.left);
        getMinimumDifference(root.right);

        return min;
    }
    */


    // My first solution
    /*
    public int getMinimumDifference(TreeNode root) {
        List<Integer> bst = getListForBST(root);
        int diff = Integer.MAX_VALUE;
        for (int i=1; i<bst.size(); i++)
            diff = Math.min(diff, bst.get(i) - bst.get(i - 1));
        return diff;
    }
    private List<Integer> getListForBST(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        res.addAll(getListForBST(root.left));
        res.add(root.val);
        res.addAll(getListForBST(root.right));
        return res;
    }
    */
}
