import java.util.HashMap;

public class Max_149 {
	public int maxPoints(Point[] points) {
        if (points == null) return 0;
        if (points.length <= 2) return points.length;
        int res = 0;
        for (int i = 0; i < points.length; i++) {
            int overlap = 0, max = 0;
            HashMap<Integer, HashMap<Integer, Integer>> count = new HashMap<>();
            for (int j = i+1; j < points.length; j++) {
                int x = points[j].x - points[i].x;
                int y = points[j].y - points[i].y;
                if (x == 0 && y == 0) {
                    overlap++;
                    continue;
                }
                int gcd = GCD(x, y);
                if (gcd != 0) {
                    x /= gcd;
                    y /= gcd;
                }
                if (x < 0) {
                    x = -x;
                    y = -y;
                }
                count.putIfAbsent(x, new HashMap<>());
                HashMap<Integer, Integer> map = count.get(x);
                map.put(y, 1 + map.getOrDefault(y, 0));
                max = Math.max(map.get(y), max);
            }
            res = Math.max(res, max + overlap + 1);
        }
        return res;
    }
    
    
    private int GCD(int a, int b) {
        return b == 0 ? a : GCD(b, a%b);
    }
}