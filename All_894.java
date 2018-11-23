import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class All_894 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // Standard solution using recursion and cache
    Map<Integer, List<TreeNode>> cache= new HashMap<>();
    public List<TreeNode> allPossibleFBT(int N) {
        List<TreeNode> res = new ArrayList<>();
        if(N % 2 == 0)
            return res;
        if(cache.containsKey(N))
            return cache.get(N);
        if(N == 1) {
            res.add(new TreeNode(0));
            return res;
        }

        for(int i = 1; i < N; i += 2){
            List<TreeNode> left = allPossibleFBT(i);
            List<TreeNode> right = allPossibleFBT(N - 1 - i);
            for(TreeNode nl : left){
                for(TreeNode nr : right){
                    TreeNode cur = new TreeNode(0);
                    cur.left = nl;
                    cur.right = nr;
                    res.add(cur);
                }
            }
        }
        cache.put(N,res);
        return res;
    }

    // My first solution using recursion, without cache
    /*
    public List<TreeNode> allPossibleFBT(int N) {
        List<TreeNode> res = new ArrayList<>();
        if (N % 2 == 0)
            return res;
        if (N == 1) {
            res.add(new TreeNode(0));
            return res;
        }
        for (int i = 1; i < N; i += 2) {
            for (TreeNode left : allPossibleFBT(i)) {
                for (TreeNode right : allPossibleFBT(N - 1 - i)) {
                    TreeNode root = new TreeNode(0);
                    root.left = left;
                    root.right = right;
                    res.add(root);
                }
            }
        }
        return res;
    }
    */
}
