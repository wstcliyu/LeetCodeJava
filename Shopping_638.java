import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Shopping_638 {
    // Standard solution #2: Using Recursion with memorization
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        Map<List<Integer>, Integer> map = new HashMap<>();
        return shopping(price, special, needs, map);
    }

    public int shopping(List<Integer> price, List<List<Integer>> special, List<Integer> needs, Map<List<Integer>, Integer> map) {
        if (map.containsKey(needs)) return map.get(needs);
        int j, res = dot(needs, price);
        for (List <Integer> s: special) {
            // ArrayList <Integer> clone = new ArrayList<>(needs);
            ArrayList <Integer> clone = new ArrayList<>();
            for (j = 0; j < needs.size(); j++) {
                int diff = needs.get(j) - s.get(j);
                if (diff < 0) break;
                // clone.set(j, diff);
                clone.add(diff);
            }
            if (j == needs.size()) res = Math.min(res, s.get(j) + shopping(price, special, clone, map));
        }
        map.put(needs, res);
        return res;
    }

    public int dot(List <Integer> a, List <Integer> b) {
        int sum = 0;
        for (int i = 0; i < a.size(); i++) sum += a.get(i) * b.get(i);
        return sum;
    }


    // My solution using backtrack (similar idea with standard solution)
    /*
    int res = Integer.MAX_VALUE;
    List<Integer> price, needs;
    List<List<Integer>> special;

    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        if (needs.size() == 0) return 0;
        this.price = price;
        this.needs = needs;
        this.special = special;
        backtrack(new int[needs.size()], 0);
        return res;
    }

    private void backtrack(int[] portfolio, int sum) {
        int tmp = sum;
        for (int i = 0; i < portfolio.length; i++) {
            int dif = needs.get(i) - portfolio[i];
            if (dif < 0) return;
            else tmp += dif * price.get(i);
        }
        res = Math.min(res, tmp);
        for (List<Integer> v : special) {
            for (int i = 0; i < portfolio.length; i++) portfolio[i] += v.get(i);
            backtrack(portfolio, sum + v.get(portfolio.length));
            for (int i = 0; i < portfolio.length; i++) portfolio[i] -= v.get(i);
        }
    }
    */
}
