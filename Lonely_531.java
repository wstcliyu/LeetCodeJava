class Lonely_531 {
    // My first solution
    public int findLonelyPixel(char[][] picture) {
        int R = picture.length;
        int C = picture[0].length;
        int res = 0;
        for (int i = 0; i < R; i++) {
            int countOfPixelThisRow = 0;
            int col = -1;
            for (int j = 0; j < C; j++) {
                if (picture[i][j] == 'B') {
                    countOfPixelThisRow++;
                    col = j;
                }
            }
            if (countOfPixelThisRow == 1) {
                int countOfPixelThisCol = 0;
                for (int k = 0; k < R; k++) {
                    if (picture[k][col] == 'B') {
                        countOfPixelThisCol++;
                    }
                }
                if (countOfPixelThisCol == 1) {
                    res++;
                }
            }
        }
        return res;
    }
}