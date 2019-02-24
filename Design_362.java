import java.util.ArrayDeque;

public class Design_362 {
    // Most voted solution
    // This solution has better time and space complexity than mine
    // And it can well handle the case that the number of hits per second is huge

    private int[] times;
    private int[] hits;

    /** Initialize your data structure here. */
    public Design_362() {
        times = new int[300];
        hits = new int[300];
    }

    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        int index = timestamp % 300;
        if (times[index] != timestamp) {
            times[index] = timestamp;
            hits[index] = 1;
        } else {
            hits[index]++;
        }
    }

    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        int total = 0;
        for (int i = 0; i < 300; i++) {
            if (timestamp - times[i] < 300) {
                total += hits[i];
            }
        }
        return total;
    }



    // My solution (Accepted)
    /*
    ArrayDeque<Integer> q;

    public Design_362() {
        q = new ArrayDeque<>();
    }

    public void hit(int timestamp) {
        helper(timestamp);
        q.addLast(timestamp);
    }

    public int getHits(int timestamp) {
        helper(timestamp);
        return q.size();
    }

    private void helper(int timestamp) {
        while (!q.isEmpty() && q.getFirst() <= timestamp - 300) q.removeFirst();
    }
    */
}
