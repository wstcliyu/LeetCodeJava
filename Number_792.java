import java.util.*;

class Number_792 {
    // My solution: Binary Search
    /*
    public int numMatchingSubseq(String S, String[] words) {
        List<List<Integer>> indices = new ArrayList<>();
        for (int i = 0; i < 26; i++) indices.add(new ArrayList<>());
        for (int i = 0; i < S.length(); i++) {
            indices.get(S.charAt(i) - 'a').add(i);
        }
        int res = 0;
        for (String w : words) {
            int target = 0;
            int i = 0;
            for (; i < w.length(); i++) {
                List<Integer> ls = indices.get(w.charAt(i) - 'a');
                int l = 0, r = ls.size();
                while (l < r) {
                    int m = (l + r) / 2;
                    if (ls.get(m) < target) {
                        l = m + 1;
                    } else {
                        r = m;
                    }
                }
                if (r == ls.size()) break;
                target = ls.get(r) + 1;
            }
            if (i == w.length()) res++;
        }
        return res;
    }
    */



    // Standard solution #2
    // 
    public int numMatchingSubseq(String S, String[] words) {
        List<Deque<Node>> ls = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            ls.add(new ArrayDeque<>());
        }
        for (String w : words) {
            ls.get(w.charAt(0) - 'a').add(new Node(w, 0));
        }
        int res = 0;
        for (char c : S.toCharArray()) {
            Deque<Node> q = ls.get(c - 'a');
            for (int k = q.size(); k > 0; k--) {
                Node node = q.removeFirst();
                if (++node.idx == node.word.length()) {
                    res++;
                } else {
                    ls.get(node.word.charAt(node.idx) - 'a').add(node);
                }
            }
        }
        return res;
    }
    
    class Node {
        String word;
        int idx;
        Node(String w, int i) {
            word = w;
            idx = i;
        }
    }
}