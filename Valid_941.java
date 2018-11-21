public class Valid_941 {
    public boolean validMountainArray(int[] A) {
        // Most voted solution
        // Ided: climb mountain from both sides and meet at mountain top
        int n = A.length, i = 0, j = n - 1;
        while (i + 1 < n && A[i] < A[i + 1]) i++;
        while (j > 0 && A[j - 1] > A[j]) j--;
        return i > 0 && i == j && j < n - 1;

        // My first solution, a little verbose
        /*
        if (A.length < 3 || A[0] >= A[1])
            return false;
        int top = 0;
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] == A[i + 1])
                return false;
            if (top == 0 && A[i] > A[i + 1])
                top = 1;
            if (top == 1 && A[i] < A[i + 1])
                return false;
        }
        return top == 1;
        */
    }
}
