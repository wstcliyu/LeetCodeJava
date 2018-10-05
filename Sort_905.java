public class Sort_905 {
    public int[] sortArrayByParity(int[] A) {
        // In-place Swap, different from my thought
        /*
        for (int i = 0, j = 0; j < A.length; j++) {
            if (A[j] % 2 == 0) {
                int tmp = A[i];
                A[i++] = A[j];
                A[j] = tmp;
            }
        }
        return A;
        */

        // Create new array instead of in-place swap
        int[] res = new int[A.length];
        int l = 0, r = A.length - 1;
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 0)
                res[l++] = A[i];
            else
                res[r--] = A[i];
        }
        return res;
    }
}
