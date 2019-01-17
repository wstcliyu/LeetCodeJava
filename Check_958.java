import javafx.util.Pair;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Check_958 {
    // Most voted solution using BFS
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> bfs = new LinkedList<TreeNode>();
        bfs.offer(root);
        while (bfs.peek() != null) {
            TreeNode node = bfs.poll();
            bfs.offer(node.left);
            bfs.offer(node.right);
        }
        while (!bfs.isEmpty() && bfs.peek() == null)
            bfs.poll();
        return bfs.isEmpty();
    }

    // Standard solution using BFS
    /*
    public boolean isCompleteTree(TreeNode root) {
        List<Pair<TreeNode, Integer>> q = new ArrayList<>();
        q.add(new Pair<>(root, 1));
        int i = 0;
        while(i < q.size()) {
            Pair<TreeNode, Integer> tmp = q.get(i++);
            TreeNode node = tmp.getKey();
            int code = tmp.getValue();
            if (node == null) continue;
            q.add(new Pair<>(node.left, 2 * code));
            q.add(new Pair<>(node.right, 2 * code + 1));
        }
        return q.get(i - 1).getValue() == q.size();
    }
    */
}
