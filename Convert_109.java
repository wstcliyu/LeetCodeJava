public class Convert_109 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null)
            return null;
        return toBST(head, null);
    }

    private TreeNode toBST(ListNode head, ListNode tail) {
        if (head == tail)
            return null;
        ListNode slow = head;
        ListNode fast = head;
        TreeNode res;
        while (fast != tail) {
            fast = fast.next;
            if (fast == tail)
                break;
            else {
                fast = fast.next;
                slow = slow.next;
            }
        }
        res = new TreeNode(slow.val);
        res.left = toBST(head, slow);
        res.right = toBST(slow.next, tail);
        return res;
    }
}
