import java.util.Stack;

interface ImmutableListNode {
    public void printValue();
    public ImmutableListNode getNext();
}

class Print_1265 {
    // Time: O(N)
    // Space: O(sqrt(N))
    public void printLinkedListInReverse(ImmutableListNode head) {
        int count = getCount(head);
        Stack<ImmutableListNode> stack = getHeadStack(head, count);
        ImmutableListNode tail = null;
        while (!stack.isEmpty()) {
            printInReverse(stack.peek(), tail);
            tail = stack.pop();
        }
    }
    
    private int getCount(ImmutableListNode head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.getNext();
        }
        return count;
    }
    
    private Stack<ImmutableListNode> getHeadStack(ImmutableListNode head, int count) {
        int size = (int)Math.ceil(Math.sqrt(count));
        Stack<ImmutableListNode> stack = new Stack<>();
        for (int i = 0; i < count; i++) {
            if (i % size == 0) {
                stack.push(head);
            }
            head = head.getNext();
        }
        return stack;
    }
    
    private void printInReverse(ImmutableListNode head, ImmutableListNode tail) {
        Stack<ImmutableListNode> st = new Stack<>();
        while (head != tail) {
            st.push(head);
            head = head.getNext();
        }
        while (!st.isEmpty()) {
            st.pop().printValue();
        }
    }
}