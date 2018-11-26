import java.util.HashSet;
import java.util.Stack;

public class Validate_946 {
    // Standard solution, similar with mine
    /*
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int N = pushed.length;
        Stack<Integer> stack = new Stack();
        int j = 0;
        for (int x: pushed) {
            stack.push(x);
            while (!stack.isEmpty() && j < N && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }
        }
        return j == N;
    }
    */


    // My solution
    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        int N = popped.length;
        if (N < 2) return true;
        HashSet<Integer> set = new HashSet<>();
        Stack<Integer> st = new Stack<>();
        int i = 0, j = 0;
        while (i < N || j < N) {
            if (i < N) {
                set.add(pushed[i]);
                st.push(pushed[i++]);
            }
            // Note: Must use while loop here
            // the testcase in the following main method won't pass using if
            while (j < N && set.contains(popped[j])) {
                if (st.peek() == popped[j]) {
                    j++;
                    st.pop();
                }
                else
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] testPush = {2, 1, 0};
        int[] testPop = {1, 2, 0};
        System.out.println(validateStackSequences(testPush, testPop));
    }
}
