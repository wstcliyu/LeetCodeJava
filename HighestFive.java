import java.util.*;

public class HighestFive {
    // Amazon OA 2: Highest Five
    private class Product {
        int productID, productRating;
    }

    public Map<Integer, Double> getHighFive(List<Product> ls) {
        Map<Integer, Double> res = new HashMap<>();
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        for (Product pt : ls) {
            map.putIfAbsent(pt.productID, new PriorityQueue<>());
            PriorityQueue<Integer> q = map.get(pt.productID);
            q.add(pt.productRating);
            if (q.size() > 5) q.poll();
        }
        for (Integer id : map.keySet()) {
            PriorityQueue<Integer> q = map.get(id);
            int sum = 0;
            while (!q.isEmpty()) sum += q.poll();
            res.put(id,  sum / 5.0); // (double) sum / 5
        }
        return res;
    }
}
