public class MyCalendar_729 {
    int[] st;
    int[] ed;
    int bookCount;

    public MyCalendar_729() {
        st = new int[1000];
        ed = new int[1000];
        bookCount = 0;
    }

    public boolean book(int start, int end) {
        for (int i=0; i<bookCount; i++) {
            if (end>st[i] && start<ed[i])
                return false;
        }
        st[bookCount] = start;
        ed[bookCount++] = end;
        return true;
    }
}
/* Standard solution
 * TreeMap floorKey() ceilingKey()
class MyCalendar {
    TreeMap<Integer, Integer> calendar;

    MyCalendar() {
        calendar = new TreeMap();
    }

    public boolean book(int start, int end) {
        Integer prev = calendar.floorKey(start),
                next = calendar.ceilingKey(start);
        if ((prev == null || calendar.get(prev) <= start) &&
                (next == null || end <= next)) {
            calendar.put(start, end);
            return true;
        }
        return false;
    }
}
*/

/* Good Submission, but I think it is BST, not Segment Tree
class MyCalendar {

    private class SegmentTree {
        int start, end;
        SegmentTree left, right;
        public SegmentTree(int s, int e) {
            this.start = s;
            this.end = e;
        }
    }

    SegmentTree root;

    public MyCalendar() {
        root = new SegmentTree(-1, -1);
    }

    public boolean book(int start, int end) {
        if (start >= end) return false;
        if (root.left == null && root.right == null) {
            root.right = new SegmentTree(start, end);
            return true;
        }
        return check(root.right, start, end);
    }

    private boolean check(SegmentTree head, int start, int end) {
        if (end <= head.start) {
            if (head.left == null) {
                head.left = new SegmentTree(start, end);
                return true;
            } else {
                return check(head.left, start, end);
            }
        } else if (start < head.end) {
            return false;
        } else {
            if (head.right == null) {
                head.right = new SegmentTree(start, end);
                return true;
            } else {
                return check(head.right, start, end);
            }
        }
    }
}
*/
