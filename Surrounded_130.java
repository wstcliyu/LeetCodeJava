class Surrounded_130 {
    private int row, col;
    private int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        this.row = board.length;
        this.col = board[0].length;
        for (int i = 0; i < row; i++) {
            dfs(board, i, 0, 'O', '1');
            dfs(board, i, col - 1, 'O', '1');
        }
        
        for (int j = 0; j < col; j++) {
            dfs(board, 0, j, 'O', '1');
            dfs(board, row - 1, j, 'O', '1');
        }
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == '1') {
                    board[i][j] = 'O';
                }
            }
        }
    }
    
    private void dfs(char[][] board, int x, int y, char oldChar, char newChar) {
        if (x < 0 || x >= row || y < 0 || y >= col || board[x][y] != oldChar) {
            return;
        }
        board[x][y] = newChar;
        for (int[] dir : directions) {
            dfs(board, x + dir[0], y + dir[1], oldChar, newChar);
        }
    }
}