class Clone_133 {
    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {}

        public Node(int _val,List<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    // DFS
    /*
    Map<Node, Node> map = new HashMap<>();
    
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        if (map.containsKey(node)) return map.get(node);
        Node res = new Node(node.val, new ArrayList<>());
        map.put(node, res);
        for (Node n : node.neighbors) {
            res.neighbors.add(cloneGraph(n));
        }
        return res;
    }
    */



    // BFS
    Map<Node, Node> map = new HashMap<>();
    
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        Deque<Node> queue = new ArrayDeque<>();

        queue.add(node);
        Node res = new Node(node.val, new ArrayList<>());
        map.put(node, res);
        
        while (!queue.isEmpty()) {
            Node n = queue.removeFirst();
            Node ncopy = map.get(n);
            for (Node neighbor : n.neighbors) {
                if (!map.containsKey(neighbor)) {
                    queue.add(neighbor);
                    Node neighbor_copy = new Node(neighbor.val, new ArrayList<>());
                    map.put(neighbor, neighbor_copy);
                }
                ncopy.neighbors.add(map.get(neighbor));
            }
        }
        return res;
    }
}