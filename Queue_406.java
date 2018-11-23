import java.util.ArrayList;
import java.util.Arrays;

public class Queue_406 {
    // https://leetcode.com/problems/queue-reconstruction-by-height/discuss/89359/Explanation-of-the-neat-Sort%2BInsert-solution

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> (a[0] != b[0] ? b[0] - a[0] : a[1] - b[1]));
        ArrayList<int[]> res = new ArrayList<>();
        for (int[] p : people)
            res.add(p[1], p);
        return res.toArray(new int[0][0]);
    }
}
