public class LinkedListCycle_141 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
    public static boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            if (slow == fast)
                return true;
        }
        return false;
    }
    public static void main (String args[]) {
        ListNode testNode = new ListNode(1);
        testNode.next = new ListNode(2);
        System.out.println(testNode.val);
        System.out.println(hasCycle(testNode));
    }
}
