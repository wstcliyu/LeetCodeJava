public class Global_775 {
    public boolean isIdealPermutation(int[] A) {
        if (A.length < 3)
            return true;
        int max = 0;
        for (int i=2; i<A.length; i++) {
            max = Math.max(max, A[i-2]);
            if (max > A[i])
                return false;
        }
        return true;
    }
}
