import java.util.HashSet;
import java.util.Set;

public class Distribute_575 {
    public static int distributeCandies(int[] candies) {
        Set<Integer> set = new HashSet<>();
        for (int candy:candies)
            set.add(candy);
        return Math.min(candies.length/2, set.size());
    }
}
