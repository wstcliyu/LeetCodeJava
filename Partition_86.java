public class Partition_86 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode partition(ListNode head, int x) {
        // Most voted solution using two Linked List
        ListNode node1 = new ListNode(0);
        ListNode node2 = new ListNode(0);
        ListNode p1 = node1;
        ListNode p2 = node2;
        while (head != null) {
            if (head.val < x)
                p1 = p1.next = head;
            else
                p2 = p2.next = head;
            head = head.next;
        }
        p2.next = null;
        p1.next = node2.next;
        return node1.next;
        /* My solution
        if (head == null)
            return null;
        ListNode prev = null;
        ListNode cur = head;
        while (cur.val < x) {
            prev = cur;
            cur = cur.next;
            // Avoid NullPointerException
            if (cur == null)
                return head;
        }
        ListNode i = cur;
        // Use (i.next != Null) because we need to connect i to i.next.next if i.next.val < x
        while (i.next != null) {
            if (i.next.val < x) {
                if (prev == null)
                    head = i.next;
                else
                    prev.next = i.next;
                prev = i.next;
                i.next = i.next.next;
                prev.next = cur;
            }
            else
                i = i.next;
        }
        return head;
        */
    }
}
