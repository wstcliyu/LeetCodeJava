import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Image_835 {
    // Standard
    /*
    public int largestOverlap(int[][] A, int[][] B) {
        int N = A.length;
        int[][] count = new int[2*N+1][2*N+1];
        for (int i = 0; i < N; ++i)
            for (int j = 0; j < N; ++j)
                if (A[i][j] == 1)
                    for (int i2 = 0; i2 < N; ++i2)
                        for (int j2 = 0; j2 < N; ++j2)
                            if (B[i2][j2] == 1)
                                count[i-i2 +N][j-j2 +N] += 1;

        int ans = 0;
        for (int[] row: count)
            for (int v: row)
                ans = Math.max(ans, v);
        return ans;
    }
    */

    // Most voted
    // https://leetcode.com/problems/image-overlap/discuss/130623/C%2B%2BJavaPython-Straight-Forward

    public int largestOverlap(int[][] A, int[][] B) {
        int N = A.length;
        List<Integer> LA = new ArrayList<>();
        List<Integer> LB = new ArrayList<>();
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < N * N; ++i) if (A[i / N][i % N] == 1) LA.add(i / N * 100 + i % N);
        for (int i = 0; i < N * N; ++i) if (B[i / N][i % N] == 1) LB.add(i / N * 100 + i % N);
        for (int i : LA) for (int j : LB)
                count.put(i - j, count.getOrDefault(i - j, 0) + 1);
        int res = 0;
        for (int i : count.values()) res = Math.max(res, i);
        return res;
    }


    public static void main(String[] args) {
        Image_835 test = new Image_835();
        int[][] A = {{0,1},{1,1}};
        int[][] B = {{1,1},{1,0}};
        System.out.println(test.largestOverlap(A, B));
    }
}
