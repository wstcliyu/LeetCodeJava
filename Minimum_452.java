import java.util.Arrays;
import java.util.Comparator;

class Minimum_452 {
    // Most voted solution
    // Sort the intervals by end
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;
        Arrays.sort(points, Comparator.comparing((int[] p) -> p[1]));

        // Arrays.sort(points, (a, b) -> (a[1] - b[1]));
        /*
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[1] - b[1];
            }
        });
        */


        int arrowPos = points[0][1];
        int res = 1;
        for (int[] p : points) {
            if (p[0] > arrowPos) {
                arrowPos = p[1];
                res++;
            }
        }
        return res;
    }
}