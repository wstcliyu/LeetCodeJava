import java.util.HashSet;
import java.util.Set;

public class Jewels_771 {
    public static int numJewelsInStones(String J, String S) {
        // Use String_Object.toCharArray() to obtain char[]
        Set<Character> jewels = new HashSet<>();
        int res = 0;
        for (char c:J.toCharArray())
            jewels.add(c);
        for (char c:S.toCharArray())
            res += jewels.contains(c) ? 1 : 0;
        return res;
    }
}
