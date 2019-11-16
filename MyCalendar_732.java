class MyCalendar_732 {
    // Standard solution: TreeMap
    // Time: O(N^2), N is the number of calls to book() method
    /*
    TreeMap<Integer, Integer> delta;

    public MyCalendarThree() {
        delta = new TreeMap();
    }

    public int book(int start, int end) {
        delta.put(start, delta.getOrDefault(start, 0) + 1);
        delta.put(end, delta.getOrDefault(end, 0) - 1);

        int active = 0, ans = 0;
        for (int d: delta.values()) {
            active += d;
            if (active > ans) ans = active;
        }
        return ans;
    }
    */



    // Refer to MyCalendar_731
    // Time: O(Nlgd), d is the range (in this case d = 1_000_000_000), N is the number of calls to book() method
    SegmentTreeNode root;

    public MyCalendarThree() {
        root = new SegmentTreeNode(0, 1_000_000_000, 0);
    }
    
    public int book(int start, int end) {
        update(root, start, end - 1, 1);
        return root.k;
    }
    
    // No need to query in this problem
    private int query(SegmentTreeNode node, int i, int j) {
        if (i > j || node == null || i > node.r || j < node.l) return 0;
        if (i <= node.l && j >= node.r) return node.k;
        normalize(node);
        return Math.max(query(node.left, i, j), query(node.right, i, j));
    }
    
    private void update(SegmentTreeNode node, int i, int j, int val) {
        if (i > j || node == null || i > node.r || j < node.l) return;
        if (i <= node.l && j >= node.r) {
            node.k += val;
            node.lazy += val;
            return;
        }
        normalize(node);
        update(node.left, i, j, val);
        update(node.right, i, j, val);
        node.k = Math.max(node.left.k, node.right.k);
    }
    
    private void normalize(SegmentTreeNode node) {
        if (node.l < node.r) {
            if (node.left == null || node.right == null) {
                int m = node.l + (node.r - node.l) / 2;
                node.left = new SegmentTreeNode(node.l, m, node.k);
                node.right = new SegmentTreeNode(m + 1, node.r, node.k);
            } else {
                node.left.k += node.lazy;
                node.left.lazy += node.lazy;
                node.right.k += node.lazy;
                node.right.lazy += node.lazy;
            }
        }
        node.lazy = 0;
    }
    
    class SegmentTreeNode {
        int l, r;
        int k, lazy;
        SegmentTreeNode left, right;
        SegmentTreeNode(int l, int r, int k) {
            this.l = l;
            this.r = r;
            this.k = k;
            this.lazy = 0;
            this.left = this.right = null;
        }
    }
}