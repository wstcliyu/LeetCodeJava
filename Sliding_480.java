class Sliding_480 {
	// Refer to Find_295 for similar question

	// 3rd voted solution: TreeSet
	// Time: O(nlgk), because treeset take O(lgk) to remove(element)
	// https://leetcode.com/problems/sliding-window-median/discuss/96348/Java-solution-using-two-PriorityQueues
	// This author likes JAVA lambda
    public double[] medianSlidingWindow(int[] nums, int k) {
        Comparator<Integer> comparator = (a, b) -> nums[a] != nums[b] ? Integer.compare(nums[a], nums[b]) : a - b;
	    TreeSet<Integer> left = new TreeSet<>(comparator.reversed());
	    TreeSet<Integer> right = new TreeSet<>(comparator);
	    
	    Supplier<Double> median = (k % 2 == 0) ?
	        () -> ((double) nums[left.first()] + nums[right.first()]) / 2 :
	        () -> (double) nums[right.first()];
	    
	    // balance lefts size and rights size (if not equal then right will be larger by one)
	    Runnable balance = () -> { while (left.size() > right.size()) right.add(left.pollFirst()); };
	    
	    double[] result = new double[nums.length - k + 1];
	    
	    for (int i = 0; i < k; i++) left.add(i);
	    balance.run(); result[0] = median.get();
	    
	    for (int i = k, r = 1; i < nums.length; i++, r++) {
	        // remove tail of window from either left or right
	        if(!left.remove(i - k)) right.remove(i - k);

	        // add next num, this will always increase left size
	        right.add(i); left.add(right.pollFirst());
	        
	        // rebalance left and right, then get median from them
	        balance.run(); result[r] = median.get();
	    }
	    
	    return result;
    }



    // Rewrite the solution above
    /*
    TreeSet<Integer> left, right;
    int[] nums;
    
    public double[] medianSlidingWindow(int[] nums, int k) {
        Comparator<Integer> comp = new Comparator<Integer>(){
            @Override
            public int compare(Integer a, Integer b) {
                 return nums[a] != nums[b] ? Integer.compare(nums[a], nums[b]) : Integer.compare(a, b);
            }
        };
        left = new TreeSet<>(comp.reversed());
        right = new TreeSet<>(comp);
        int n = nums.length;
        if (n < k) return new double[0];
        this.nums = nums;
        double[] res = new double[n - k + 1];
        for (int i = 0; i < n; i++) {
            add(i);
            if (i >= k - 1) {
                res[i - k + 1] = getMedian();
                remove(i - k + 1);
            }
        }
        return res;
    }
    
    private void add(int num) {
        left.add(num);
        right.add(left.pollFirst());
        while (left.size() < right.size()) {
            left.add(right.pollFirst());
        }
    }
    
    private void remove(int num) {
        double median = getMedian();
        if (nums[num] <= median) {
            left.remove(num);
        } else {
            right.remove(num);
        }
    }
    
    private double getMedian() {
        return left.size() > right.size() ? nums[left.first()] : ((double)nums[left.first()] + (double)nums[right.first()]) * 0.5;
    }
    */




    // Rewrite most voted solution: Heap
    /*
    PriorityQueue<Integer> maxHeap, minHeap;
    
    public double[] medianSlidingWindow(int[] nums, int k) {
        maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        minHeap = new PriorityQueue<>();
        int n = nums.length;
        if (n < k) return new double[0];
        double[] res = new double[n - k + 1];
        for (int i = 0; i < n; i++) {
            add(nums[i]);
            if (i >= k - 1) {
                res[i - k + 1] = getMedian();
                remove(nums[i - k + 1]);
            }
        }
        return res;
    }
    
    private void add(int num) {
        maxHeap.add(num);
        minHeap.add(maxHeap.poll());
        while (maxHeap.size() < minHeap.size()) {
            maxHeap.add(minHeap.poll());
        }
    }
    
    private void remove(int num) {
        double median = getMedian();
        if (num <= median) {
            maxHeap.remove(num);
        } else {
            minHeap.remove(num);
        }
    }
    
    private double getMedian() {
        return maxHeap.size() > minHeap.size() ? maxHeap.peek() : ((double)minHeap.peek() + (double)maxHeap.peek()) * 0.5;
    }
    */
}