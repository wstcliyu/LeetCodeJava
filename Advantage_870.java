import java.util.*;

public class Advantage_870 {
    // My solution
    public int[] advantageCount(int[] A, int[] B) {
        Arrays.sort(A);
        int N = B.length;
        Integer[] idx = new Integer[N];
        for (int i = 0; i < N; i++) idx[i] = i;
        Arrays.sort(idx, Comparator.comparing(i -> B[i]));
        int[] res = new int[N];
        int i = 0, j = N-1;
        for (int a : A) {
            if (a > B[idx[i]]) res[idx[i++]] = a;
            else res[idx[j--]] = a;
        }
        return res;
    }


    // Use TreeMap
    /*
    public int[] advantageCount(int[] A, int[] B) {
        // the tree map stores <value, count> pairs of array A
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : A) map.put(num, map.getOrDefault(num, 0) + 1);

        // for each value in B, get the A entry with smallest higher key or the smallest key if not exist
        int[] res = new int[A.length];

        for (int i = 0; i < B.length; i++) {
            Map.Entry<Integer, Integer> matchingEntry = map.higherEntry(B[i]);
            if (matchingEntry == null) matchingEntry = map.firstEntry();

            res[i] = matchingEntry.getKey();
            if (matchingEntry.getValue() == 1) map.remove(matchingEntry.getKey());
            else map.put(matchingEntry.getKey(), matchingEntry.getValue() - 1);

        }

        return res;
    }
    */
}
