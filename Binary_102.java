import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Binary_102 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        LinkedList<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int len = q.size();
            for (int i=0; i<len; i++) {
                TreeNode tmp = q.removeFirst();
                level.add(tmp.val);
                if (tmp.left != null)
                    q.add(tmp.left);
                if (tmp.right != null)
                    q.add(tmp.right);
            }
            res.add(level);
        }
        return res;
    }

    // Recursion. Similar with 107.
    /*
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> wrapList = new LinkedList<List<Integer>>();
        levelMaker(wrapList, root, 0);
        return wrapList;
    }
    
    public void levelMaker(List<List<Integer>> list, TreeNode root, int level) {
        if(root == null) return;
        if(level >= list.size()) 
            list.add(new LinkedList<Integer>());
        levelMaker(list, root.left, level+1);
        levelMaker(list, root.right, level+1);
        list.get(level).add(root.val);
    }
    */
}
