public class Rotate_61 {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode rotateRight(ListNode head, int k) {
        // My solution same as most voted
        if (head == null)
            return null;
        int length = 1;
        ListNode p1 = head;
        ListNode p2 = head;
        while (p1.next != null) {
            p1 = p1.next;
            length++;
        }
        p1.next = head;
        k %= length;
        for (int i=0; i<length-k-1; i++)
            p2 = p2.next;
        head = p2.next;
        p2.next = null;
        return head;
    }
}
