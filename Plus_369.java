import java.util.ArrayDeque;
import java.util.Deque;

class PLus_369 {
    // My solution using stack
    public ListNode plusOne(ListNode head) {
        ListNode p = head;
        Deque<ListNode> stack = new ArrayDeque<>();
        while (p != null) {
            stack.addLast(p);
            p = p.next;
        }
        int carry = 0;
        do {
            ListNode node = stack.removeLast();
            carry = (node.val + 1) / 10;
            node.val = (node.val + 1) % 10;
        } while (carry > 0 && !stack.isEmpty());
        
        if (carry == 0) return head;
        
        ListNode newHead = new ListNode(1);
        newHead.next = head;
        return newHead;
    }
}