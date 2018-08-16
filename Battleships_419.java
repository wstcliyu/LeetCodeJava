public class Battleships_419 {
    public int countBattleships(char[][] board) {
        // My first solution is the same as the most voted solution
        int count = 0;
        int row = board.length;
        int col = board[0].length;
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                if (board[i][j] == '.' || (i >= 1 && board[i-1][j] == 'X') || (j >= 1) && board[i][j-1] == 'X')
                    continue;
                count++;
            }
        }
        return count;
    }
}
