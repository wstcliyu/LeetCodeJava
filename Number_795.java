public class Number_795 {
    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        // Use count to store the number of subarrays (which meet requirement) ending in A[i]
        // Use j to store the last index such that A[index]>R
        int res = 0, count = 0, j = -1;
        for (int i = 0; i < A.length; i++) {
            if (A[i] > R) {
                j = i;
                count = 0;
            } else if (A[i] >= L) {
                count = i - j;
            }
            res += count;
        }
        return res;
    }



    // Standard solution
    /*
    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        return count(A, R) - count(A, L-1);
    }

    public int count(int[] A, int bound) {
        int ans = 0, cur = 0;
        for (int x: A) {
            cur = x <= bound ? cur + 1 : 0;
            ans += cur;
        }
        return ans;
    }
    */
}
