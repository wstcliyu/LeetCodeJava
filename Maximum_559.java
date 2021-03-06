import java.util.List;

public class Maximum_559 {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    // Just like Leetcode 104
    public int maxDepth(Node root) {
        if (root == null)
            return 0;
        int res = 0;
        for (Node n : root.children)
            res = Math.max(res, maxDepth(n));
        return 1 + res;
    }
}
