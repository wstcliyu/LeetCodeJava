import java.util.Comparator;
import java.util.PriorityQueue;

public class ShortestJobFirst {
    // Amazon OA 2: Shortest Job First
    /*
    A processor has to deal with requests one by one. When processing one request,
    some other requests arriving during this period have to get queued. They are sorted
    based on their exeTime and then arriving time.

    Array arr[] represent the arriving time of each request and they are sorted.
    Array dur[] represent the exeTime of each request.
    We need to calculate the total waiting time for all the requests and return the average waiting time.
     */

    class Process {
        int arrTime, exeTime;
        Process(int _arr, int _dur) {
            arrTime = _arr;
            exeTime = _dur;
        }
    }

    public float Solution(int[] arr, int[] dur) {
        if (arr == null || dur == null || arr.length != dur.length) return 0;
        int index = 0, length = arr.length;
        int waitTime = 0, curTime = 0;
        PriorityQueue<Process> pq = new PriorityQueue<>
                (Comparator.comparing((Process p) -> p.exeTime).thenComparing(p -> p.arrTime));

        while (!pq.isEmpty() || index < length) {
            if (!pq.isEmpty()) {
                Process cur = pq.poll();
                waitTime += curTime - cur.arrTime;
                curTime += cur.exeTime;
                while (index < length && curTime >= arr[index])
                    pq.offer(new Process(arr[index], dur[index++]));
            }
            else {
                pq.offer(new Process(arr[index], dur[index]));
                curTime = arr[index++];
            }
        }
        return (float) waitTime / length;
    }
}
