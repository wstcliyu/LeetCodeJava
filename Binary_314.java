import java.util.*;

import javafx.util.Pair;

public class Binary_314 {
    // Most voted solution #1
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Deque<Pair<TreeNode, Integer>> q = new ArrayDeque<>();
        q.addLast(new Pair<>(root, 0));
        Map<Integer, List<Integer>> map = new HashMap<>();
        int min = 0, max = 0;
        while (!q.isEmpty()) {
            Pair<TreeNode, Integer> pair = q.removeFirst();
            TreeNode node = pair.getKey();
            int col = pair.getValue();
            map.putIfAbsent(col, new ArrayList<>());
            map.get(col).add(node.val);
            if (node.left != null) {
                q.addLast(new Pair<>(node.left, col-1));
                min = Math.min(min, col-1);
            }
            if (node.right != null) {
                q.addLast(new Pair<>(node.right, col+1));
                max = Math.max(max, col+1);
            }
        }
        for (int i = min; i <= max; i++)
            res.add(map.get(i));
        return res;
    }



    // Most voted solution #2
    /*
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> cols = new ArrayList<>();
        if (root == null) {
            return cols;
        }
        
        int[] range = new int[] {0, 0};
        getRange(root, range, 0);
        
        for (int i = range[0]; i <= range[1]; i++) {
            cols.add(new ArrayList<Integer>());
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> colQueue = new LinkedList<>();
        
        queue.add(root);
        colQueue.add(-range[0]);
        
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            int col = colQueue.poll();
            
            cols.get(col).add(node.val);
            
            if (node.left != null) {
                queue.add(node.left);   
                colQueue.add(col - 1);
            } 
            if (node.right != null) {
                queue.add(node.right);
                colQueue.add(col + 1);
            }
        }
        
        return cols;
    }

    public void getRange(TreeNode root, int[] range, int col) {
        if (root == null) {
            return;
        }
        range[0] = Math.min(range[0], col);
        range[1] = Math.max(range[1], col);
        
        getRange(root.left, range, col - 1);
        getRange(root.right, range, col + 1);
    }
    */
}
