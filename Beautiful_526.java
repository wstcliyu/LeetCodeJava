import java.util.ArrayList;
import java.util.List;

public class Beautiful_526 {
    // Standard Solution Approach #3
    int count = 0;
    public int countArrangement(int N) {
        boolean[] visited = new boolean[N + 1];
        calculate(N, 1, visited);
        return count;
    }
    public void calculate(int N, int pos, boolean[] visited) {
        if (pos > N)
            count++;
        for (int i = 1; i <= N; i++) {
            if (!visited[i] && (pos % i == 0 || i % pos == 0)) {
                visited[i] = true;
                calculate(N, pos + 1, visited);
                visited[i] = false;
            }
        }
    }
    /*
    int count = 0;

    public int countArrangement(int N) {
        backtrack(new ArrayList<>(), N);
        return count;
    }

    private void backtrack(List<Integer> ls, int N) {
        if (ls.size() == N)
            count++;
        else {
            for (int i = 1; i <= N; i++) {
                int pos = ls.size() + 1;
                if (!ls.contains(i) && (i % pos == 0 || pos % i == 0)) {
                    ls.add(i);
                    backtrack(ls, N);
                    ls.remove(ls.size() - 1);
                }
            }
        }
    }
    */
}
