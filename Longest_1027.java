import java.util.*;

class Longest_1027 {
    // Top-down DP
    public int longestArithSeqLength(int[] A) {
        int res = 0;
        List<Map<Integer, Integer>> ls = new ArrayList<>();
        
        for (int i = 0; i < A.length; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < i; j++) {
                int diff = A[i] - A[j];
                int length = 1 + ls.get(j).getOrDefault(diff, 1);
                res = Math.max(res, length);
                map.put(diff, length);
            }
            ls.add(map);
        }
        
        return res;
    }
}