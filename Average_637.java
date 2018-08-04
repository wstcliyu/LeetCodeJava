import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Average_637 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    // Approach #1 DFS in standard solution
    // Time: O(n), n is the number of all nodes
    // Space: O(h), h is the maximum depth of the tree, because the length of count and res is h
    /*
    public List < Double > averageOfLevels(TreeNode root) {
        List < Integer > count = new ArrayList < > ();
        List < Double > res = new ArrayList < > ();
        average(root, 0, res, count);
        for (int i = 0; i < res.size(); i++)
            res.set(i, res.get(i) / count.get(i));
        return res;
    }

    // i denotes at which level the TreeNode t is
    public void average(TreeNode t, int i, List < Double > sum, List < Integer > count) {
        if (t == null)
            return;
        if (i < sum.size()) {
            sum.set(i, sum.get(i) + t.val);
            count.set(i, count.get(i) + 1);
        } else {
            sum.add(1.0 * t.val);
            count.add(1);
        }
        average(t.left, i + 1, sum, count);
        average(t.right, i + 1, sum, count);
    }
    */


    public List<Double> averageOfLevels(TreeNode root) {
        // My solution is similar with Approach #2 BFS in standard solution
        // Time: O(n), n is the number of all nodes
        // Space: O(m), m is the maximum number of nodes in one level
        List<Double> res = new ArrayList<>();
        if (root == null)
            return res;
        LinkedList<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            // Use long instead of int because the levelSum may be very large
            long levelSum = 0;
            int len = q.size();
            for (int i=0; i<len; i++) {
                TreeNode tmp = q.poll();
                levelSum += tmp.val;
                if (tmp.left != null)
                    q.add(tmp.left);
                if (tmp.right != null)
                    q.add(tmp.right);
            }
            res.add(1.0 * levelSum / len);
        }
        return res;
    }
}
