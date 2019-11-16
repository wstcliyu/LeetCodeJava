class MyCalendar_731 {
    // Third voted solution: Segment Tree with lazy propagation (general case of K-booking)
    // https://leetcode.com/problems/my-calendar-ii/discuss/109528/nlogd-Java-solution-using-segment-tree-with-lazy-propagation-(for-the-general-case-of-K-booking)
    SegmentTreeNode root;

    public MyCalendarTwo() {
        root = new SegmentTreeNode(0, 1_000_000_000, 0);
    }
    
    public boolean book(int start, int end) {
        if (query(root, start, end - 1) >= 2) return false;
        update(root, start, end - 1, 1);
        return true;
    }
    
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



    // Standard solution #2: TreeMap
    /*
    TreeMap<Integer, Integer> map;

    public MyCalendar_731() {
        map = new TreeMap<>();
    }
    
    public boolean book(int start, int end) {
        map.put(start, map.getOrDefault(start, 0) + 1);
        map.put(end, map.getOrDefault(end, 0) - 1);
        int active = 0;
        for (int d : map.values()) {
            active += d;
            if (active > 2) {
                map.put(start, map.get(start) - 1);
                map.put(end, map.get(end) + 1);
                map.remove(start, 0);
                map.remove(end, 0);
                return false;
            }
        }
        return true;
    }
    */



    // Standard solution #1: Brute Force
    /*
    List<int[]> calendar;
    List<int[]> overlaps;

    public MyCalendarTwo() {
        calendar = new ArrayList<>();
        overlaps = new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        for (int[] iv : overlaps) {
            if (iv[0] < end && start < iv[1]) return false;
        }
        for (int[] iv : calendar) {
            if (iv[0] < end && start < iv[1]) {
                overlaps.add(new int[]{Math.max(start, iv[0]), Math.min(end, iv[1])});
            }
        }
        calendar.add(new int[]{start, end});
        return true;
    }
    */
}