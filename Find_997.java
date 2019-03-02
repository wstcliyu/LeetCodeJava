public class Find_997 {
    // Most voted solution: Directed Graph
    // Time: O(N+T), Space: O(N)
    // Consider trust as a graph, all pairs are directed edge.
    // The point with in-degree - out-degree = N - 1 is the judge.
    public int findJudge(int N, int[][] trust) {
        int[] count = new int[N+1];
        for (int[] t : trust) {
            count[t[0]]--;
            count[t[1]]++;
        }
        for (int i = 1; i <= N; i++) {
            if (count[i] == N-1) return i;
        }
        return -1;
    }
}
