public class Merge_21 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    // Recursive
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val > l2.val) return mergeTwoLists(l2,l1);
        l1.next = mergeTwoLists(l1.next, l2);
        return l1;
    }


    // Iterative using dummy head
    /*
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0), p = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {p.next = l1; l1 = l1.next;}
            else {p.next = l2; l2 = l2.next;}
            p = p.next;
        }
        p.next = l1 == null ? l2 : l1;
        return dummy.next;
    }
    */
}
