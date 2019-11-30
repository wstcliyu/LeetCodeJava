import java.util.*;

public class Count_315 {
    // Second voted solution: BST
    // https://leetcode.com/problems/count-of-smaller-numbers-after-self/discuss/76580/9ms-short-Java-BST-solution-get-answer-when-building-BST
    /*
    class Node {
        Node left, right;
        int val, sum, dup = 1;
        public Node(int v, int s) {
            val = v;
            sum = s;
        }
    }
    public List<Integer> countSmaller(int[] nums) {
        Integer[] ans = new Integer[nums.length];
        Node root = null;
        for (int i = nums.length - 1; i >= 0; i--) {
            root = insert(nums[i], root, ans, i, 0);
        }
        return Arrays.asList(ans);
    }
    private Node insert(int num, Node node, Integer[] ans, int i, int preSum) {
        if (node == null) {
            node = new Node(num, 0);
            ans[i] = preSum;
        } else if (node.val == num) {
            node.dup++;
            ans[i] = preSum + node.sum;
        } else if (node.val > num) {
            node.sum++;
            node.left = insert(num, node.left, ans, i, preSum);
        } else {
            node.right = insert(num, node.right, ans, i, preSum + node.dup + node.sum);
        }
        return node;
    }
    */



    // Second voted solution: iterative version
    class Node {
        int val, leftSum = 0, count = 0;
        Node left, right;
        public Node(int val) {
            this.val = val;
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        if (n == 0) return new ArrayList<>();
        Integer[] count = new Integer[n];
        Node root = new Node(nums[n - 1]);
        for (int i = n - 1; i >= 0; i--) {
            count[i] = insert(root, nums[i]);
        }
        return Arrays.asList(count);
    }

    private int insert(Node node, int num) {
        int sum = 0;
        while (node.val != num) {
            if (node.val > num) {
                if (node.left == null) node.left = new Node(num);
                node.leftSum++;
                node = node.left;
            } else {
                if (node.right == null) node.right = new Node(num);
                sum += node.leftSum + node.count;
                node = node.right;
            }
        }
        node.count++;
        // Don't forget to add node.leftSum
        return sum + node.leftSum;
    }
}