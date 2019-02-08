import java.awt.*;
import java.util.Arrays;
import java.util.Comparator;

public class Maximum_962 {
    // My solution is similar with standard solution #2: binary search
    // Time: O(N lgN), Space: O(N)
    public int maxWidthRamp(int[] A) {
        int res = 0, size = 1, N = A.length;
        Point[] q = new Point[N];
        q[0] = new Point(N-1, A[N-1]);
        for (int i = N - 2; i >= 0; i--) {
            if (q[size-1].y < A[i]) q[size++] = new Point(i, A[i]);
            else {
                int pos = Arrays.binarySearch(q, 0, size, new Point(i, A[i]), Comparator.comparing(p -> p.y));
                int j = pos < 0 ? q[-pos-1].x : q[pos].x;
                res = Math.max(res, j - i);
            }
        }
        return res;
    }


    // Standard solution #1: Sort
    // Time: O(N lgN), Space: O(N)
    /*
    public int maxWidthRamp(int[] A) {
        int res = 0, N = A.length;
        Integer[] B = new Integer[N];
        for (int i = 0; i < N; i++) B[i] = i;
        Arrays.sort(B, Comparator.comparing(b -> A[b]));
        int i = Integer.MAX_VALUE;
        for (int j : B) {
            res = Math.max(res, j - i);
            i = Math.min(i, j);
        }
        return res;
    }
    */
}
