import java.util.Arrays;

public class Diagonal_498 {
	private int R, C, write;
    private int[] res;
    private int[][] matrix;
    
    public int[] findDiagonalOrder(int[][] matrix) {
    	if (matrix.length == 0 || matrix[0].length == 0) return new int[0];
        R = matrix.length;
        C = matrix[0].length;
        write = 0;
        res = new int[R * C];
        this.matrix = matrix;
        int leftToRight = 1;
        for (int sum = 0; sum <= R + C - 2; sum++) {
            fillRes(leftToRight, sum);
            // I got a mistake here before by
            // leftToRight ^= 1;
            // This is wrong because we are not changing between 0 and 1, but -1 and 1
            leftToRight *= -1;
        }
        return res;
    }
    
    private void fillRes(int leftToRight, int sum) {
        int[] start;
        if (leftToRight == 1) start = sum < R ? new int[]{sum, 0} : new int[]{R-1, sum-R+1};
        else start = sum < C ? new int[]{0, sum} : new int[]{sum-C+1, C-1};
        while(isValid(start)) {
            res[write++] = matrix[start[0]][start[1]];
            // I got a serious mistake here by
            // start[0] += leftToRight; start[1] = sum - start[0];
            // This is wrong because leftToRight indicates how to change colomn number not row number
            start[1] += leftToRight;
            start[0] = sum - start[1];
        }
    }
    
    private boolean isValid(int[] point) {
        return point[0] >= 0 && point[0] < R && point[1] >= 0 && point[1] < C;
    }

    public static void main(String args[]) {
    	Diagonal_498 test = new Diagonal_498();
    	int[][] m = {{1,2,3}, {4,5,6}, {7,8,9}};
    	int[] result = test.findDiagonalOrder(m);
    	System.out.println(Arrays.toString(result));
    }
}