public class Maximum_654 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    // https://leetcode.com/problems/maximum-binary-tree/solution/
    // Refer to standard solution for complexity analysis
    // Time: Average O(nlgn), Worse O(n^2)
    // Space: Average O(lgn), Worse O(n)
    /*
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }
    private TreeNode helper(int[] nums, int start, int end) {
        if (start > end)
            return null;
        int index = start, max = nums[start];
        for (int i=start; i<=end; i++) {
            if (nums[i] > max) {
                index = i;
                max = nums[i];
            }
        }
        TreeNode root = new TreeNode(max);
        root.left = helper(nums, start, index - 1);
        root.right = helper(nums, index + 1, end);
        return root;
    }
    */



    // Most voted solution: Mono Stack
    // Time: O(n), Space: O(n)
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        Deque<TreeNode> st = new ArrayDeque<>();
        for (int num : nums) {
            TreeNode node = new TreeNode(num);
            while (!st.isEmpty() && st.getLast().val < num) {
                node.left = st.removeLast();
            }
            if (!st.isEmpty()) {
                st.getLast().right = node;
            }
            st.addLast(node);
        }
        return st.getFirst();
    }
}
