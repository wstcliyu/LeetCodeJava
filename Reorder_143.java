public class Reorder_143 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    // Most voted solution, similar as mine
    /*
    public void reorderList(ListNode head) {
        if(head==null||head.next==null) return;

        //Find the middle of the list
        ListNode p1=head;
        ListNode p2=head;
        while(p2.next!=null&&p2.next.next!=null){
            p1=p1.next;
            p2=p2.next.next;
        }

        //Reverse the half after middle  1->2->3->4->5->6 to 1->2->3->6->5->4
        ListNode preMiddle=p1;
        ListNode preCurrent=p1.next;
        while(preCurrent.next!=null){
            ListNode current=preCurrent.next;
            preCurrent.next=current.next;
            current.next=preMiddle.next;
            preMiddle.next=current;
        }

        //Start reorder one by one  1->2->3->6->5->4 to 1->6->2->5->3->4
        p1=head;
        p2=preMiddle.next;
        while(p1!=preMiddle){
            preMiddle.next=p2.next;
            p2.next=p1.next;
            p1.next=p2;
            p1=p2.next;
            p2=preMiddle.next;
        }
    }
    */
    public void reorderList(ListNode head) {
        if (head==null || head.next==null || head.next.next==null)
            return;
        ListNode fast = head, slow = head, cur1 = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next;
            fast = fast.next;
        }
        ListNode secondHalf = slow.next;
        slow.next = null;
        ListNode cur2 = reverseList_143(secondHalf);
        while (cur2 != null) {
            ListNode nex2 = cur2.next;
            cur2.next = cur1.next;
            cur1.next = cur2;
            cur1 = cur2.next;
            cur2 = nex2;
        }
    }
    private ListNode reverseList_143(ListNode head) {
        ListNode pre = null, cur = head;
        while (cur != null) {
            ListNode nex = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nex;
        }
        return pre;
    }
    public static void main (String args[]) {
        Reorder_143 testClass = new Reorder_143();
        ListNode p1 = testClass.new ListNode(1);
        ListNode p2 = testClass.new ListNode(2);
        ListNode p3 = testClass.new ListNode(3);
        ListNode p4 = testClass.new ListNode(4);
        p1.next = p2;
        p2.next = p3;
        p3.next = p4;
        testClass.reorderList(p1);
        while (p1 != null) {
            System.out.print(p1.val + " ");
            p1 = p1.next;
        }
    }
}
