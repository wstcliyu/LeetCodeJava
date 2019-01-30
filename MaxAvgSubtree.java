import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxAvgSubtree {
    // Amazon OA 2: Maximum Average Subtree

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    private Node res;
    private Pair<Integer, Integer> bestPair;

    public Node maxAvgNode(Node root) {
        helper(root);
        return res;
    }

    private Pair<Integer, Integer> helper(Node root) {
        if (root.children == null || root.children.size() == 0) return new Pair<>(root.val, 1);
        int sum = 0, size = 1;
        for (Node child : root.children) {
            Pair<Integer, Integer> pair = helper(child);
            sum += pair.getKey();
            size += pair.getValue();
        }
        Pair<Integer, Integer> cur = new Pair<>(sum, size);
        if (bestPair == null || bestPair.getKey() * size < bestPair.getValue() * sum) {
            bestPair = cur;
            res = root;
        }
        return cur;
    }

    public static void main(String[] args) {
        MaxAvgSubtree test = new MaxAvgSubtree();
        Node node_110 = test.new Node(110, null);
        Node node_20 = test.new Node(20, null);
        Node node_30 = test.new Node(30, null);
        Node node_150 = test.new Node(150, null);
        Node node_80 = test.new Node(80, null);
        Node node_120 = test.new Node(110, Arrays.asList(node_110, node_20, node_30));
        Node node_180 = test.new Node(180, Arrays.asList(node_150, node_80));
        Node node_200 = test.new Node(200, Arrays.asList(node_120, node_180));
        System.out.println(test.maxAvgNode(node_200).val);
    }
}
