import java.util.HashMap;
import java.util.List;

public class Brick_554 {
    public int leastBricks(List<List<Integer>> wall) {
        // Use HashMap to store the frequency of each critical length
        HashMap<Integer,Integer> tmp = new HashMap<>();
        int count = 0;
        for (List<Integer> list:wall) {
            int length = 0;
            for (int i=0; i<list.size()-1; i++) {
                length += list.get(i);
                tmp.put(length, tmp.getOrDefault(length,0)+1);
                count  = Math.max(count, tmp.get(length));
            }
        }
        return wall.size()-count;
    }
}
