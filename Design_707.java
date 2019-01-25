public class Design_707 {
    // My solution using DL-List
    int size;
    Node head, tail;

    class Node {
        int val;
        Node next, prev;
        Node() {}
        Node(int _val, Node _next, Node _prev) {
            this.val = _val;
            this.next = _next;
            this.prev = _prev;
        }
    }

    /** Initialize your data structure here. */
    public Design_707() {
        size = 0;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (index >= size) return -1;
        Node p = head;
        while (index-- > 0) p = p.next;
        return p.next.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node p = new Node(val, head.next, head);
        head.next.prev = p;
        head.next = p;
        size++;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        Node p = new Node(val, tail, tail.prev);
        tail.prev.next = p;
        tail.prev = p;
        size++;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index > size) return;
        Node p = head;
        while (index-- > 0) p = p.next;
        Node n = new Node(val, p.next, p);
        p.next.prev = n;
        p.next = n;
        size++;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index >= size) return;
        Node p = head;
        while (index-- > 0) p = p.next;
        p.next = p.next.next;
        p.next.prev = p;
        size--;
    }
}
