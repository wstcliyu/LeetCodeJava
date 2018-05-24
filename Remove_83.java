public class Remove_83 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
    public static ListNode deleteDuplicates(ListNode head) {
        if (head==null || head.next==null)
            return head;
        ListNode prev = head;
        ListNode cur = head.next;
        while (cur != null) {
            while (cur != null && cur.val == prev.val)
                cur = cur.next;
            prev.next = cur;
            prev = cur;
            cur = cur != null ? cur.next : cur;
        }
        return head;
    }
}
