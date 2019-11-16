public class Global_775 {
    // Standard solution #2 (from lee215)
    public boolean isIdealPermutation(int[] A) {
        int max = 0;
        for (int i = 2; i < A.length; i++) {
            max = Math.max(max, A[i-2]);
            if (max > A[i]) return false;
        }
        return true;
    }



    // Most voted solution (very tricky)
    // https://leetcode.com/problems/global-and-local-inversions/discuss/113656/My-3-lines-C%2B%2B-Solution
    // If A[i] > i + 1, means at least one number that is smaller than A[i] is kicked out from first A[i] numbers, and the distance between this smaller number and A[i] is at least 2, then it is a non-local global inversion.
    // For example, A[i] = 3, i = 1, at least one number that is smaller than 3 is kicked out from first 3 numbers, and the distance between the smaller number and 3 is at least 2.
    // If A[i] < i - 1, means at least one number that is bigger than A[i] is kicked out from last n - i numbers, and the distance between this bigger number and A[i] is at least 2, then it is a non-local global inversion.
    /*
    public boolean isIdealPermutation(int[] A) {
        for (int i = 0; i < A.length; ++i)
            if (Math.abs(A[i] - i) > 1)
                return false;
        return true;
    }
    */
}
