import java.util.TreeMap;

public class Hand_846 {
	// My first solution (similar with standard solution)
	public boolean isNStraightHand(int[] hand, int W) {
        if (hand.length % W != 0) return false;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int card : hand) 
            map.put(card, 1 + map.getOrDefault(card, 0));
        int start = 0;
        for (int i = 0; i < hand.length/W; i++) {
            for (int j = 0; j < W; j++) {
                if (j % W == 0) 
                    start = map.firstKey();
                else if (!map.containsKey(++start))
                    return false;
                map.put(start, -1 + map.get(start));
                map.remove(start, 0);
            }
        }
        return true;
    }



    // Most voted solution
    // https://leetcode.com/problems/hand-of-straights/discuss/135598/C%2B%2BJavaPython-O(MlogM)-Complexity
    // Time: O(MlgM + MW), M is the number of different cards
	/*
    public boolean isNStraightHand(int[] hand, int W) {
        if (hand.length % W != 0) return false;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int card : hand) 
            map.put(card, 1 + map.getOrDefault(card, 0));
        for (int start : map.keySet()) {
            if (map.get(start) > 0) {
                int count = map.get(start);
                for (int i = 0; i < W; i++) {
                    if (map.getOrDefault(start + i, 0) < count)
                        return false;
                    map.put(start + i, map.get(start + i) - count);
                }
            }
        }
        return true;
    }
    */
}