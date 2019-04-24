import java.util.*;

class Car_853 {
    // My first solution (similar to standard solution)
    public int carFleet(int target, int[] position, int[] speed) {
        int N = position.length;
        if (N == 0) return 0;
        Integer[] idx = new Integer[N];
        for (int i = 0; i < N; i++) idx[i] = i;
        Arrays.sort(idx, Comparator.<Integer>comparingInt(i -> position[i]).reversed());
        int prePos = position[idx[0]];
        int preSpe = speed[idx[0]];
        int res = 1;
        for (int i = 0; i < N; i++) {
            int index = idx[i];
            if ((target - position[index]) * 1.0 / speed[index] > (target - prePos) * 1.0 / preSpe) {
                res++;
                prePos = position[index];
                preSpe = speed[index];
            }
        }
        return res;
    }




    // Good submission using bucket sort
    // Bucket sort works here because the problem requires all initial positions are different
    /*
    public int carFleet(int target, int[] position, int[] speed) {
        int res = 0;
        int[] bucket = new int[target];
        int n = position.length;

        for (int i = 0; i < n; i++) bucket[position[i]] = speed[i];

        double cur = 0;
        for (int k = bucket.length - 1; k >= 0; k--) {
            if (bucket[k] != 0) {
                double time = (double) (target - k) / bucket[k];

                if (time > cur) {
                    res ++;
                    cur = time;
                }
            }
        }

        return res;
    }
    */
}