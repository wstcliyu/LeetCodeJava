import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Find_515 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // Most voted solution using DFS
    /*
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        helper(root, res, 0);
        return res;
    }
    private void helper(TreeNode root, List<Integer> res, int d){
        if(root == null){
            return;
        }
        //expand list size
        if(d == res.size()){
            res.add(root.val);
        }
        else{
        //or set value
            res.set(d, Math.max(res.get(d), root.val));
        }
        helper(root.left, res, d+1);
        helper(root.right, res, d+1);
    }
    */


    // My solution using BFS
    public List<Integer> largestValues(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        if (root == null)
            return res;
        LinkedList<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int max = Integer.MIN_VALUE;
            int len = q.size();
            // This step is very important because the size of q is always changing
            // So we cannot write in this way for (int i=0; i<q.size(); i++)
            for (int i=0; i<len; i++) {
                TreeNode tmp = q.poll();
                max = Math.max(max, tmp.val);
                if (tmp.left != null)
                    q.add(tmp.left);
                if (tmp.right != null)
                    q.add(tmp.right);
            }
            res.add(max);
        }
        return res;
    }
}
