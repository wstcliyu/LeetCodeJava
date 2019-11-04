import java.util.ArrayList;
import java.util.List;

class Number_305 {
  // My solution: Union Find
  class UF {
        int size;
        int[] parent;

        UF(int N) {
            size = 0;
            parent = new int[N];
            Arrays.fill(parent, -1);
        }
        
        int find(int x) {
            if (x != parent[x])
                parent[x] = find(parent[x]);
            return parent[x];
        }
        
        void union(int x, int y) {
            int px = find(x);
            int py = find(y);
            if (px != py) {
                parent[py] = px;
                size--;
            }
        }
        
        boolean add(int x) {
            if (parent[x] == -1) {
                parent[x] = x;
                size++;
                return true;
            }
            return false;
        }
    }
    
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        UF uf = new UF(m * n);
        List<Integer> res = new ArrayList<>();
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int[] p : positions) {
            int c1 = n * p[0] + p[1];
            if (uf.add(c1)) {
                for (int[] d : directions) {
                    int x = d[0] + p[0];
                    int y = d[1] + p[1];
                    int c2 = n * x + y;
                    if (x >= 0 && x < m && y >= 0 && y < n && uf.parent[c2] != -1) {
                        uf.union(c1, c2);
                    }
                }
            }
            
            res.add(uf.size);
        }
        return res;
    }




  /*
  class UnionFind {
    int count; // # of connected components
    int[] parent;
    int[] rank;

    public UnionFind(char[][] grid) { // for problem 200
      count = 0;
      int m = grid.length;
      int n = grid[0].length;
      parent = new int[m * n];
      rank = new int[m * n];
      for (int i = 0; i < m; ++i) {
        for (int j = 0; j < n; ++j) {
          if (grid[i][j] == '1') {
            parent[i * n + j] = i * n + j;
            ++count;
          }
          rank[i * n + j] = 0;
        }
      }
    }

    public UnionFind(int N) { // for problem 305 and others
      count = 0;
      parent = new int[N];
      rank = new int[N];
      for (int i = 0; i < N; ++i) {
        parent[i] = -1;
        rank[i] = 0;
      }
    }

    public boolean isValid(int i) { // for problem 305
      return parent[i] >= 0;
    }

    public void setParent(int i) {
      parent[i] = i;
      ++count;
    }

    public int find(int i) { // path compression
      if (parent[i] != i) parent[i] = find(parent[i]);
      return parent[i];
    }

    public void union(int x, int y) { // union with rank
      int rootx = find(x);
      int rooty = find(y);
      if (rootx != rooty) {
        if (rank[rootx] > rank[rooty]) {
          parent[rooty] = rootx;
        } else if (rank[rootx] < rank[rooty]) {
          parent[rootx] = rooty;
        } else {
          parent[rooty] = rootx; rank[rootx] += 1;
        }
        --count;
      }
    }

    public int getCount() {
      return count;
    }
  }

  public List<Integer> numIslands2(int m, int n, int[][] positions) {
    List<Integer> ans = new ArrayList<>();
    UnionFind uf = new UnionFind(m * n);

    for (int[] pos : positions) {
      int r = pos[0], c = pos[1];
      List<Integer> overlap = new ArrayList<>();

      if (r - 1 >= 0 && uf.isValid((r-1) * n + c)) overlap.add((r-1) * n + c);
      if (r + 1 < m && uf.isValid((r+1) * n + c)) overlap.add((r+1) * n + c);
      if (c - 1 >= 0 && uf.isValid(r * n + c - 1)) overlap.add(r * n + c - 1);
      if (c + 1 < n && uf.isValid(r * n + c + 1)) overlap.add(r * n + c + 1);

      int index = r * n + c;
      uf.setParent(index);
      for (int i : overlap) uf.union(i, index);
      ans.add(uf.getCount());
    }

    return ans;
  }
  */
}