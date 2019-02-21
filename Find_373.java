import java.util.*;

public class Find_373 {
    // Similar with Kth_378
    // Consider a matrix M with M[i][j] = nums1[i] + nums2[j], then it's a sorted array in Kth_378
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> res = new LinkedList<>();
        if (nums1.length == 0 || nums2.length == 0 || k == 0) return res;
        PriorityQueue<int[]> heap = new PriorityQueue<>
                (Comparator.comparing((int[] index) -> nums1[index[0]] + nums2[index[1]]));

        // Alternative
        /*
        for (int i = 0; i < Math.min(nums1.length, k); i++)
            heap.add(new int[]{i, 0});
        for (int i = 0; i < k && !heap.isEmpty(); i++) {
            int[] index = heap.poll();
            res.add(new int[]{nums1[index[0]], nums2[index[1]]});
            if (index[1] < nums2.length - 1)
                heap.add(new int[]{index[0], index[1] + 1});
        }
        */

        heap.add(new int[]{0, 0});
        for (int i = 0; i < k && !heap.isEmpty(); i++) {
            int[] index = heap.poll();
            res.add(new int[]{nums1[index[0]], nums2[index[1]]});
            if (index[1] < nums2.length - 1)
                heap.add(new int[]{index[0], index[1] + 1});
            if (index[0] < nums1.length - 1 && index[1] == 0)
                heap.add(new int[]{index[0] + 1, index[1]});
        }

        return res;
    }
}
