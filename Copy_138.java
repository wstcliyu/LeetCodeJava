import java.util.HashMap;

public class Copy_138 {
    class RandomListNode {
        int label;
        RandomListNode next, random;
        RandomListNode(int x) { this.label = x; }
    }
    /* My solution using HashMap and recursion
    private static HashMap<RandomListNode, RandomListNode> tmp = new HashMap<>();
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null)
            return null;
        RandomListNode res = new RandomListNode(head.label);
        tmp.put(head, res);
        res.next = copyRandomList(head.next);
        res.random = tmp.getOrDefault(head.random, null);
        return res;
    }
    */

    /* Online solution using HashMap and recursion
    public RandomListNode copyRandomList(RandomListNode head) {
        return helper(head, new HashMap<>());
    }
    private RandomListNode helper(RandomListNode node, HashMap<RandomListNode, RandomListNode> map) {
        if (node == null)
            return null;
        if (map.containsKey(node))
            return map.get(node);
        RandomListNode newNode = new RandomListNode(node.label);
        map.put(node, newNode);
        newNode.next = helper(node.next, map);
        newNode.random = helper(node.random, map);
        return newNode;
    }
    */

    /* Most voted solution without HashMap and recursion
       Time O(n) Space O(1)
       1 Iterate the original list and duplicate each node. The duplicate
         of each node follows its original immediately.
       2 Iterate the new list and assign the random pointer for each
         duplicated node.
       3 Restore the original list and extract the duplicated nodes.
    */
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null)
            return null;
        // First round: make copy of each node,
	    // and link them together side-by-side in a single list.
        RandomListNode iter = head;
        while (iter != null) {
            RandomListNode next = iter.next;
            iter.next = new RandomListNode(iter.label);
            iter.next.next = next;
            iter = next;
        }
        // Second round: assign random pointers for the copy nodes.
        iter = head;
        while (iter != null) {
            if (iter.random != null)
                iter.next.random = iter.random.next;
            iter = iter.next.next;
        }
        // Third round: restore the original list, and extract the copy list.
        iter = head;
        RandomListNode newHead = head.next;
        RandomListNode newIter = newHead;
        while (true) {
            iter.next = iter.next.next;
            iter = iter.next;
            if (iter == null)
                break;
            newIter.next = newIter.next.next;
            newIter = newIter.next;
        }
        return newHead;
    }
}
