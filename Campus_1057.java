import java.util.*;

class Campus_1057 {
    // Most voted solution: bucket sort
    /*
    class Bucket {
        List<int[]> ls = new ArrayList<>();
        Bucket() {
            ls = new ArrayList<>();
        }
    }
    
    public int[] assignBikes(int[][] workers, int[][] bikes) {
        Bucket[] buckets = new Bucket[2001];
        int N = workers.length;
        int M = bikes.length;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int distance = Math.abs(workers[i][0] - bikes[j][0]) + Math.abs(workers[i][1] - bikes[j][1]);
                if (buckets[distance] == null) buckets[distance] = new Bucket();
                buckets[distance].ls.add(new int[]{i, j});
            }
        }
        
        int[] res = new int[N];
        Arrays.fill(res, -1);
        boolean[] bikeUsed = new boolean[M];
        for (int d = 0; d <= 2000; d++) {
            if (buckets[d] == null) continue;
            for (int[] p : buckets[d].ls) {
                if (res[p[0]] == -1 && !bikeUsed[p[1]]) {
                    res[p[0]] = p[1];
                    bikeUsed[p[1]] = true;
                }
            }
        }
        return res;
    }
    */



    // Second voted solution: Priority Queue (slower than most voted solution)
    public int[] assignBikes(int[][] workers, int[][] bikes) {
        Comparator<int[]> comp = Comparator.comparing((int[] p) -> p[0]).thenComparing(p -> p[1]).thenComparing(p -> p[2]);
        PriorityQueue<int[]> pq = new PriorityQueue<>(comp);
        int N = workers.length;
        int M = bikes.length;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int distance = Math.abs(workers[i][0] - bikes[j][0]) + Math.abs(workers[i][1] - bikes[j][1]);
                pq.add(new int[]{distance, i, j});
            }
        }
        int[] res = new int[N];
        Arrays.fill(res, -1);
        Set<Integer> bikeUsed = new HashSet<>();
        while (bikeUsed.size() < N) {
            int[] p = pq.poll();
            if (res[p[1]] == -1 && !bikeUsed.contains(p[2])) {
                res[p[1]] = p[2];
                bikeUsed.add(p[2]);
            }
        }
        return res;
    }
}