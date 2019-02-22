import java.util.*;

public class Top_347 {

    // Standard solution using min heap
    // Time: O(Nlog(k)). The complexity of Counter method is O(N). To build a heap and output list takes O(Nlog(k)). 
    // Hence the overall complexity of the algorithm is O(N+Nlog(k))=O(Nlog(k))
    // Space : O(N) to store the hash map
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> count = new HashMap();
        for (int n: nums) count.put(n, count.getOrDefault(n, 0) + 1);

        // init heap 'the less frequent element first'
        PriorityQueue<Integer> minHeap =
                new PriorityQueue<Integer>((n1, n2) -> count.get(n1) - count.get(n2));
        // My version
        // PriorityQueue<Integer> minHeap =
        //        new PriorityQueue<Integer>(k+1, Comparator.comparing((Integer i) -> count.get(i)));


        // keep k top frequent elements in the heap
        for (int n: count.keySet()) {
            minHeap.add(n);
            if (minHeap.size() > k) minHeap.poll();
        }

        // build output list
        // My version: return new ArrayList<>(minHeap);
        List<Integer> top_k = new LinkedList();
        while (!minHeap.isEmpty()) top_k.add(minHeap.poll());
        Collections.reverse(top_k);
        return top_k;
    }


    // My first solution using max heap
    /*
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> count = new HashMap();
        for (int n: nums) count.put(n, count.getOrDefault(n, 0) + 1);

        PriorityQueue<Integer> maxHeap =
                new PriorityQueue<Integer>((n1, n2) -> count.get(n2) - count.get(n1));
        maxHeap.addAll(count.keySet());

        List<Integer> top_k = new LinkedList();
        for (int i = 0; i < k; i++) top_k.add(maxHeap.poll());
        return top_k;
    }
    */


    // Most voted solution using bucket sort
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


    // Using TreeMap whose <key, value> = <frequency, num>
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int num : nums) count.put(num, 1 + count.getOrDefault(num, 0));

        TreeMap<Integer, List<Integer>> freqMap = new TreeMap<>();
        for (int num : count.keySet()) {
            int freq = count.get(num);
            freqMap.putIfAbsent(freq, new ArrayList<>());
            freqMap.get(freq).add(num);
        }

        List<Integer> res = new ArrayList<>();
        while (res.size() < k) res.addAll(freqMap.pollLastEntry().getValue());
        return res;
    }
}
