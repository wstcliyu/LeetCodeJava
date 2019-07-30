import java.util.*;

class Path_1104 {
    public List<Integer> pathInZigZagTree(int label) {
        List<Integer> res = new LinkedList<>();
        int i = 31;
        for (; i >= 0 && (label & (1 << i)) == 0; i--);
        for (int level = i; level >= 0; label /= 2, level--) {
            res.add(0, label);
            label = (1 << (level + 1)) - 1 - label + (1 << level);
        }
        return res;
    }
}