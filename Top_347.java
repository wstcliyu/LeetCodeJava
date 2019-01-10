import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Top_347 {

    // Standard solution using Heap
    // Time: O(Nlog(k)). The complexity of Counter method is O(N). To build a heap and output list takes O(Nlog(k)). 
    // Hence the overall complexity of the algorithm is O(N+Nlog(k))=O(Nlog(k))
    // Space : O(N) to store the hash map
    public List<Integer> topKFrequent(int[] nums, int k) {
        // build hash map : character and how often it appears
        HashMap<Integer, Integer> count = new HashMap();
        for (int n: nums) 
            count.put(n, count.getOrDefault(n, 0) + 1);

        // init heap 'the less frequent element first'
        PriorityQueue<Integer> heap =
                new PriorityQueue<Integer>((n1, n2) -> count.get(n1) - count.get(n2));

        // keep k top frequent elements in the heap
        for (int n: count.keySet()) {
            heap.add(n);
            if (heap.size() > k)
                heap.poll();
        }

        // build output list
        List<Integer> top_k = new LinkedList();
        while (!heap.isEmpty())
            top_k.add(heap.poll());

        Collections.reverse(top_k);
        return top_k;
    }

    // My solution using priority queue
    /*
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> count = new HashMap();
        for (int n: nums) 
            count.put(n, count.getOrDefault(n, 0) + 1);

        PriorityQueue<Integer> heap =
                new PriorityQueue<Integer>((n1, n2) -> count.get(n2) - count.get(n1));
        heap.addAll(count.keySet());

        List<Integer> top_k = new LinkedList();
        for (int i = 0; i < k; i++)
            top_k.add(heap.poll());
        return top_k;
    }
    */


    // Most voted solution
    // Time: O(n)
    /*
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashSet<Integer>[] bucket = new HashSet[nums.length + 1];
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int num : nums)
            freq.put(num, 1 + freq.getOrDefault(num, 0));
        for (int key : freq.keySet()) {
            int frequency = freq.get(key);
            if (bucket[frequency] == null)
                bucket[frequency] = new HashSet<>();
            bucket[frequency].add(key);
        }
        List<Integer> res = new ArrayList<>();
        for (int pos = bucket.length-1; pos>=0 && res.size()<k; pos--) {
            if (bucket[pos] != null)
                res.addAll(bucket[pos]);
        }
        return res;
    }
    */
}
