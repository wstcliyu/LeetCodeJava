public class Reverse_206 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
    // My new solution inspired by Partition_86
    // This method is like create a new linked list (actually it's not)
    /*
    public ListNode reverseList(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = dummy.next;
            dummy.next = cur;
            cur = next;
        }
        return dummy.next;
    }
    */


    // Recursive
    /*
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
    */


    // Iterative
    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode cur = head;
        ListNode prev = null;
        while (cur != null) {
            // save cur.next before we set cur.nex=prev
            ListNode next = cur.next;
            cur.next = prev; // set cur.next
            prev = cur; // move prev to cur
            cur = next; // move cur to next
        }
        // Now cur==null, prev is the first node
        return prev;
    }
    public static void main (String args[]) {
        ListNode testNode = new ListNode(1);
        testNode.next = new ListNode(2);
        System.out.println(testNode.val);
        ListNode testReverse = reverseList(testNode);
        System.out.println(testReverse.val);
    }
}
