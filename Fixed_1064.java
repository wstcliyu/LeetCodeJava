import java.util.Arrays;

class Fixed_1064 {
    public int fixedPoint(int[] A) {
        int[] B = new int[A.length];
        for (int i = 0; i < B.length; i++) {
            B[i] = A[i] - i;
        }
        
        int p = Arrays.binarySearch(B, 0);
        return p >= 0 ? p : -1;
    }
}