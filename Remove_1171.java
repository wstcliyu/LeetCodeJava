import java.util.HashMap;

class Remove_1171 {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    // Most voted solution from lee215: prefix sum hashmap
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int sum = 0;
        HashMap<Integer, ListNode> map = new HashMap<>();
        map.put(0, dummy);
        ListNode cur = head;
        while (cur != null) {
            sum += cur.val;
            if (map.containsKey(sum)) {
                ListNode prev = map.get(sum);
                ListNode node = prev.next;
                int tmp = sum;
                while (node != cur) {
                    tmp += node.val;
                    map.remove(tmp);
                    node = node.next;
                }
                prev.next = cur.next;
            } else {
                map.put(sum, cur);
            }
            cur = cur.next;
        }
        return dummy.next;
    }
}