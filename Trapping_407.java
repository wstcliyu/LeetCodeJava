import java.util.*;

class Trapping_407 {
    // Second voted solution: BFS with Priority Queue
    // https://leetcode.com/problems/trapping-rain-water-ii/discuss/89461/Java-solution-using-PriorityQueue
    // https://github.com/awangdev/LintCode/blob/master/Java/Trapping%20Rain%20Water%20II.java
    /*
    给一个2Dmap, 每个position 有 height. 找Trapping water sum.

    #### Min Heap
    - 用PriorityQueue把选中的height排序,为走位, create class Cell (x,y, height).

    ##### 注意几个理论
    - 1. 从matrix四周开始考虑，发现matrix能Hold住的水，取决于height低的block
    - 2. 必须从外围开始考虑，因为水是被包裹在里面，外面至少需要现有一层
    - 以上两点就促使我们用min-heap: 也就是natural order的PriorityQueue<Cell>.

    ##### Steps
    - 1. process的时候，画个图也可以搞清楚: 就是四个方向都走走，用curr cell的高度减去周围cell的高度.
    - 2. 若大于零，那么周围的cell就有积水: 因为cell已经是外围最低, 所以内部更低的, 一定有积水.
    - 3. 每个visited的cell都要mark, avoid revisit
    - 4. 根据4个方向的走位 `(mX, mY)` 创建新cell 加进queue里面: cell(mX, mY) 已经计算过积水后, 外围墙小时, `(mX, mY)`就会变成墙.
    - 5. 因为做的是缩小一圈的新围墙, height = Math.max(cell.h, neighbor.h);
    - 和trapping water I 想法一样。刚刚从外围，只是能加到跟外围cell高度一致的水平面。往里面，很可能cell高度变化。   
    - 这里要附上curr cell 和 move-to cell的最大高度。

    ##### 为什么想到用Heap (min-heap - priorityQueue)
    - 要找到bucket的最短板
    - 每次需要最先处理最短的那条 (on top)

    ##### 为什么从外向里遍历
    - 木桶理论, 包水, 是从外面包住里面
    - 洋葱剥皮, 用完丢掉
    */

    public class Cell {
        int row;
        int col;
        int height;
        public Cell(int row, int col, int height) {
            this.row = row;
            this.col = col;
            this.height = height;
        }
    }

    public int trapRainWater(int[][] heights) {
        if (heights == null || heights.length == 0 || heights[0].length == 0)
            return 0;

        PriorityQueue<Cell> queue = new PriorityQueue<>(1, new Comparator<Cell>(){
            public int compare(Cell a, Cell b) {
                return a.height - b.height;
            }
        });
        
        int m = heights.length;
        int n = heights[0].length;
        boolean[][] visited = new boolean[m][n];

        // Initially, add all the Cells which are on borders to the queue.
        for (int i = 0; i < m; i++) {
            visited[i][0] = true;
            visited[i][n - 1] = true;
            queue.offer(new Cell(i, 0, heights[i][0]));
            queue.offer(new Cell(i, n - 1, heights[i][n - 1]));
        }

        for (int i = 0; i < n; i++) {
            visited[0][i] = true;
            visited[m - 1][i] = true;
            queue.offer(new Cell(0, i, heights[0][i]));
            queue.offer(new Cell(m - 1, i, heights[m - 1][i]));
        }

        // from the borders, pick the shortest cell visited and check its neighbors:
        // if the neighbor is shorter, collect the water it can trap and update its height as its height plus the water trapped
       // add all its neighbors to the queue.
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int res = 0;
        while (!queue.isEmpty()) {
            Cell cell = queue.poll();
            for (int[] dir : dirs) {
                int row = cell.row + dir[0];
                int col = cell.col + dir[1];
                if (row >= 0 && row < m && col >= 0 && col < n && !visited[row][col]) {
                    visited[row][col] = true;
                    res += Math.max(0, cell.height - heights[row][col]);
                    queue.offer(new Cell(row, col, Math.max(heights[row][col], cell.height)));
                }
            }
        }
        
        return res;
    }
}