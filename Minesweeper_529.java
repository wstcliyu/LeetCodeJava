public class Minesweeper_529 {
    // https://leetcode.com/problems/minesweeper/discuss/99826/Java-Solution-DFS-%2B-BFS
    // If using BFS in the above link, remember to avoid the same grid again

    public char[][] updateBoard(char[][] board, int[] click) {
        dfs(board, click[0], click[1]);
        return board;
    }

    private void dfs(char[][] board, int r, int c) {
        int R = board.length, C = board[0].length;
        if (r < 0 || r >= R || c < 0 || c >= C) return;
        if (board[r][c] == 'M') board[r][c] = 'X';
        if (board[r][c] == 'E') {
            int count = countMine(board, r, c);
            if (count > 0) board[r][c] = (char)(count + '0');
            else {
                board[r][c] = 'B';
                for (int i = -1; i <= 1; i++)
                    for (int j = -1; j <= 1; j++)
                        dfs(board, r + i, c + j);
            }
        }
    }

    private int countMine(char[][] board, int r, int c) {
        int count = 0;
        int R = board.length, C = board[0].length;
        for (int i = -1; i <= 1; i++)
            for (int j = -1; j <= 1; j++)
                if (r + i >= 0 && c + j >= 0 && r + i < R && c + j < C && board[r + i][c + j] == 'M')
                    count++;
        return count;
    }
}
