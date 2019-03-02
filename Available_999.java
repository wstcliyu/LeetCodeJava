public class Available_999 {
    int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int numRookCaptures(char[][] board) {
        int res = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'R') {
                    for (int k = 0; k < 4; k++)
                        res += cap(board, i, j, dir[k][0], dir[k][1]);
                    return res;
                }
            }
        }
        return res;
    }

    private int cap(char[][] board, int x, int y, int dx, int dy) {
        while (x >= 0 && x < board.length && y >= 0 && y < board[0].length && board[x][y] != 'B') {
            if (board[x][y] == 'p') return 1;
            x += dx;
            y += dy;
        }
        return 0;
    }
}
