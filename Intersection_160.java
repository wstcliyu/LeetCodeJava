public class Intersection_160 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA, b = headB;
        while (a != null || b != null) {
            if (a != null && a == b) return a;
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        return null;
    }
}