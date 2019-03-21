import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Comparator;

class Minimum_857 {
    public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
        int N = quality.length;
        Worker[] workers = new Worker[N];
        for (int i = 0; i < N; i++)
            workers[i] = new Worker(quality[i], wage[i]);
        Arrays.sort(workers);
        
        PriorityQueue<Integer> pool = new PriorityQueue<>(Comparator.reverseOrder());
        int totalQuality = 0;
        double res = Double.MAX_VALUE;
        for (Worker worker : workers) {
            pool.add(worker.quality);
            totalQuality += worker.quality;
            if (pool.size() > K) 
                totalQuality -= pool.poll();
            if (pool.size() == K)
                res = Math.min(res, worker.ratio * totalQuality);
        }
        return res;
    }
    
    
    private class Worker implements Comparable<Worker> {
        int quality, wage;
        double ratio;
        Worker(int _q, int _w) {
            quality = _q;
            wage = _w;
            ratio = (double) wage / quality;
        }
        
        @Override
        public int compareTo(Worker that) {
            return Double.compare(this.ratio, that.ratio);
        }
    }
}