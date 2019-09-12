import java.util.ArrayDeque;
import java.util.Deque;

class Longest_720 {
    // Standard solution #2: Trie
    class TrieNode {
        int end;
        TrieNode[] next;
        
        TrieNode() {
            end = 0;
            next = new TrieNode[26];
        }
    }
    
    class Trie {
        TrieNode root;
        String[] words;
        
        Trie(String[] words) {
            root = new TrieNode();
            this.words = words;
            for (int i = 0; i < words.length; i++) {
                insert(words[i], i + 1);
            }
        }
        
        private void insert(String word, int idx) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (node.next[c - 'a'] == null)
                    node.next[c - 'a'] = new TrieNode();
                node = node.next[c - 'a'];
            }
            node.end = idx;
        }
        
        private String dfs() {
            String res = "";
            Deque<TrieNode> stack = new ArrayDeque<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                TrieNode node = stack.pop();
                if (node == root || node.end > 0) {
                    if (node != root) {
                        String word = words[node.end - 1];
                        if (word.length() > res.length() || word.length() == res.length() && word.compareTo(res) < 0) {
                            res = word;
                        }
                    }
                    for (TrieNode t : node.next) {
                        // Take care here
                        if (t != null) stack.push(t);
                    }
                }
            }
            return res;
        }
    }
    
    public String longestWord(String[] words) {
        Trie trie = new Trie(words);
        return trie.dfs();
    }
}