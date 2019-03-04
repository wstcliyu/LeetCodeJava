import java.util.Arrays;
import java.util.Random;
import java.util.TreeMap;

public class Random_497 {
    // My first solution using increasing array and binary search
    // (This is similar with the most voted)
    int[][] rects;
    Random rand;
    int[] weight;
    int sum = 0;

    public Random_497(int[][] rects) {
        this.rects = rects;
        rand = new Random();
        weight = new int[rects.length];
        for (int i = 0; i < rects.length; i++) {
            int[] rect = rects[i];

            // the right part means the number of points can be picked in this rectangle
            sum += (rect[2] - rect[0] + 1) * (rect[3] - rect[1] + 1);
            weight[i] = sum;
        }
    }

    public int[] pick() {
        int p = Arrays.binarySearch(weight, rand.nextInt(sum) + 1);
        if (p < 0) p = - p - 1;
        int[] rec = rects[p];
        int x = rec[0] + rand.nextInt(rec[2] - rec[0] + 1);
        int y = rec[1] + rand.nextInt(rec[3] - rec[1] + 1);
        return new int[]{x, y};
    }


    // Most voted solution using TreeMap
    /*
    TreeMap<Integer, Integer> map;
    int[][] rects;
    int sum;
    Random rnd= new Random();

    public Random_497(int[][] rects) {
        this.rects = rects;
        map = new TreeMap<>();
        sum = 0;

        for(int i = 0; i < rects.length; i++) {
            int[] rect = rects[i];

            // the right part means the number of points can be picked in this rectangle
            sum += (rect[2] - rect[0] + 1) * (rect[3] - rect[1] + 1);

            map.put(sum, i);
        }
    }

    public int[] pick() {
        // nextInt(sum) returns a num in [0, sum -1]. After added by 1, it becomes [1, sum]
        int c = map.ceilingKey( rnd.nextInt(sum) + 1);

        int[] rec = rects[map.get(c)];
        int x = rec[0] + rnd.nextInt(rec[2] - rec[0] + 1);
        int y = rec[1] + rnd.nextInt(rec[3] - rec[1] + 1);
        return new int[]{x, y};
    }
    */
}
