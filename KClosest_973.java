import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class KClosest_973 {
    public static void main(String[] args) {
        // I wrote this testcase which will cause infinite loop
        KClosest_973 test = new KClosest_973();
        int[][] testPoints = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        int[][] res = test.kClosest(testPoints, 2);
        System.out.println(res.length);
    }

    // Most voted solution
    // Comparator.comparing
    // Arrays.copyOfRange
    /*
    public int[][] kClosest(int[][] points, int K) {
        Arrays.sort(points, Comparator.comparing(p -> p[0] * p[0] + p[1] * p[1]));
        return Arrays.copyOfRange(points, 0, K);
    }
    */


    // Similar with Kth_215 using quick select
    // Standard solution #2: Divide and Conquer
    // Time: O(N) in average case complexity, where N is the length of points
    // Space: O(N)
    int[][] points;

    public int[][] kClosest(int[][] points, int K) {
        this.points = points;
        work(0, points.length - 1, K);
        return Arrays.copyOfRange(points, 0, K);
    }

    public void work(int i, int j, int K) {
        if (i >= j) return;
        int oi = i, oj = j;
        int pivot = dist(new Random().nextInt(j - i + 1) + i);
        // int pivot = dist(ThreadLocalRandom.current().nextInt(i, j));
        
        while (i < j) {
            // If dist(i) == dist(j) == pivot, then it gets into infinite loop
            // But the problem description guarantees a result, I think that is probably why this problem doesn't happen
            while (i < j && dist(i) < pivot) i++;
            while (i < j && dist(j) > pivot) j--;
            swap(i, j);
        }

        if (K <= i - oi + 1)
            work(oi, i, K);
        else
            work(i+1, oj, K - (i - oi + 1));


        // My version (Refer to Kth_215)
        /*
        if (i >= j) return;
        int oi = i, oj = j;
        swap(j, new Random().nextInt(j-i+1) + i);
        int pivot = dist(j);

        while (i < j) {
            while (i < j && dist(i) < pivot) i++;
            while (i < j && dist(j) >= pivot) j--;
            swap(i, j);
        }
        swap(i, oj);

        int m = i - oi + 1;
        if (m == K) return;
        else if (m > K) work(oi, i-1, K);
        else work(i+1, oj, K-m);
        */
    }

    public int dist(int i) {
        return points[i][0] * points[i][0] + points[i][1] * points[i][1];
    }

    public void swap(int i, int j) {
        int t0 = points[i][0], t1 = points[i][1];
        points[i][0] = points[j][0];
        points[i][1] = points[j][1];
        points[j][0] = t0;
        points[j][1] = t1;
    }


    // My first solution using priority queue
    /*
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> heap = new PriorityQueue<>(
                (b, a) -> a[0] * a[0] + a[1] * a[1] - b[0] * b[0] - b[1] * b[1]);
        for (int[] point : points) {
            heap.add(point);
            if (heap.size() > K)
                heap.poll();
        }
        int[][] res = new int[heap.size()][2];
        for (int i = 0; i < res.length; i++)
            res[i] = heap.poll();
        return res;
    }
    */
}
