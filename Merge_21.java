public class Merge_21 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        if (l1.val > l2.val)
            return mergeTwoLists(l2,l1);
        /* My first solution (Iterative)
        ListNode cur1 = l1;
        ListNode prev1 = null;
        while (cur1 != null || l2 != null) {
            if (l2 == null) {
                prev1 = cur1;
                cur1 = cur1.next;
            } else if (cur1 == null) {
                prev1.next = l2;
                prev1 = l2;
                l2 = l2.next;
                prev1.next = cur1;
            }
            else if (cur1.val <= l2.val) {
                prev1 = cur1;
                cur1 = cur1.next;
            }
            else {
                prev1.next = l2;
                prev1 = l2;
                l2 = l2.next;
                prev1.next = cur1;
            }
        }
        return l1;
        */
        // Recursive
        l1.next = mergeTwoLists(l1.next, l2);
        return l1;
        /* Better Iterative
        ListNode res = new ListNode(0);
        ListNode i = res;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                i.next = l1;
                l1 = l1.next;
            }
            else {
                i.next = l2;
                l2 = l2.next;
            }
            i = i.next;
        }
        if (l1 != null)
            i.next = l1;
        if (l2 != null)
            i.next = l2;
        return res.next;
        */
    }
}
