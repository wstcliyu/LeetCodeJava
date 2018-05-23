import java.util.HashMap;
import java.util.Map;

public class Rabbits_781 {
    public static int numRabbits(int[] answers) {
        int res = 0;
        Map<Integer, Integer> ans_nums = new HashMap<>();
        for (int ans:answers)
            ans_nums.put(ans, ans_nums.getOrDefault(ans, 0)+1);
        for (int k:ans_nums.keySet())
            res += Math.ceil(1.0*ans_nums.get(k)/(k+1))*(k+1);
        return res;
    }
}
