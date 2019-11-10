class Cells_1252 {
    // Time: O(L), space: O(m + n), where L = indices.length.
    public int oddCells(int n, int m, int[][] indices) {
        boolean[] row = new boolean[n], col = new boolean[m];
        int cntRow = 0, cntCol = 0;
        for (int[] idx : indices) {
            row[idx[0]] ^= true;
            col[idx[1]] ^= true;
            cntRow += row[idx[0]] ? 1 : -1;
            cntCol += col[idx[1]] ? 1 : -1;
        }
        return m * cntRow + n * cntCol - 2 * cntRow * cntCol;
    }



    // Time: O(L + m + n), space: O(m + n), where L = indices.length
    /*
    public int oddCells(int n, int m, int[][] indices) {
        boolean[] row = new boolean[n], col = new boolean[m];
        int cntRow = 0, cntCol = 0;
        for (int[] idx : indices) {
            row[idx[0]] ^= true;
            col[idx[1]] ^= true;
        }
        for (boolean r : row)
            cntRow += r ? 1 : 0;
        for (boolean c : col)
            cntCol += c ? 1 : 0;
        return m * cntRow + n * cntCol - 2 * cntRow * cntCol;
    }
    */
}