import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Random_519 {

    // Similar with Random_710

    int R, C, total;
    Map<Integer, Integer> map;
    Random rand;

    public Random_519(int n_rows, int n_cols) {
        R = n_rows;
        C = n_cols;
        total = R * C;
        map = new HashMap<>();
        rand = new Random();
    }

    public int[] flip() {
        int i = rand.nextInt(total--);
        int res = map.getOrDefault(i, i);
        map.put(i, map.getOrDefault(total, total));
        map.put(total, res);
        // Adding this line (Line 22) so that we don't need to clear the map for reset
        // because map.clear() takes O(n) time
        // Line 20~22 actually swap the stored values of key i and total
        return new int[]{res / C, res % C};
    }

    public void reset() {
        total = R * C;
    }
}
