public class Rotate_396 {
    public int maxRotateFunction(int[] A) {
        // Time O(n) Space O(1)
        int sum = 0, f = 0;
        int n = A.length;
        for (int i=0; i<n; i++) {
            sum += A[i];
            f += i * A[i];
        }
        int res = f;
        for (int i=n-1; i>=0; i--) {
            f += sum - n*A[i];
            res = Math.max(res, f);
        }
        return res;
    }
}
