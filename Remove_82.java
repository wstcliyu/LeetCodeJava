public class Remove_82 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode deleteDuplicates(ListNode head) {
        // Most voted solution, much cleaner than mine
        /*
        if(head==null) return null;
        ListNode FakeHead=new ListNode(0);
        FakeHead.next=head;
        ListNode pre=FakeHead;
        ListNode cur=head;
        while(cur!=null){
            while(cur.next!=null&&cur.val==cur.next.val){
                cur=cur.next;
            }
            if(pre.next==cur){
                pre=pre.next;
            }
            else{
                pre.next=cur.next;
            }
            cur=cur.next;
        }
        return FakeHead.next;
        */

        // My solution
        if (head == null || head.next == null)
            return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy, cur = head, nex = head.next;
        Integer duplicate = null;
        while (cur != null) {
            if (nex == null) {
                if (duplicate != null)
                    pre.next = null;
                break;
            }
            else if (cur.val == nex.val) {
                duplicate = cur.val;
                cur = cur.next;
                nex = nex.next;
            }
            else {
                if (duplicate == null) {
                    pre = pre.next;
                    cur = cur.next;
                    nex = nex.next;
                }
                else {
                    pre.next = nex;
                    cur = nex;
                    nex = nex.next;
                    duplicate = null;
                }
            }
        }
        return dummy.next;
    }
}
