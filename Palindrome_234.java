public class Palindrome_234 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode cur = head;
        ListNode prev = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev; // set cur.next
            prev = cur; // move prev to cur
            cur = next; // move cur to next
        }
        return prev;
    }
    public static boolean isPalindrome(ListNode head) {
        // Use two pointers to find the middle node
        // Reverse the second half and compare with the first half
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast != null)
            slow = slow.next;
        slow = reverseList(slow);
        while (slow != null) {
            if (slow.val != head.val)
                return false;
            slow = slow.next;
            head = head.next;
        }
        return true;
    }
}
