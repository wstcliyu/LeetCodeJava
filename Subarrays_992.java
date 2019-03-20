class Subarrays_992 {
    // Good submission
    // prefix saves how many elements in front of j but removing them will not affect cnt
    public int subarraysWithKDistinct(int[] A, int K) {
        int[] m = new int[A.length + 1];
        int res = 0, prefix = 0;
        for (int i = 0, j = 0, cnt = 0; i < A.length; ++i) {
            if (m[A[i]]++ == 0) ++cnt;

            if (cnt > K) {
                --m[A[j++]]; 
                --cnt; 
                prefix = 0; 
            }

            while (m[A[j]] > 1) {
                ++prefix; 
                --m[A[j++]]; 
            }

            if (cnt == K) res += prefix + 1;
        }
        return res;
    }



    // Standard solution using two sliding windows
    /*
    public int subarraysWithKDistinct(int[] A, int K) {
        Map<Integer, Integer> map1 = new HashMap<Integer, Integer>();
        Map<Integer, Integer> map2 = new HashMap<Integer, Integer>();
        int res = 0, left1 = 0, left2 = 0;
        for (int i = 0; i < A.length; i++) {
            int x = A[i];
            map1.put(x, 1 + map1.getOrDefault(x, 0));
            map2.put(x, 1 + map2.getOrDefault(x, 0));
            
            while (map1.size() > K) {
                int t1 = A[left1++];
                map1.put(t1, -1 + map1.get(t1));
                map1.remove(t1, 0);
            }
            
            while (map2.size() >= K) {
                int t2 = A[left2++];
                map2.put(t2, -1 + map2.get(t2));
                map2.remove(t2, 0);
            }
            
            res += left2 - left1;
        }
        
        return res;
    }
    */




    // Most voted solution
    /*
    public int subarraysWithKDistinct(int[] A, int K) {
        return atMostK(A, K) - atMostK(A, K - 1);
    }

    int atMostK(int[] A, int K) {
        int i = 0, res = 0;
        Map<Integer, Integer> count = new HashMap<>();
        for (int j = 0; j < A.length; ++j) {
            if (count.getOrDefault(A[j], 0) == 0) K--;
            count.put(A[j], count.getOrDefault(A[j], 0) + 1);
            while (K < 0) {
                count.put(A[i], count.get(A[i]) - 1);
                if (count.get(A[i]) == 0) K++;
                i++;
            }
            res += j - i + 1;
        }
        return res;
    }
    */
}