public class Remove_19 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        /* Standard solution #1 (Two pass)
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = head;
        int length = 0;
        while (first != null) {
            length++;
            first = first.next;
        }
        first = dummy;
        for (int i=0; i<length-n; i++)
            first = first.next;
        first.next = first.next.next;
        return dummy.next;
        */

        // Standard solution #2 (One pass)
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        for (int i=0; i<n+1; i++)
            first = first.next;
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }
}
