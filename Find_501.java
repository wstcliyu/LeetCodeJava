import java.util.ArrayList;
import java.util.Arrays;

public class Find_501 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // My solution, refer to second voted solution (A little different)
    // https://leetcode.com/problems/find-mode-in-binary-search-tree/discuss/98100/Java-4ms-Beats-100-Extra-O(1)-solution-No-Map
    /*
    public int[] findMode(TreeNode root) {
        ArrayList<Integer> ls = new ArrayList<>();
        helper(ls, root);
        int[] res = new int[ls.size()];
        int i = 0;
        for (int mode : ls)
            res[i++] = mode;
        return res;
    }

    Integer prev = null;
    int max = 0;
    int count = 0; // The second voted solution initialize count to 1

    private void helper(ArrayList<Integer> ls, TreeNode root) {
        if (root == null)
            return;
        helper(ls, root.left);
        if (prev == null) {
            count = 1;
            max = 1;
            ls.add(root.val);
        }
        else {
            if (root.val == prev)
                count++;
            else if (root.val > prev)
                count = 1;
            if (count == max)
                ls.add(root.val);
            else if (count > max) {
                ls.clear();
                ls.add(root.val);
                max = count;
            }
        }
        prev = root.val;
        helper(ls, root.right);
    }
    */


    // Most voted solution
    // https://leetcode.com/problems/find-mode-in-binary-search-tree/discuss/98101/Proper-O(1)-space?page=1
    public int[] findMode(TreeNode root) {
        inorder(root);
        modes = new int[modeCount];
        modeCount = 0;
        currCount = 0;
        inorder(root);
        return modes;
    }

    private int currVal;
    private int currCount = 0;
    private int maxCount = 0;
    private int modeCount = 0;

    private int[] modes;

    private void handleValue(int val) {
        if (val != currVal) {
            currVal = val;
            currCount = 0;
        }
        currCount++;
        if (currCount > maxCount) {
            maxCount = currCount;
            modeCount = 1;
        } else if (currCount == maxCount) {
            if (modes != null)
                modes[modeCount] = currVal;
            modeCount++;
        }
    }

    private void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        handleValue(root.val);
        inorder(root.right);
    }

    // Morris traversal
    /*
    private void inorder(TreeNode root) {
        TreeNode node = root;
        while (node != null) {
            if (node.left == null) {
                handleValue(node.val);
                node = node.right;
            } else {
                TreeNode prev = node.left;
                while (prev.right != null && prev.right != node)
                    prev = prev.right;
                if (prev.right == null) {
                    prev.right = node;
                    node = node.left;
                } else {
                    prev.right = null;
                    handleValue(node.val);
                    node = node.right;
                }
            }
        }
    }
    */

    public static void main(String[] args) {
        Find_501 test = new Find_501();
        TreeNode two = test.new TreeNode(2);
        TreeNode one = test.new TreeNode(1);
        TreeNode three = test.new TreeNode(3);
        two.left = one;
        two.right = three;
        System.out.println(Arrays.toString(test.findMode(two)));
    }
}
