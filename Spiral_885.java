public class Spiral_885 {
	public int[][] spiralMatrixIII(int R, int C, int r, int c) {
        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int[][] res = new int[R * C][2];
        int t = 0;
        res[t++] = new int[]{r, c};
        
        int len = 2, d = 0;      
        while (t < R * C) {
            for (int i = 0; i < len/2; i++) {
                r += dir[d][0];
                c += dir[d][1];
                if (r >= 0 && r < R && c >= 0 && c < C)
                    res[t++] = new int[]{r, c};
            }
            len++;
            d = (d + 1) % 4;
        }
        
        return res;
    }
}