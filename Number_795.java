public class Number_795 {
    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        // Use count to store the number of subarrays ending in A[i]
        // Use j to store the last index such that A[index]>R
        int res = 0, count = 0, j = -1;
        for (int i=0; i<A.length; i++) {
            if (A[i] > R) {
                j = i;
                count = 0;
            }
            else if (A[i] >= L)
                count = i - j;
            res += count;
        }
        return res;
    }
}
