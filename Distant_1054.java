import java.util.*;

class Distant_1054 {
    // My first solution
    public int[] rearrangeBarcodes(int[] barcodes) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int b : barcodes)
            map.put(b, 1 + map.getOrDefault(b, 0));
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(Comparator.comparing((Map.Entry<Integer, Integer> entry) -> -entry.getValue()));
        pq.addAll(map.entrySet());
        int[] res = new int[barcodes.length];
        int t = 0;
        while (!pq.isEmpty()) {
            Map.Entry<Integer, Integer> entry = pq.poll();
            for (int j = 0; j < entry.getValue(); j++) {
                res[t] = entry.getKey();
                t += 2;
                if (t >= barcodes.length) t = 1;
            }
        }
        return res;
    }
}