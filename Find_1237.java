import java.util.*;

class Find_1237 {
    // My first solution: Binary Search
    // Time: O(YlgX) or O(XlgY)
    /*
    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> res = new ArrayList<>();
        for (int y = 1; y <= 1000 && customfunction.f(1, y) <= z; y++) {
            if (customfunction.f(1000, y) < z) continue;
            int x = getX(y, z, customfunction);
            if (customfunction.f(x, y) == z)
                res.add(Arrays.asList(x, y));
        }
        
        return res;
    }
    
    private int getX(int y, int z, CustomFunction customfunction) {
        int l = 1, r = 1000;
        while (l < r) {
            int m = (l + r) / 2;
            if (customfunction.f(m, y) < z) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return r;
    }
    */



    // Most voted solution from lee215
    // Time: O(X + Y)
    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> res = new ArrayList<>();
        int x = 1, y = 1000;
        while (x <= 1000 && y > 0) {
            int v = customfunction.f(x, y);
            if (v > z) --y;
            else if (v < z) ++x;
            else res.add(Arrays.asList(x++, y--));
        }
        return res;
    }
}