public class Flatten_430 {
    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node() {}

        public Node(int _val,Node _prev,Node _next,Node _child) {
            val = _val;
            prev = _prev;
            next = _next;
            child = _child;
        }
    }

    // My solution using recursion
    public Node flatten(Node head) {
        Node p = head;
        while (p != null) {
            Node next = p.next;
            if (p.child != null) {
                Node childStart = flatten(p.child);
                Node childEnd = getTail(childStart);
                p.next = childStart;
                childStart.prev = p;
                childEnd.next = next;
                if (next != null) next.prev = childEnd;
                p.child = null;
            }
            p = next;
        }
        return head;
    }

    private Node getTail(Node head) {
        while (head.next != null) head = head.next;
        return head;
    }


    // Iteration
    /*
    public Node flatten(Node head) {
        if(head == null) return head;
        Node p = head;
        while(p != null) {
            if (p.child == null) {
                p = p.next;
                continue;
            }

            Node end = p.child;
            while(end.next != null) end = end.next;
            end.next = p.next;
            if(p.next != null)  p.next.prev = end;
            p.next = p.child;
            p.child.prev = p;
            p.child = null;
        }
        return head;
    }
    */
}
