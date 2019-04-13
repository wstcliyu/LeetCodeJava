import java.util.*;

class Find_719 {
    // Using similar method with Kth_378

    // Priority Queue (TLE, 16/19 passed)
    // Since k += n(n+1)/2, the time complexity is O(n^2 lgn)
    /*
    public int smallestDistancePair(int[] nums, int k) {
        int n = nums.length;
        k += n * (n + 1) / 2;
        Arrays.sort(nums);
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.<int[]>comparingInt(pair -> nums[pair[0]] - nums[n - 1 - pair[1]]));
        for (int i = 0; i < n; i++)
            pq.add(new int[]{i, 0});
        while (--k > 0) {
            int[] p = pq.poll();
            if (++p[1] < n)
                pq.add(p);
        }
        return nums[pq.peek()[0]] - nums[n - 1 - pq.peek()[1]];
    }
    */




    // Binary Search
    // Time: O(nlgn) + O(n * lg(MAX - MIN)), Space: O(1)
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        k += n * (n + 1) / 2;
        int l = nums[0] - nums[n - 1];
        int r = nums[n - 1] - nums[0];
        for (int cnt = 0; l < r; cnt = 0) {
            int m = l + (r - l) / 2;
            for (int i = 0, j = n - 1; i < n; i++) {
                while (j >= 0 && nums[i] - nums[n - 1 - j] > m) j--;
                cnt += (j + 1);
            }
            if (cnt < k) 
                l = m + 1;
            else 
                r = m;
        }
        return r;

        // Standard solution #3: binary search + sliding window
        /*
        Arrays.sort(nums);
    
        int n = nums.length;
        int l = 0;
        int r = nums[n - 1] - nums[0];
        
        for (int cnt = 0; l < r; cnt = 0) {
            int m = l + (r - l) / 2;
            
            for (int i = 0, j = 0; i < n; i++) {
                while (j < n && nums[j] - nums[i] <= m) j++;
                cnt += j - i - 1;
            }
            
            if (cnt < k) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        
        return l;
        */
    }




    // Zigzag Search
    // Time: O(n^2), Space: O(1)
    /*
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        k += n * (n + 1) / 2;
        int row = 0;
        int col = n - 1;
        
        for (int cnt_le = 0, cnt_lt = 0; true; cnt_le = 0, cnt_lt = 0) {
            for (int i = 0, j = n - 1, p = n - 1; i < n; i++) {
                while (j >= 0 && nums[i] - nums[n - 1 - j] > nums[row] - nums[n - 1 -col]) j--;
                cnt_le += (j + 1);
                
                while (p >= 0 && nums[i] - nums[n - 1 - p] >= nums[row] - nums[n - 1 - col]) p--;
                cnt_lt += (p + 1);
            }
            if (cnt_le < k) 
                row++;
            else if (cnt_lt >= k)
                col--;
            else
                return nums[row] - nums[n - 1 - col];
        }
    }
    */
}