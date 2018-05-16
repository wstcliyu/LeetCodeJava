public class Toeplitz_766 {
    public static boolean isToeplitzMatrix(int[][] matrix) {
        /* Standard solution O(M*N) O(1)
        for (int r = 0; r < matrix.length; ++r)
            for (int c = 0; c < matrix[0].length; ++c)
                if (r > 0 && c > 0 && matrix[r-1][c-1] != matrix[r][c])
                    return false;
        return true;
        */
        int r = matrix.length - 1;
        int c = matrix[0].length - 1;
        for (int i=c; i>=-r; i--) {
            int x;
            if (i >= 0)
                x = 0;
            else
                x = -i;
            int temp = matrix[x][x+i];
            x++;
            while (x<=r && x+i<=c) {
                if (temp != matrix[x][x+i])
                    return false;
                x++;
            }
        }
        return true;
    }
    public static void main (String args[]) {
        int[][] testMatrix = {{1,2,3,4},{5,1,2,3},{9,5,1,2}} ;
        System.out.println(isToeplitzMatrix(testMatrix));
    }
}
