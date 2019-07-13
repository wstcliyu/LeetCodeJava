import java.util.*;

class Find_760 {
    public int[] anagramMappings(int[] A, int[] B) {
	// Good practice for HashMap and List
        int n = A.length;
        int[] res = new int[n];

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(B[i], k -> new ArrayList<>()).add(i);
        }

        for (int i = 0; i < n; i++) {
            List<Integer> ls = map.get(A[i]);
            res[i] = ls.remove(ls.size() - 1);
        }

        return res;
    }
}
