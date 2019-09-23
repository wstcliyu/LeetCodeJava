import java.util.Arrays;

public class Spiral_59 {
    // Refer to Spiral_54
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int step = 1;
        int top = 0, bottom = n - 1;
        int left = 0, right = n - 1;
        while (left <= right && top <= bottom) {
            for (int j = left; j <= right; j++, step++)
                res[top][j] = step;
            top++;
            
            for (int i = top; i <= bottom; i++, step++)
                res[i][right] = step;
            right--;
            
            if (top <= bottom) {
                for (int j = right; j >= left; j--, step++)
                    res[bottom][j] = step;
                bottom--;
            }
            
            if (left <= right) {
                for (int i = bottom; i >= top; i--, step++)
                    res[i][left] = step;
                left++;
            }
        }
        return res;
    }


    // My first solution
    /*
    public static int[][] generateMatrix(int n) {           
        int[][] res = new int[n][n];
        int step = 0, x = 0, y = -1;
        while (step < n * n) {
            while (y < n - 1 && res[x][y + 1] == 0)
                res[x][++y] = ++step;

            while (x < n - 1 && res[x + 1][y] == 0)
                res[++x][y] = ++step;

            while (y > 0 && res[x][y - 1] == 0)
                res[x][--y] = ++step;

            while (x > 0 && res[x - 1][y] == 0)
                res[--x][y] = ++step;
        }
        return res;
    }
    */

    public static void main (String args[]) {
        System.out.println(Arrays.deepToString(generateMatrix(3)));
    }
}
