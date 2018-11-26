import java.util.HashSet;
import java.util.Set;

public class Valid_36 {
    // Most voted solution, smart idea, a little slow
    public boolean isValidSudoku(char[][] board) {
        Set seen = new HashSet();
        for (int i=0; i<9; ++i) {
            for (int j=0; j<9; ++j) {
                /*
                char number = board[i][j];
                if (number != '.')
                if (!seen.add(number + " in row " + i) ||
                    !seen.add(number + " in column " + j) ||
                    !seen.add(number + " in block " + i/3 + "-" + j/3))
                    return false;
                */

                if (board[i][j] != '.') {
                    String b = "(" + board[i][j] + ")";
                    if (!seen.add(b + i) || !seen.add(j + b) || !seen.add(i/3 + b + j/3))
                        return false;
                }
            }
        }
        return true;
    }

    // Second voted solution, straightforward
    /*
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            HashSet<Character> set_row = new HashSet<>();
            HashSet<Character> set_col = new HashSet<>();
            HashSet<Character> set_box = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                char row = board[i][j];
                char col = board[j][i];
                if (row != '.' && !set_row.add(row)) return false;
                if (col != '.' && !set_col.add(col)) return false;

                int topleftRow = i / 3 * 3;
                int topleftCol = i % 3 * 3;
                char box = board[topleftRow + j / 3][topleftCol + j % 3];
                if (box != '.' && !set_box.add(box)) return false;
            }
        }
        return true;
    }
    */
}
