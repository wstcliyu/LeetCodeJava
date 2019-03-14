class Find_436 {
    // My solution using binary search
    public int[] findRightInterval(Interval[] intervals) {
        int N = intervals.length;
        Integer[] indices = new Integer[N];
        for (int i = 0; i < N; i++) indices[i] = i;
        Arrays.sort(indices, Comparator.comparing((Integer index) -> intervals[index].start));
        int[] res = new int[N];
        for (int i = 0; i < N; i++) {
            int p = myBinarySearch(intervals, indices, intervals[i].end);
            res[i] = p < N ? indices[p] : -1;
        }
        return res;
    }
    
    private int myBinarySearch(Interval[] intervals, Integer[] indices, int target) {
        int l = 0, r = indices.length;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (intervals[indices[m]].start < target)
                l = m + 1;
            else
                r = m;
        }
        return r;
    }




    // Most voted solution using TreeMap
    /*
    public int[] findRightInterval(Interval[] intervals) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int N = intervals.length;
        for (int i = 0; i < N; i++)
            map.put(intervals[i].start, i);
        int[] res = new int[N];
        for (int i = 0; i < N; i++) {
            Map.Entry<Integer, Integer> entry = map.ceilingEntry(intervals[i].end);
            res[i] = entry != null ? entry.getValue() : -1;
        }
        return res;
    }
    */




    // Good submission using buckets
    /*
    public int[] findRightInterval(Interval[] intervals) {
        int N = intervals.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (Interval i : intervals) {
            min = Math.min(min, i.start);
            max = Math.max(max, i.end);
        }

        int[] buckets = new int[max - min + 1];
        Arrays.fill(buckets, -1);

        for (int i = 0; i < N; i++) {
            buckets[intervals[i].start - min] = i;
        }
        for (int i = buckets.length - 2; i >= 0; i--) {
            if (buckets[i] == -1) buckets[i] = buckets[i + 1];
        }

        int[] res = new int[N];
        for (int i = 0; i < N; i++) 
            res[i] = buckets[intervals[i].end - min];
        return res;
    }
    */
}