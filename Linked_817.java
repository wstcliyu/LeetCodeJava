import java.util.HashSet;

public class Linked_817 {
    public class ListNode {
       int val;
       ListNode next;
       ListNode(int x) { val = x; }
  }
    public int numComponents(ListNode head, int[] G) {
        if (head == null)
            return 0;
        HashSet<Integer> tmp = new HashSet<>();
        for (int g:G)
            tmp.add(g);
        int res = 0;
        while (head != null) {
            if (tmp.contains(head.val) && (head.next == null || !tmp.contains(head.next.val)))
                res++;
            head = head.next;
        }
        return res;
    }
}
