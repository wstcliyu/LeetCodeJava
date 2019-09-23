import java.util.*;

class Shortest_1182 {
    // My first solution: left and right array
    public List<Integer> shortestDistanceColor(int[] colors, int[][] queries) {
        int N = colors.length;
        int[][] left = new int[N][4];
        int[][] right = new int[N][4];
        
        Arrays.fill(left[0], Integer.MAX_VALUE);
        Arrays.fill(right[N - 1], Integer.MAX_VALUE);
        left[0][colors[0]] = 0;
        right[N - 1][colors[N - 1]] = 0;
        for (int i = 1, j = N - 2; i < N; i++, j--) {
            for (int c = 1; c <= 3; c++) {
                if (c == colors[i]) {
                    left[i][c] = 0;
                } else {
                    left[i][c] = left[i - 1][c] == Integer.MAX_VALUE ? Integer.MAX_VALUE : 1 + left[i - 1][c];
                }
                
                if (c == colors[j]) {
                    right[j][c] = 0;
                } else {
                    right[j][c] = right[j + 1][c] == Integer.MAX_VALUE ? Integer.MAX_VALUE : 1 + right[j + 1][c];
                }
            }
        }
        
        List<Integer> res = new ArrayList<>();
        for (int[] q : queries) {
            int i = q[0], c = q[1];
            int dist = Math.min(left[i][c], right[i][c]);
            res.add(dist == Integer.MAX_VALUE ? -1 : dist);
        }
        return res;
    }
}