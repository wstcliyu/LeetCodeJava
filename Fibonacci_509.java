public class Fibonacci_509 {
    // My solution using tail recursion
    // It can be easily converted to iteration
    public int fib(int N) {
        if (N == 0) return 0;
        return helper(0, 1, N);
    }

    private int helper(int a, int b, int N) {
        return N == 1 ? b : helper(b, a + b, N - 1);
    }
}
