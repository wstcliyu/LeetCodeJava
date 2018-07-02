public class Split_725 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] res = new ListNode[k];
        if (root == null)
            return res;
        ListNode cur = root;
        int N = 0;
        while (cur != null) {
            cur = cur.next;
            N++;
        }
        int width, rem = N % k;
        cur = root;
        for (int i=0; i<k; i++) {
            res[i] = cur;
            width = i<rem ? N/k+1 : N/k;
            for (int j=0; j<width; j++)
                if (j == width-1) {
                    ListNode tmp = cur.next;
                    cur.next = null;
                    cur = tmp;
                }
                else
                    cur = cur.next;
        }
        return res;
    }
}
