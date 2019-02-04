import java.util.*;

public class Minimum_939 {
    // Standard solution #1: Sort by column
    public int minAreaRect(int[][] points) {
        Map<Integer, List<Integer>> map = new TreeMap<>();
        for (int[] point : points)
            map.computeIfAbsent(point[0], k -> new ArrayList<>()).add(point[1]);
        int res = Integer.MAX_VALUE;
        Map<Integer, Integer> lastx = new HashMap<>();
        for (int x : map.keySet()) {
            List<Integer> row = map.get(x);
            Collections.sort(row);
            for (int i = 0; i < row.size(); i++) {
                for (int j = i + 1; j < row.size(); j++) {
                    int y1 = row.get(i), y2 = row.get(j);
                    int code = 40001 * y1 + y2;
                    if (lastx.containsKey(code))
                        res = Math.min(res, (x - lastx.get(code)) * (y2 - y1));
                    lastx.put(code, x);
                }
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }


    // Standard solution #2: brute force by diagonal
    /*
    public int minAreaRect(int[][] points) {
        int res = Integer.MAX_VALUE;
        Set<Integer> set = new HashSet<>();
        for (int[] point : points) set.add(40001 * point[0] + point[1]);
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int x1 = points[i][0], y1 = points[i][1];
                int x2 = points[j][0], y2 = points[j][1];
                int code1 = 40001 * x1 + y2, code2 = 40001 * x2 + y1;
                if (x1 != x2 && y1 != y2 && set.contains(code1) && set.contains(code2))
                    res = Math.min(res, Math.abs((x1 - x2) * (y1 - y2)));
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
    */


    // Most voted solution: brute force by diagonal
    /*
    public int minAreaRect(int[][] points) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] point : points)
            map.computeIfAbsent(point[0], k -> new HashSet<>()).add(point[1]);
        int min = Integer.MAX_VALUE;
        for (int[] p1 : points) {
            for (int[] p2 : points) {
                if (p1[0] == p2[0] || p1[1] == p2[1]) continue;
                if (map.get(p1[0]).contains(p2[1]) && map.get(p2[0]).contains(p1[1]))
                    min = Math.min(min, Math.abs(p1[0] - p2[0]) * Math.abs(p1[1] - p2[1]));
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
    */
}
