public class Insertion_147 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    // Good submission, similar with mine, but better written and faster
    /*
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;

        while(head != null) {
            ListNode newHead = head.next;
            // important: optimize here
            if (prev.val > head.val) prev = dummy;
            while(prev.next != null && prev.next.val < head.val) prev = prev.next;
            head.next = prev.next;
            prev.next = head;
            head = newHead;
        }

        return dummy.next;
    }
    */
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode cur = head;
        while (cur != null) {
            ListNode nex = cur.next;
            dummy = helper(dummy, cur);
            cur = nex;
        }
        return dummy.next;
    }
    private ListNode helper(ListNode sorted, ListNode head) {
        ListNode p = sorted;
        while (p != null) {
            if (p.next == null || head.val < p.next.val) {
                head.next = p.next;
                p.next = head;
                break;
            }
            p = p.next;
        }
        return sorted;
    }
}
