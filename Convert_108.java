import java.util.Stack;

public class Convert_108 {
    // Recursion
    /*
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }
    private TreeNode helper(int[] nums, int left, int right) {
        if (left > right)
            return null;
        int mid = (left + right) / 2;
        TreeNode res = new TreeNode(nums[mid]);
        res.left = helper(nums, left, mid - 1);
        res.right = helper(nums, mid + 1, right);
        return res;
    }
    */

    // Iteration
    class TreeNodeWithInterval extends TreeNode {
        int start, end;
        TreeNodeWithInterval(int s, int e) {
            super(0);
            start = s;
            end = e;
        }
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        Stack<TreeNodeWithInterval> stack = new Stack<>();
        TreeNodeWithInterval root = new TreeNodeWithInterval(0, nums.length - 1);
        TreeNodeWithInterval p = root;
        while (!stack.empty() || p.start <= p.end) {
            if (p.start <= p.end) {
                stack.push(p);
                int mid = (p.start + p.end) / 2;
                p.val = nums[mid];
                TreeNodeWithInterval tmp = new TreeNodeWithInterval(p.start, mid - 1);
                p.left = p.start <= mid - 1 ? tmp : null;
                p = tmp;
            }
            else {
                p = stack.pop();
                int mid = (p.start + p.end) / 2;
                TreeNodeWithInterval tmp = new TreeNodeWithInterval(mid + 1, p.end);
                p.right = mid + 1 <= p.end ? tmp : null;
                p = tmp;
            }
        }
        return root;
    }


    // The following is also correct, which is the same as the above
    /*
    class HelperClass {
        TreeNode node;
        int start, end;
        HelperClass(TreeNode n, int s, int e) {
            node = n;
            start = s;
            end = e;
        }
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        Stack<HelperClass> stack = new Stack<>();
        HelperClass root = new HelperClass(new TreeNode(0), 0, nums.length - 1);
        HelperClass p = root;
        while (!stack.empty() || p.start <= p.end) {
            if (p.start <= p.end) {
                stack.push(p);
                int mid = (p.start + p.end) / 2;
                p.node.val = nums[mid];
                HelperClass tmp = new HelperClass(new TreeNode(0), p.start, mid - 1);
                p.node.left = p.start <= mid - 1 ? tmp.node : null;
                p = tmp;
            }
            else {
                p = stack.pop();
                int mid = (p.start + p.end) / 2;
                HelperClass tmp = new HelperClass(new TreeNode(0), mid + 1, p.end);
                p.node.right = mid + 1 <= p.end ? tmp.node : null;
                p = tmp;
            }
        }
        return root.node;
    }
    */
}
