import java.util.HashMap;
import java.util.Random;

public class Random_710 {

    // Similar with Random_519

    Random rand;
    int M;
    HashMap<Integer, Integer> map;

    public Random_710(int N, int[] blacklist) {
        rand = new Random();
        M = N - blacklist.length;
        map = new HashMap<>();
        for (int b : blacklist)
            map.put(b, 0);
        for (int b : blacklist) {
            if (b >= M) continue;
            while (map.containsKey(--N))
                map.remove(N); // Deleting this line is also OK
            map.put(b, N);
        }
    }

    public int pick() {
        int r = rand.nextInt(M);
        return map.getOrDefault(r, r);
    }
}
