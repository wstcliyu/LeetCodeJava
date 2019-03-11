import java.util.ArrayDeque;
import java.util.Stack;

public class Daily_739 {
    public int[] dailyTemperatures(int[] T) {
        // My first solution using stack
        /*
        int[] res = new int[T.length];
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < T.length; i++) {
            while (!stack.isEmpty() && T[i] > T[stack.getLast()]) {
                int idx = stack.removeLast();
                res[idx] = i - idx;
            }
            stack.addLast(i);
        }
        return res;
        */
        

        // Most voted solution using array to approximate stack
        int[] stack = new int[T.length];
        int top = -1;
        int[] ret = new int[T.length];
        for(int i = 0; i < T.length; i++) {
            while(top > -1 && T[i] > T[stack[top]]) {
                int idx = stack[top--];
                ret[idx] = i - idx;
            }
            stack[++top] = i;
        }
        return ret;
    }
}
