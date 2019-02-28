import java.util.*;

import javafx.util.Pair;

public class Binary_314 {
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
}
