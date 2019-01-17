public class NRepeated_961 {
    // https://leetcode.com/problems/n-repeated-element-in-size-2n-array/discuss/208563/JavaC%2B%2BPython-O(1)-Solution
    // Most voted solution
    /*
    public int repeatedNTimes(int[] A) {
        for (int i = 2; i < A.length; ++i)
            if (A[i] == A[i - 1] || A[i] == A[i - 2])
                return A[i];
        return A[0];
    }
    */

    public int repeatedNTimes(int[] A) {
        int i = 0, j = 0, n = A.length;
        while (i == j || A[i] != A[j]) {
            i = (int)(Math.random() * n);
            j = (int)(Math.random() * n);
        }
        return A[i];
    }
}
