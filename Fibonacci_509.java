public class Fibonacci_509 {
	// My solution: matrix multiplication (using fast exponentiation)
	public int fib(int N) {
        if (N == 0) return 0;
        int[][] A = {{1, 1}, {1, 0}};
        return fastExp(A, N - 1)[0][0];
    }
    
    private int[][] fastExp(int[][] A, int n) {
        int[][] R = {{1, 0}, {0, 1}};
        int[][] B = A;
        while (n > 0) {
            if (n % 2 == 1)
                R = multiply(B, R);
            B = multiply(B, B);
            n >>= 1;
        }
        return R;
    }
    
    private int[][] multiply(int[][] A, int[][] B) {
        int x = A[0][0] * B[0][0] + A[0][1] * B[1][0];
        int y = A[0][0] * B[0][1] + A[0][1] * B[1][1];
        int z = A[1][0] * B[0][0] + A[1][1] * B[1][0];
        int w = A[1][0] * B[0][1] + A[1][1] * B[1][1];
        int[][] C = new int[2][2];
        

        C[0][0] = x;
        C[0][1] = y;
        C[1][0] = z;
        C[1][1] = w;
        return C;
    }



    // My solution: iteration
    /*
    public int fib(int N) {
        if (N == 0) return 0;
        int a = 0, b = 1;
        for (int i = 1; i < N; i++) {
            int tmp = b;
            b = a + b;
            a = tmp;
        }
        return b;
    }
    */



    // My solution: tail recursion (No tail recursion in Java)
    // It can be easily converted to iteration
    /*
    public int fib(int N) {
        if (N == 0) return 0;
        return helper(0, 1, N);
    }

    private int helper(int a, int b, int N) {
        return N == 1 ? b : helper(b, a + b, N - 1);
    }
    */
}
