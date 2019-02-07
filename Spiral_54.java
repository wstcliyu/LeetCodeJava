import java.util.ArrayList;
import java.util.List;

public class Spiral_54 {
    // My first solution
    /*
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix.length == 0 || matrix[0].length == 0) return res;
        int top = 0, bottom = matrix.length - 1;
        int left = 0, right = matrix[0].length - 1;
        int x = 0, y = 0;
        while (left <= right && top <= bottom) {
            while (left <= right && top <= bottom && y < right) res.add(matrix[x][y++]);
            top++;

            while (left <= right && top <= bottom && x < bottom) res.add(matrix[x++][y]);
            right--;

            while (left <= right && top <= bottom && y > left) res.add(matrix[x][y--]);
            bottom--;

            while (left <= right && top <= bottom && x > top) res.add(matrix[x--][y]);
            left++;
        }
        res.add(matrix[x][y]);
        return res;
    }
    */


    // Most voted solution
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix.length == 0 || matrix[0].length == 0) return res;
        int top = 0, bottom = matrix.length - 1;
        int left = 0, right = matrix[0].length - 1;
        while (left <= right && top <= bottom) {
            for (int j = left; j <= right; j++) res.add(matrix[top][j]);
            top++;

            for (int i = top; i <= bottom; i++) res.add(matrix[i][right]);
            right--;

            if (top <= bottom) {
                for (int j = right; j >= left; j--) res.add(matrix[bottom][j]);
                bottom--;
            }

            if (left <= right) {
                for (int i = bottom; i >= top; i--) res.add(matrix[i][left]);
                left++;
            }
        }
        return res;
    }
}
