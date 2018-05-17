import java.util.Arrays;

public class Image_661 {
    public static int[][] imageSmoother(int[][] M) {
        int r = M.length;
        int c = M[0].length;
        int[][] result = new int[r][c];
        for (int i=0; i<r; i++) {
            for (int j=0; j<c; j++) {
                int count = 0, temp = 0;
                for (int ii=-1; ii<=1; ii++) {
                    for (int jj=-1; jj<=1; jj++)
                        if (outOfBoundary(i+ii,j+jj,r,c)) {
                            count++;
                            temp += M[i+ii][j+jj];
                        }
                }
                result[i][j] = temp/count;
            }
        }
        return result;
    }
    public static boolean outOfBoundary(int x, int y, int r, int c) {
        if (x<0 || x>=r || y<0 || y>=c)
            return false;
        return true;
    }
    public static void main (String args[]) {
        int[][] testM = {{1,1,1}, {1,0,1}, {1,1,1}};
        System.out.println(Arrays.deepToString(imageSmoother(testM)));
    }
}
