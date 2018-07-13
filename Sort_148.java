public class Sort_148 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode slow = head;
        ListNode slowPrev = null;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slowPrev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        slowPrev.next = null;

        return merge(sortList(head), sortList(slow));
    }

    public ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while (left != null && right != null) {
            if (left.val < right.val) {
                curr.next = left;
                left = left.next;
            }
            else {
                curr.next = right;
                right = right.next;
            }
            curr = curr.next;
        }
        curr.next = left == null ? right : left;
        return dummy.next;
    }
}
