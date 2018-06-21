public class Convert_108 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length-1);
    }
    private TreeNode helper(int[] nums, int left, int right) {
        if (left > right)
            return null;
        int mid = left + (right-left+1)/2;
        TreeNode res = new TreeNode(nums[mid]);
        res.left = helper(nums, left, mid-1);
        res.right = helper(nums, mid+1, right);
        return res;
    }
}
