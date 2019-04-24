import java.util.*;

class Monotone_738 {
    // My first solution (similar to standard solutionn #2)
    // Time: O(lg N), Space: O(lg N)
    public int monotoneIncreasingDigits(int N) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (; N > 0; N /= 10) stack.add(N % 10);
        
        int n = stack.size();
        int[] digits = new int[n];
        int i = 0;
        for (; i < n; i++) {
            if (i == 0 || digits[i - 1] <= stack.getLast())
                digits[i] = stack.removeLast();
            else
                break;
        }
        
        if (i < n) {
            i--;
            for (; i >= 0; i--) {
                --digits[i];
                if (i == 0 || digits[i] >= digits[i - 1]) break;
            }
        }
        
        int res = 0;
        for (int j = 0; j < n; j++)
            res = res * 10 + (j <= i ? digits[j] : 9);
        return res;
    }
}