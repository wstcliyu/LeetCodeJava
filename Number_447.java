import java.util.HashMap;
import java.util.Map;

public class Number_447 {
    public static int numberOfBoomerangs(int[][] points) {
        int res = 0;
        int n = points.length;
        for (int i=0; i<n; i++) {
            Map<Integer, Integer> dist_count = new HashMap<>();
            for (int j=0; j<n; j++) {
                if (j == i)
                    continue;
                int dist = getDistance(points[i], points[j]);
                if (dist_count.get(dist) == null)
                    dist_count.put(dist, 1);
                else {
                    int count = dist_count.get(dist);
                    res += 2 * count;
                    dist_count.put(dist, 1+count);
                }
//                dist_count.put(dist, dist_count.getOrDefault(dist, 0)+1);
            }
//            for (int val:dist_count.values())
//                res += val * (val-1);
        }
        return res;
    }
    private static int getDistance(int[] a, int[] b) {
        return (a[0]-b[0])*(a[0]-b[0]) + (a[1]-b[1])*(a[1]-b[1]);
    }
    public static void main (String args[]) {
        int[][] testPoints = {{0,0},{1,0},{2,0}};
        System.out.println(numberOfBoomerangs(testPoints));
    }
}
