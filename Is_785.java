import java.util.*;

class Is_785 {
    // My first solution: DFS
    /*
    public boolean isBipartite(int[][] graph) {
        int[] group = new int[graph.length];
        for (int node = 0; node < group.length; node++) {
            if (group[node] == 0) {
                group[node] = 1;
                if (!dfs(graph, group, node)) return false;
            }
        }
        return true;
    }
    
    private boolean dfs(int[][] graph, int[] group, int start) {
        int g = group[start];
        for (int neighbor : graph[start]) {
            if (group[neighbor] == g) return false;
            if (group[neighbor] == -g) continue; 
            group[neighbor] = -g;
            if (!dfs(graph, group, neighbor)) return false;
        }
        return true;
    }
    */



    // Most voted solution #1: DFS
    /*
     public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n];          
                
        for (int i = 0; i < n; i++) {              
        //This graph might be a disconnected graph. So check each unvisited node.
            if (colors[i] == 0 && !validColor(graph, colors, 1, i)) {
                return false;
            }
        }
        return true;
    }
    
    public boolean validColor(int[][] graph, int[] colors, int color, int node) {
        if (colors[node] != 0) {
            return colors[node] == color;
        }       
        colors[node] = color;       
        for (int next : graph[node]) {
            if (!validColor(graph, colors, -color, next)) {
                return false;
            }
        }
        return true;
    }
    */



    // Most voted solution #1: BFS
    public boolean isBipartite(int[][] graph) {
        int len = graph.length;
        int[] colors = new int[len];
        
        for (int i = 0; i < len; i++) {
            if (colors[i] != 0) continue;
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(i);
            colors[i] = 1;   // Blue: 1; Red: -1.
            
            while (!queue.isEmpty()) {
                int cur = queue.poll();
                for (int next : graph[cur]) {
                    if (colors[next] == 0) {          // If this node hasn't been colored;
                        colors[next] = -colors[cur];  // Color it with a different color;
                        queue.offer(next);
                    } else if (colors[next] != -colors[cur]) {   // If it is colored and its color is different, return false;
                        return false;
                    }
                }
            }
        }
        
        return true;
    }
}