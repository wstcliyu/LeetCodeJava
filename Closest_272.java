import java.util.*;

class Solution {
    // Second voted solution
    // Time: O(klgn), Space(lgn)
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> pred = new Stack<>();
        Stack<TreeNode> succ = new Stack<>();
        initPredStack(pred, root, target);
        initSuccStack(succ, root, target);
        // Pay attention here
        // If target equals a certain element in the BST, the top elements of these 2 stacks are equal
        // So we first need to call either getNextPred() or getNextSucc()
        if (!succ.isEmpty() && !pred.isEmpty() && succ.peek().val == pred.peek().val) {
            getNextPred(pred);
            // My mistake
            // res.add(getNextPred(pred));
            // succ.pop();
        }
        while (res.size() < k) {
            if (pred.isEmpty()) {
                res.add(getNextSucc(succ));
            } else if (succ.isEmpty()) {
                res.add(getNextPred(pred));
            } else {
                double pred_diff = Math.abs((double)pred.peek().val - target);
                double succ_diff = Math.abs((double)succ.peek().val - target);
                if (pred_diff < succ_diff) {
                    res.add(getNextPred(pred));
                } else {
                    res.add(getNextSucc(succ));
                }
            }
        }
        return res;
    }
    
    private void initPredStack(Stack<TreeNode> pred, TreeNode root, double target) {
        while (root != null) {
            if (root.val == target) {
                pred.push(root);
                return;
            } else if (root.val < target) {
                pred.push(root);
                root = root.right;
            } else {
                root = root.left;
            }
        }
    }
    
    private void initSuccStack(Stack<TreeNode> succ, TreeNode root, double target) {
        while (root != null) {
            if (root.val == target) {
                succ.push(root);
                return;
            } else if (root.val > target) {
                succ.push(root);
                root = root.left;
            } else {
                root = root.right;
            }
        }
    }
    
    private int getNextPred(Stack<TreeNode> pred) {
        TreeNode node = pred.pop();
        int res = node.val;
        node = node.left;
        while (node != null) {
            pred.push(node);
            node = node.right;
        }
        return res;
    }
    
    private int getNextSucc(Stack<TreeNode> succ) {
        TreeNode node = succ.pop();
        int res = node.val;
        node = node.right;
        while (node != null) {
            succ.push(node);
            node = node.left;
        }
        return res;
    }
}