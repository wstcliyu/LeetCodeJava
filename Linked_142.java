public class Linked_142 {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public ListNode detectCycle(ListNode head) {
        ListNode first = head;
        ListNode second = head;
        while (first != null) {
            // Avoid NullPointerException
            first = first.next;
            if (first == null)
                return null;
            first = first.next;
            if (first == null)
                return null;
            second = second.next;
            if (first == second)
                break;
        }
        first = head;
        while (first != second) {
            first = first.next;
            second = second.next;
        }
        return first;
    }
}
