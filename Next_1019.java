import java.awt.Point;
import java.util.Deque;
import java.util.ArrayDeque;

class Next_1019 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public int[] nextLargerNodes(ListNode head) {
        if (head == null) return new int[0];
        ListNode p = head;
        int N = 0;
        while (p != null) {
            p = p.next;
            N++;
        }
        
        int[] res = new int[N];
        int i = 0;
        Deque<Point> deque = new ArrayDeque<>();
        p = head;
        while (p != null) {
            while (!deque.isEmpty() && deque.getLast().y < p.val) {
                res[deque.removeLast().x] = p.val;
            }
            deque.add(new Point(i++, p.val));
            p = p.next;
        }
        
        return res;
    }
}