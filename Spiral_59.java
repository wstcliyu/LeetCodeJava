import java.util.Arrays;

public class Spiral_59 {
    // Similar with mine
    /*
    public int[][] generateMatrix(int n) {
        int[][] ret = new int[n][n];
        int left = 0,top = 0;
        int right = n -1,down = n - 1;
        int count = 1;
        while (left <= right) {
            for (int j = left; j <= right; j ++) {
                ret[top][j] = count++;
            }
            top ++;
            for (int i = top; i <= down; i ++) {
                ret[i][right] = count ++;
            }
            right --;
            for (int j = right; j >= left; j --) {
                ret[down][j] = count ++;
            }
            down --;
            for (int i = down; i >= top; i --) {
                ret[i][left] = count ++;
            }
            left ++;
        }
        return ret;
    }
    */


    // My solution
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
    public static void main (String args[]) {
        System.out.println(Arrays.deepToString(generateMatrix(3)));
    }
}
