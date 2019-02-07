import java.util.*;

public class Array_954 {
    // Standard solution: HashMap and sort array by absolute value
    /*
    public boolean canReorderDoubled(int[] A) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int a : A) freq.put(a, 1 + freq.getOrDefault(a, 0));
        Integer[] B = new Integer[A.length];
        for (int i = 0; i < A.length; i++) B[i] = A[i];
        Arrays.sort(B, Comparator.comparing(Math::abs));
        for (int b : B) {
            if (freq.get(b) == 0) continue;
            if (freq.getOrDefault(2*b, 0) <= 0) return false;

            freq.put(b, -1 + freq.get(b));
            freq.put(2*b, -1 + freq.get(2*b));
        }
        return true;
    }
    */


    // Most voted solution: TreeMap and match from smallest to largest
    // One way is that start from the biggest (with abosolute value smallest),

    // Another way is that start from the smallest (with abosolute value biggest),
    // and we try to find x/2 each turn. (The following method uses the second way)
    public boolean canReorderDoubled(int[] A) {
        Map<Integer, Integer> count = new TreeMap<>();
        for (int a : A)
            count.put(a, count.getOrDefault(a, 0) + 1);
        for (int x : count.keySet()) {
            if (count.get(x) == 0) continue;
            int want = x < 0 ? x / 2 : x * 2;
            if (x < 0 && x % 2 != 0 || count.get(x) > count.getOrDefault(want, 0))
                return false;
            count.put(want, count.get(want) - count.get(x));
        }
        return true;
    }
}
