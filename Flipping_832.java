import java.util.Arrays;

public class Flipping_832 {
    public static int[][] flipAndInvertImage(int[][] A) {
        int n = A.length;
        int temp;
        for (int i=0; i<n; i++) {
            int left = 0;
            int right = n-1;
            while (left <= right) {
                temp = A[i][left];
                A[i][left] = 1 - A[i][right];
                A[i][right] = 1 - temp;
                left++;
                right--;
            }
        }
        return A;
    }
    public static void main (String args[]) {
        int[][] testA = {{1,1,0,0},{1,0,0,1},{0,1,1,1},{1,0,1,0}};
        System.out.println(Arrays.deepToString(flipAndInvertImage(testA)));
    }
}
