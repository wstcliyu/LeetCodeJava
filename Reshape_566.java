import java.util.Arrays;

public class Reshape_566 {
    public static int[][] matrixReshape(int[][] nums, int r, int c) {
        int row = nums.length;
        int column = nums[0].length;
        if (r*c != row * column)
            return nums;
        int[][] result = new int[r][c];
        for (int i=0; i<r; i++) {
            for (int j=0; j<c; j++) {
                result[i][j] = nums[(i*c+j)/column][(i*c+j)%column];
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[][] testNums = {{1,2},{3,4}};
        System.out.println(Arrays.deepToString(matrixReshape(testNums,4,1)));
    }
}
