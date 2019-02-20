import java.util.Stack;

public class Add_445 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    // Use stack to reverse linkedlist
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }

        // Online solution
        /*
        int sum = 0;
        ListNode head = new ListNode(0);
        while (!s1.empty() || !s2.empty()) {
            if (!s1.empty()) sum += s1.pop();
            if (!s2.empty()) sum += s2.pop();
            head.val = sum % 10;
            sum /= 10;
            ListNode newHead = new ListNode(sum);
            newHead.next = head;
            head = newHead;
        }
        return head.val == 0 ? head.next : head;
        */


        // My version
        int sum = 0;
        ListNode dummy = new ListNode(0);
        while (!s1.empty() || !s2.empty() || sum > 0) {
            if (!s1.empty()) sum += s1.pop();
            if (!s2.empty()) sum += s2.pop();
            ListNode tmp = new ListNode(sum % 10);
            sum /= 10;
            tmp.next = dummy.next;
            dummy.next = tmp;
        }
        return dummy.next;
    }
}
