import java.util.*;

class Kth_668 {
    // My solution using binary search
    // similar with standard solution #3
    /*
    public int findKthNumber(int m, int n, int k) {
        int l = 1, r = m * n;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (count(m, n, mid) < k)
                l = mid + 1;
            else
                r = mid;
        }
        return l;
    }
    
    private int count(int m, int n, int target) {
        int res = 0;
        
        // My version
        // int j = 1;
        // for (int i = m; i >= 1; i--) {
        //     while (j <= n && i * j <= target) j++;
        //     res += j - 1;
        // }
        

        for (int i = 1; i <= m; i++)
            res += Math.min(n, target/m);
        return res;
    }
    */



    // Standard solution #2: Priority Queue
    class Node {
        int val, root;
        public Node(int v, int r) {
            val = v;
            root = r;
        }
    }

    public int findKthNumber(int m, int n, int k) {
        PriorityQueue<Node> heap = new PriorityQueue<Node>(m,
            Comparator.<Node> comparingInt(node -> node.val));

        for (int i = 1; i <= m; i++) {
            heap.offer(new Node(i, i));
        }

        Node node = null;
        for (int i = 0; i < k; i++) {
            node = heap.poll();
            int nxt = node.val + node.root;
            if (nxt <= node.root * n) {
                heap.offer(new Node(nxt, node.root));
            }
        }
        return node.val;
    }

    // Comparator<Point> cmp = Comparator.<Point> comparingInt(p -> p.x).thenComparingInt(p -> p.y);

    // Collections.sort(list, Comparator.comparingInt(Person::getAge));
    // Person is a class, list is a list of Person, getAge() is a getter method of class Person
}