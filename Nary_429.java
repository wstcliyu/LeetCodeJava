import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Nary_429 {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        LinkedList<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int len = q.size();
            for (int i=0; i<len; i++) {
                Node tmp = q.poll();
                level.add(tmp.val);
                q.addAll(tmp.children);
            }
            res.add(level);
        }
        return res;
    }
}
