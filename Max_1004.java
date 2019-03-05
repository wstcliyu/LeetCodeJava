public class Max_1004 {
	// Most voted solution
	// Since we are to find the longest window,
	// we do not need to reduce the size of the sliding window.
	// The value j - i will never decrease as the loop goes
	public int longestOnes(int[] A, int K) {
        int i = 0, j;
        for (j = 0; j < A.length; ++j) {
            if (A[j] == 0) K--;
            if (K < 0 && A[i++] == 0) K++;
        }
        return j - i;
    }



	// My first solution using sliding window
	/*
	public int longestOnes(int[] A, int K) {
        int l = 0, res = 0;
        for (int r = 0; r < A.length; r++) {
            if (A[r] == 0) K--;
            while (K < 0) {
                if (A[l++] == 0) K++;
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
    */
}