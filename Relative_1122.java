import java.util.*;

class Relative_1122 {
    // Most voted solution: couting sort
    /*
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int k = 0;
        int[] cnt = new int[1001], ans = new int[arr1.length];
        for (int i : arr1)                      // Count each number in arr1.
            ++cnt[i];
        for (int i : arr2)                      // Sort the common numbers in both arrays by the order of arr2.
            while (cnt[i]-- > 0)
                ans[k++] = i;
        for (int i = 0; i < 1001; ++i)          // Sort the numbers only in arr1.
            while (cnt[i]-- > 0)
                ans[k++] = i;
        return ans;
    }
    */



    // My first solution
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr2.length; i++) {
            map.put(arr2[i], i);
        }

        Integer[] A = new Integer[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            A[i] = arr1[i];
        }

        Comparator<Integer> myComparator = new Comparator<Integer>(){
            @Override
            public int compare(Integer a, Integer b) {
                if (map.containsKey(a) && map.containsKey(b)) {
                    return map.get(a) - map.get(b);
                } else if (!map.containsKey(a) && !map.containsKey(b)) {
                    return Integer.compare(a, b);
                } else {
                    return map.containsKey(a) ? -1 : 1;
                }
            }
        };
        
        Arrays.sort(A, myComparator);
        
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = A[i];
        }
        
        return arr1;
    }
}