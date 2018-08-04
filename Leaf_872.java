import java.util.ArrayList;

public class Leaf_872 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> s1 = new ArrayList<>(), s2 = new ArrayList<>();
        leafValueSequence(root1, s1);
        leafValueSequence(root2, s2);
        /*
        if (s1.size() != s2.size())
            return false;
        for (int i=0; i<s1.size(); i++)
            if (s1.get(i) != s2.get(i))
                return false;
        return true;
        */
        // Use s1.equals(s2) to check whether two lists are equal
        return s1.equals(s2);
    }
    private void leafValueSequence(TreeNode root, ArrayList<Integer> s) {
        if (root == null)
            return;
        if (root.left == null && root.right == null)
            s.add(root.val);
        leafValueSequence(root.left, s);
        leafValueSequence(root.right, s);
    }
}
