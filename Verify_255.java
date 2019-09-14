import java.util.ArrayDeque;
import java.util.Deque;

class Verify_255 {
    // Most voted solution #1 from StefanPochman: Stack
    // Space: O(N)
    public boolean verifyPreorder(int[] preorder) {
        int low = Integer.MIN_VALUE;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int p : preorder) {
            if (p < low) return false;
            while (!stack.isEmpty() && p > stack.peek())
                low = stack.pop();
            stack.push(p);
        }
        return true;
    }



    // Most voted solution #1 from StefanPochman: Abuse the given array for the stack
    // Space: O(1)
    /*
    public boolean verifyPreorder(int[] preorder) {
        int low = Integer.MIN_VALUE;
        int size = 0;
        for (int p : preorder) {
            if (p < low) return false;
            while (size > 0 && p > preorder[size - 1])
                low = preorder[size-- - 1];
            preorder[size++] = p;
        }
        return true;
    }
    */
}