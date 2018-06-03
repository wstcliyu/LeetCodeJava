import java.util.Arrays;

public class Spiral_59 {
    public static int[][] generateMatrix(int n) {
        /* Similar solution (Walk Through)
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
        */
        int[][] res = new int[n][n];
        int mode = 0, step = 0, x = 0, y = -1;
        while (step < n*n) {
            if (mode % 4 == 0) {
                while (y<n-1 && res[x][y+1]==0)
                    res[x][++y] = ++step;
            }
            mode++;
            if (mode % 4 == 1) {
                while (x<n-1 && res[x+1][y]==0)
                    res[++x][y] = ++step;
            }
            mode++;
            if (mode % 4 == 2) {
                while (y>0 && res[x][y-1]==0)
                    res[x][--y] = ++step;
            }
            mode++;
            if (mode % 4 == 3) {
                while (x>0 && res[x-1][y]==0)
                    res[--x][y] = ++step;
            }
            mode++;
        }
        return res;
    }
    public static void main (String args[]) {
        System.out.println(Arrays.deepToString(generateMatrix(3)));
    }
}
