public class Word_79 {
    // My solution using dfs
    private char[][] board;
    private String word;
    private boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        int R = board.length, C = board[0].length;
        this.board = board;
        this.word = word;
        this.visited = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (dfs(0, i, j))
                    return true;
            }
        }
        return false;
    }

    private boolean dfs(int idx, int x, int y) {
        if (idx == word.length()) return true;
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || visited[x][y] || word.charAt(idx) != board[x][y])
            return false;

        visited[x][y] = true;
        if (dfs(idx+1, x-1, y) || dfs(idx+1, x+1, y)
                || dfs(idx+1, x, y-1) || dfs(idx+1, x, y+1)) return true;

        visited[x][y] = false;
        return false;
    }


    // Most voted solution
    // Apply bit mask for every visited cell to save memory
    /*
    public boolean exist(char[][] board, String word) {
        char[] w = word.toCharArray();
        for (int y=0; y<board.length; y++) {
            for (int x=0; x<board[y].length; x++) {
                if (exist(board, y, x, w, 0)) return true;
            }
        }
        return false;
    }

    private boolean exist(char[][] board, int y, int x, char[] word, int i) {
        if (i == word.length) return true;
        if (y<0 || x<0 || y == board.length || x == board[y].length) return false;
        if (board[y][x] != word[i]) return false;
        board[y][x] ^= 256;
        boolean exist = exist(board, y, x+1, word, i+1)
            || exist(board, y, x-1, word, i+1)
            || exist(board, y+1, x, word, i+1)
            || exist(board, y-1, x, word, i+1);
        board[y][x] ^= 256;
        return exist;
    }
    */



    public static void main(String[] args) {
        Word_79 test = new Word_79();
        char[][] board = {{'A','B','C','E'}, {'S','F','C','S'}, {'A','D','E','E'}};
        String word = "ABCCED";
        System.out.println(test.exist(board, word));
    }
}
