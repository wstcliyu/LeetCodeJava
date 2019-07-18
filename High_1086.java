import java.util.*;

class High_1086 {
    public int[][] highFive(int[][] items) {
    	// Good practice for TreeMap and PriorityQueue
        TreeMap<Integer, PriorityQueue<Integer>> map = new TreeMap<>();
        for (int[] item : items) {
            map.putIfAbsent(item[0], new PriorityQueue<>());
            PriorityQueue<Integer> q = map.get(item[0]);
            q.add(item[1]);
            if (q.size() > 5) {
                q.poll();
            }
        }
        
        int[][] res = new int[map.size()][2];
        int i = 0;
        for (Map.Entry<Integer, PriorityQueue<Integer>> entry : map.entrySet()) {
            PriorityQueue<Integer> q = entry.getValue();
            int count = q.size();
            int sum = 0;
            while (!q.isEmpty()) {
                sum += q.poll();
            }
            res[i][0] = entry.getKey();
            res[i++][1] = sum / count;
        }
        
        return res;
    }
}