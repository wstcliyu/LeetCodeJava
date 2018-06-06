public class AddTwo_2 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // My solution using helper and recursion
        return helper(l1,l2,0);
        /* Standard solution using iteration
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
        */
    }
    private ListNode helper(ListNode l1, ListNode l2, int carry) {
        if (l1 == null && l2 == null && carry == 0)
            return null;
        int val1 = l1==null ? 0 : l1.val;
        int val2 = l2==null ? 0 : l2.val;
        ListNode next1 = l1==null ? null : l1.next;
        ListNode next2 = l2==null ? null : l2.next;
        ListNode res = new ListNode((val1+val2+carry)%10);
        res.next = helper(next1, next2, (val1+val2+carry)/10);
        return res;
    }
}
