class Knight_688 {

    int[][] directions = new int[][]{{1, 2}, {2, 1}, {1, -2}, {2, -1}, {-1, -2}, {-2, -1}, {-1, 2}, {-2, 1}};

    // Standard solution: DP
    public double knightProbability(int N, int K, int r, int c) {
        double[][] dp = new double[N][N];
        dp[r][c] = 1;
        while (K > 0) {
            K--;
            double[][] dp2 = new double[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    for (int[] d : directions) {
                        int x = i + d[0];
                        int y = j + d[1];
                        if (x >= 0 && x < N && y >= 0 && y < N) {
                            dp2[x][y] += dp[i][j] / 8.0;
                        }
                    }
                }
            }
            dp = dp2;
        }
        double res = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                res += dp[i][j];
            }
        }
        return res;
    }
    

    
    // My first solution: BFS (Time Limit Exceeded)
    /*
    public double knightProbability(int N, int K, int r, int c) {
        double out = 0;
        Pair start = new Pair(1.0, r, c);
        Deque<Pair> q = new ArrayDeque<>();
        q.add(start);
        while (!q.isEmpty() && K > 0) {
            K--;
            for (int i = q.size(); i > 0; i--) {
                Pair p = q.removeFirst();
                for (int[] d : directions) {
                    int x = p.x + d[0];
                    int y = p.y + d[1];
                    if (x < 0 || x >= N || y < 0 || y >= N) {
                        out += 0.125 * p.prob;
                    } else {
                        q.add(new Pair(0.125 * p.prob, x, y));
                    }
                }
            }
        }
        return 1 - out;
    }
    
    class Pair {
        double prob;
        int x, y;
        Pair(double p, int i, int j) {
            prob = p;
            x = i;
            y = j;
        }
    }
    */
}