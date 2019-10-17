import java.util.*;

class Queens_1222 {
    // Second voted solution
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[][] seen = new boolean[8][8];
        for (int[] q : queens) {
            seen[q[0]][q[1]] = true;
        }
        int[] directions = {-1, 0, 1};
        for (int dx : directions) {
            for (int dy : directions) {
                if (dx == 0 && dy == 0) continue;
                for (int x = king[0], y = king[1]; x >= 0 && x < 8 && y >= 0 && y < 8; x += dx, y += dy) {
                    if (seen[x][y]) {
                        res.add(Arrays.asList(x, y));
                        break;
                    }
                }
            }
        }
        return res;
    }
}