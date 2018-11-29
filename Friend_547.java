public class Friend_547 {
    public int findCircleNum(int[][] M) {
        int N = M.length;
        boolean[] visited = new boolean[N];
        int count = 0;
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                count++;
                dfs(M, visited, i);
            }
        }
        return count;
    }
    private void dfs(int[][] M, boolean[] visited, int i) {
        for (int j = 0; j < M.length; j++) {
            if (!visited[j] && M[i][j] == 1) {
                visited[j] = true;
                dfs(M, visited, j);
            }
        }
    }
}
