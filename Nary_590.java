import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;

public class Nary_590 {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
    public List<Integer> postorder(Node root) {
        LinkedList<Integer> res = new LinkedList<>();
        ArrayDeque<Node> stack = new ArrayDeque<>();
        if (root == null)
            return res;
        stack.push(root);
        while (!stack.isEmpty()) {
            Node p = stack.pop();
            res.addFirst(p.val);
            for (int i=0; i<p.children.size(); i++)
                stack.push(p.children.get(i));
        }
        return res;
    }
}
