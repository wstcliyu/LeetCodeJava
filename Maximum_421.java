import java.util.HashSet;
import java.util.Set;

class Maximum_421 {
    // Most voted solution
    /*
    public int findMaximumXOR(int[] nums) {
        int max = 0, mask = 0;
        for (int i = 31; i >= 0; i--) {
            mask |= (1 << i);
            int bestPossible = max | (1 << i);
            Set<Integer> set = new HashSet<>();
            for (int num : nums)
                set.add(num & mask);
            for (int leftPartNum : set) {
                if (set.contains(leftPartNum ^ bestPossible))
                    max = bestPossible;
            }
        }
        return max;
    }
    */



    // Second voted solution: Trie
    private class TreeNode {
        TreeNode left, right;
    }
    
    public int findMaximumXOR(int[] nums) {
        TreeNode root = new TreeNode();
        for (int num : nums) {
            TreeNode node = root;
            for (int i = 31; i >= 0; i--) {
                if ((num & (1 << i)) == 0) {
                    if (node.right == null) {
                        node.right = new TreeNode();
                    }
                    node = node.right;
                } else {
                    if (node.left == null) {
                        node.left = new TreeNode();
                    }
                    node = node.left;
                }
            }
        }
        
        int res = 0;
        
        for (int num : nums) {
            int max = 0;
            TreeNode node = root;
            for (int i = 31; i >= 0; i--) {
                if ((num & (1 << i)) == 0) {
                    if (node.left != null) {
                        max |= (1 << i);
                        node = node.left;
                    } else {
                        node = node.right;
                    }
                } else {
                    if (node.right != null) {
                        max |= (1 << i);
                        node = node.right;
                    } else {
                        node = node.left;
                    }
                }
            }
            res = Math.max(res, max);
        }
        
        return res;
    }
}