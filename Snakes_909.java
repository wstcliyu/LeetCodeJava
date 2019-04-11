import java.util.Deque;
import java.util.ArrayDeque;

class Snakes_909 {
    // My solution using BFS
    public int snakesAndLadders(int[][] board) {
        int N = board.length;
        boolean[] visited = new boolean[N * N + 1];
        visited[1] = true;
        Deque<Integer> q = new ArrayDeque<>();
        q.add(1);
        
        int res = 0;
        while (!q.isEmpty()) {
            res++;
            int size = q.size();
            for (int k = 0; k < size; k++) {
                int start = q.removeFirst();
                for (int i = 1; i <= 6; i++) {
                    int end = start + i;
                    int[] idx = getRowAndCol(end, N);
                    if (board[idx[0]][idx[1]] != -1)
                        end = board[idx[0]][idx[1]];
                    if (end == N * N) 
                        return res;
                    if (!visited[end]) {
                        visited[end] = true;
                        q.add(end);
                    }
                }
            }
        }
        
        return -1;
    }
    
    private int[] getRowAndCol(int n, int N) {
        int rowFromBottom = (n - 1) / N;
        if (rowFromBottom % 2 == 0)
            return new int[]{N - 1 - rowFromBottom, (n - 1) % N};
        else
            return new int[]{N - 1 - rowFromBottom, N - 1 - (n - 1) % N};
    }
}