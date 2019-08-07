import java.util.*;

class Top_692 {
    // Standard solution #2: Heap
    /*
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> freq = new HashMap<>();
        for (String word : words) {
            freq.put(word, 1 + freq.getOrDefault(word, 0));
        }
        // PriorityQueue<String> pq = new PriorityQueue<>((w1, w2) -> freq.get(w1) == freq.get(w2) ? w2.compareTo(w1) : freq.get(w1) - freq.get(w2));
        PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>(){
            @Override
            public int compare(String w1, String w2) {
                return freq.get(w1) == freq.get(w2) ? w2.compareTo(w1) : freq.get(w1) - freq.get(w2);
            }
        });
        for (String word : freq.keySet()) {
            pq.add(word);
            if (pq.size() > k) pq.poll();
        }
        LinkedList<String> res = new LinkedList<>();
        while (!pq.isEmpty()) res.addFirst(pq.poll());
        return res;
    }
    */



    // Second voted solution: Trie and bucket sort
    class TrieNode {
        TrieNode[] next;
        String word;
        TrieNode() {
            this.next = new TrieNode[26];
            this.word = null;
        }
    }
    
    private void addWord(TrieNode root, String word) {
        for (char c : word.toCharArray()) {
            if (root.next[c - 'a'] == null)
                root.next[c - 'a'] = new TrieNode();
            root = root.next[c - 'a'];
        }
        root.word = word;
    }
    
    private void getWord(TrieNode root, List<String> res, int k) {
        // if (root == null) return;
        if (root.word != null) res.add(root.word);
        if (res.size() == k) return;
        for (TrieNode node : root.next) {
            if (node != null)
                getWord(node, res, k);
        }
    }
    
    public List<String> topKFrequent(String[] words, int k) {
        List<String> res = new ArrayList<>();
        
        Map<String, Integer> freq = new HashMap<>();
        for (String w : words) {
            freq.put(w, 1 + freq.getOrDefault(w, 0));
        }
        
        TrieNode[] count = new TrieNode[words.length + 1];
        for (Map.Entry<String, Integer> entry : freq.entrySet()) {
            int f = entry.getValue();
            if (count[f] == null) count[f] = new TrieNode();
            addWord(count[f], entry.getKey());
        }
        
        for (int f = count.length - 1; f >= 0 && res.size() < k; f--) {
            if (count[f] != null)
                getWord(count[f], res, k);
        }
        return res;
    }
}