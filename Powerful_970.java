import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Powerful_970 {
    // Second voted solution
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> s = new HashSet<>();
        for (int i = 1; i < bound; i *= x > 1 ? x : bound)
            for (int j = 1; i + j <= bound; j *= y > 1 ? y : bound)
                s.add(i + j);
        return new ArrayList<>(s);
    }


    // Most voted solution
    /*
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> result = new HashSet<>();
        for (int a = 1; a < bound; a *= x) {
            for (int b = 1; a + b <= bound; b *= y) {
                result.add(a + b);
                if (y == 1) break;
            }
            if (x == 1) break;
        }
        return new ArrayList<>(result);
    }
    */


    // Standard solution
    /*
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> seen = new HashSet();
        for (int i = 0; i < 18 && Math.pow(x, i) <= bound; ++i)
            for (int j = 0; j < 18 && Math.pow(y, j) <= bound; ++j) {
                int v = (int) Math.pow(x, i) + (int) Math.pow(y, j);
                if (v <= bound)
                    seen.add(v);
            }

        return new ArrayList(seen);
    }
    */
}
