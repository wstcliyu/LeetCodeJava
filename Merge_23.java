import javafx.util.Pair;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Merge_23 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {val = x;}
    }

    // Standard solution #1: Brute Force
    // Collect all the nodes together into an array and then sort them
    // Time: O(NlogN), Space: O(N)

    // Standard solution #2: Compare one by one (like merge two sorted list)
    // Time: O(kN)


    // Standard solution #3: Priority Queue
    // Time: O(N logk), k is size of lists array, N is number of total nodes
    // Space: O(N) for creating new linked list, O(k) for keeping priority queue
    /*
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> heap = new PriorityQueue<>(Comparator.<ListNode>comparingInt(n -> n.val));
        for (ListNode node : lists) if (node != null) heap.add(node);
        // heap.addAll(Arrays.asList(lists));
        // Because there may be null in lists, we cannot use addAll() to populate our heap
        ListNode dummy = new ListNode(0), p = dummy;
        while (!heap.isEmpty()) {
            ListNode node = heap.poll();
            p = p.next = node;
            if (node.next != null) heap.add(node.next);
        }
        return dummy.next;
    }
    */


    // Standard solution #4: Merge lists one by one (optimized by #5)
    // Time: O(kN)

    // Standard solution #5: Divide and Conquer
    // Time: O(N logk)
    public ListNode mergeKLists(ListNode[] lists) {
        return mergeKLists(lists, 0, lists.length - 1);
    }

    private ListNode mergeKLists(ListNode[] lists, int start, int end) {
        if (start > end) return null;
        if (start == end) return lists[start];
        int mid = (start + end) / 2;
        ListNode l1 = mergeKLists(lists, start, mid);
        ListNode l2 = mergeKLists(lists, mid + 1, end);
        return mergeTwoLists(l1, l2);
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0), p = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {p.next = l1; l1 = l1.next;}
            else {p.next = l2; l2 = l2.next;}
            p = p.next;
        }
        p.next = l1 == null ? l2 : l1;
        return dummy.next;
    }
}
