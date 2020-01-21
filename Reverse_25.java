class Solution {
    // Rewrite second voted solution (iteration)
    // https://leetcode.com/problems/reverse-nodes-in-k-group/discuss/11440/Non-recursive-Java-solution-and-idea
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k == 1) return head;
        ListNode dummy = new ListNode(0);
        ListNode begin = dummy;
        dummy.next = head;
        for (int i = 1; head != null; i++) {
            head = head.next;
            if (i % k == 0) {
                begin = reverse(begin, head);
            }
        }
        return dummy.next;
    }
    
    private ListNode reverse(ListNode begin, ListNode end) {
        ListNode head = begin.next;
        ListNode newBegin = head;
        ListNode tail = end;
        while (head != end) {
            ListNode next = head.next;
            head.next = tail;
            tail = head;
            head = next;
        }
        begin.next = tail;
        return newBegin;
    }
}