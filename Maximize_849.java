public class Maximize_849 {
    public int maxDistToClosest(int[] seats) {
        int last = -1, first = seats.length;
        int prev = -1, dist = 0;
        for (int i=0; i<seats.length; i++) {
            if (seats[i] == 1) {
                first = Math.min(first, i);
                last = Math.max(last, i);
                if (prev != -1)
                    dist = Math.max(dist, i - prev);
                prev = i;
            }
        }
        int res = Math.max(first, seats.length - 1 - last);
        return Math.max(res, dist / 2);
    }
}
