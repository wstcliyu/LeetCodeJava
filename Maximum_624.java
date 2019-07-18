import java.util.List;

class Maximum_624 {
    // Only need to consider the min and max before the current row
    // Because the pair must be from two different rows,
    // there must be one row before another row
    public int maxDistance(List<List<Integer>> arrays) {
        int res = 0;
        int min = arrays.get(0).get(0);
        int max = arrays.get(0).get(arrays.get(0).size() - 1);
        for (int i = 1; i < arrays.size(); i++) {
            int cur_min = arrays.get(i).get(0);
            int cur_max = arrays.get(i).get(arrays.get(i).size() - 1);
            res = Math.max(res, Math.max(Math.abs(min - cur_max), Math.abs(max - cur_min)));
            min = Math.min(min, cur_min);
            max = Math.max(max, cur_max);
        }
        return res;
    }
}