import java.util.*;

class Split_659 {
    // Standard solution #2: Greedy
    /*
    public boolean isPossible(int[] nums) {
        Counter count = new Counter();
        Counter tails = new Counter();
        for (int x : nums) count.add(x, 1);

        for (int x : nums) {
            if (count.get(x) == 0) continue;
            if (tails.get(x) > 0) {
                tails.add(x, -1);
                tails.add(x + 1, 1);
            } else if (count.get(x + 1) > 0 && count.get(x + 2) > 0) {
                count.add(x + 1, -1);
                count.add(x + 2, -1);
                tails.add(x + 3, 1);
            } else {
                return false;
            }

            count.add(x, -1);
        }
        return true;
    }

    class Counter extends HashMap<Integer, Integer> {
        public int get(int k) {
            return containsKey(k) ? super.get(k) : 0;
        }

        public void add(int k, int v) {
            put(k, get(k) + v);
        }
    }
    */



    // Standard solution #2: Opening and Closing Events
    // The number of elements in queue starts is always equal to prevCount
    public boolean isPossible(int[] nums) {
        Deque<Integer> starts = new ArrayDeque<>();
        Integer prev = null;
        int prevCount = 0;
        int anchor = 0;

        for (int i = 0; i < nums.length; ++i) {
            int t = nums[i];

            if (i == nums.length - 1 || nums[i+1] != t) {
                int count = i - anchor + 1;
                if (prev != null && t - prev != 1) {
                    while (prevCount > 0) {
                        prevCount--;
                        if (prev < starts.removeFirst() + 2) return false;
                    }
                    prev = null;
                }

                if (prev == null || t - prev == 1) {
                    while (prevCount > count) {
                        prevCount--;
                        if (t-1 < starts.removeFirst() + 2) return false;
                    }
                    while (prevCount++ < count)
                        starts.add(t);
                }

                prev = t;
                prevCount = count;
                anchor = i+1;
            }
        }

        while (prevCount-- > 0)
            if (nums[nums.length - 1] < starts.removeFirst() + 2)
                return false;

        return true;
    }



    // My first solution (very slow)
    // I ignored the condition that the array is sorted in ascending order
    // The idea to store the lengths of the chains with the same ending element in a Priority Queue
    // Maintein a HashMap which maps the end of chains to the queue
    // Loop through all elements and add each one to the end of a shortest chain
    /*
    public boolean isPossible(int[] nums) {
        HashMap<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        for (int num : nums) {
            int len = 0;
            if (!map.getOrDefault(num - 1, new PriorityQueue<>()).isEmpty()) 
                len = map.get(num - 1).poll();
            map.computeIfAbsent(num, z -> new PriorityQueue<>()).add(len + 1);
        }
        
        for (Map.Entry<Integer, PriorityQueue<Integer>> entry : map.entrySet()) {
            for (int v : entry.getValue()) if (v < 3) return false;
        }
        
        return true;
    }
    */
}