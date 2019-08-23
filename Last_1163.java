class Last_1163 {
    // My third solution: Brutal Force
    // Time: O(N^2), Space: O(N)
    /*
    public String lastSubstring(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            res = res.compareTo(s.substring(i)) < 0 ? s.substring(i) : res;
        }
        return res;
    }
    */



    // My first solution
    // Time: O(N^N), Space: O(N)
    // TLE (21/24 cases passed) when s is a long string with all characters equal
    /*
    public String lastSubstring(String s) {
        int N = s.length();
        StringBuilder sb = new StringBuilder();
        List<Integer> ls = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            ls.add(i);
        }
        while (!ls.isEmpty()) {
            int len = ls.size();
            char max = 'a';
            for (int i = 0; i < len; i++) {
                int idx = ls.get(i);
                if (s.charAt(idx) > max) max = s.charAt(idx);
            }
            sb.append(max);
            List<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                int idx = ls.get(i);
                if (s.charAt(idx) == max && idx + 1 < N) {
                    tmp.add(idx + 1);
                }
            }
            ls = tmp;
        }
        return sb.toString();
    }
    */



    // My second solution: Trie
    // Time: O(N^2), Space: O(N^2)
    // TLE (8/24 cases passed)
    /*
    final int R = 26;
    
    class TrieNode {
        TrieNode[] next;
        TrieNode() {
            next = new TrieNode[R];
        }
    }
    
    private TrieNode buildTrie(String s) {
        TrieNode root = new TrieNode();
        for (int i = 0; i < s.length(); i++) {
            TrieNode node = root;
            for (int j = i; j < s.length(); j++) {
                char c = s.charAt(j);
                if (node.next[c - 'a'] == null) {
                    node.next[c - 'a'] = new TrieNode();
                }
                node = node.next[c - 'a'];
            }
        }
        return root;
    }
    
    public String lastSubstring(String s) {
        TrieNode root = buildTrie(s);
        StringBuilder sb = new StringBuilder();
        int i = R - 1;
        while (i >= 0) {
            for (i = R - 1; i >= 0; i--) {
                if (root.next[i] != null) {
                    sb.append((char)('a' + i));
                    root = root.next[i];
                    break;
                }
            }
        }
        return sb.toString();
    }
    */
}