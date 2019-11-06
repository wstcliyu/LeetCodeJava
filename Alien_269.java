import java.util.*;

class Alien_269 {
    // My first solution: Topological Sort (DFS)
    final int N = 26;
    boolean isCycle;
    StringBuilder sb;
    int[] visited;
    boolean[][] graph;
    
    public String alienOrder(String[] words) {
        visited = new int[N];
        Arrays.fill(visited, -1);
        for (String w : words)
            for (char c : w.toCharArray())
                visited[c - 'a'] = 0;
        graph = new boolean[N][N];
        for (int i = 1; i < words.length; i++) {
            String w1 = words[i - 1];
            String w2 = words[i];
            for (int j = 0; j < w1.length(); j++) {
                if (j == w2.length()) return "";
                char c1 = w1.charAt(j);
                char c2 = w2.charAt(j);
                if (c1 != c2) {
                    graph[c1 - 'a'][c2 - 'a'] = true;
                    break;
                }
            }
        }
        isCycle = false;
        sb = new StringBuilder();
        for (int i = 0; !isCycle && i < N; i++) {
            if (visited[i] == 0) dfs(i);
        }
        return isCycle ? "" : sb.toString();
    }
    
    private void dfs(int i) {
        if (isCycle) return;
        visited[i] = 1;
        for (int j = 0; j < N; j++) {
            if (graph[i][j]) {
                if (visited[j] == 0) {
                    dfs(j);
                } else if (visited[j] == 1) {
                    isCycle = true;
                    return;
                }
            }
        }
        visited[i] = 2;
        sb.insert(0, (char)(i + 'a'));
    }



    // My first solution: Topological Sort (BFS)
    /*
    public String alienOrder(String[] words) {
        final int N = 26;
        boolean[][] graph = new boolean[N][N];
        int[] inDegree = new int[N];
        Arrays.fill(inDegree, -1);
        for (String w : words)
            for (char c : w.toCharArray())
                inDegree[c - 'a'] = 0;
        for (int i = 1; i < words.length; i++) {
            String w1 = words[i - 1];
            String w2 = words[i];
            for (int j = 0; j < w1.length(); j++) {
                if (j == w2.length()) return "";
                char c1 = w1.charAt(j);
                char c2 = w2.charAt(j);
                if (c1 != c2) {
                    if (!graph[c1 - 'a'][c2 - 'a']) {
                        graph[c1 - 'a'][c2 - 'a'] = true;
                        inDegree[c2 - 'a']++;
                    }
                    break;
                }
            }
        }
        int count = 0;
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            if (inDegree[i] != -1) count++;
            if (inDegree[i] == 0) q.add(i);
        }
        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            int u = q.removeFirst();
            sb.append((char)(u + 'a'));
            count--;
            for (int i = 0; i < N; i++) {
                if (graph[u][i] && --inDegree[i] == 0) {
                    q.add(i);
                }
            }
        }
        return count == 0 ? sb.toString() : "";
    }
    */
}