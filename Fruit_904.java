import java.util.HashMap;

public class Fruit_904 {
    // My solution using sliding window
    public int totalFruit(int[] tree) {
        int res = 0;
        HashMap<Integer, Integer> freq = new HashMap<>();
        int j = 0;
        for (int i = 0; i < tree.length; i++) {
            freq.put(tree[i], 1 + freq.getOrDefault(tree[i], 0));
            while (freq.size() > 2) {
                freq.put(tree[j], freq.get(tree[j]) - 1);
                freq.remove(tree[j++], 0);
            }
            res = Math.max(res, i - j + 1);
        }
        return res;
    }

    // Most voted solution
    // https://leetcode.com/problems/fruit-into-baskets/discuss/170745/Problem%3A-Longest-Subarray-With-2-Elements
    // a and b are the last two different types of fruit that we met, c is the current fruit type
    /*
    public int totalFruit(int[] tree) {
        int res = 0, cur = 0, count_b = 0, a = 0, b = 0;
        for (int c :  tree) {
            cur = c == a || c == b ? cur + 1 : count_b + 1;
            count_b = c == b ? count_b + 1 : 1;
            if (b != c) {a = b; b = c;}
            res = Math.max(res, cur);
        }
        return res;
    }
    */
}
