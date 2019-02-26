public class Add_211 {
    // Refer to Implement_208

    class TrieNode {
        private final int R = 26;
        private TrieNode[] links;
        boolean isEnd;

        public TrieNode() {
            links = new TrieNode[R];
            isEnd = false;
        }

        public boolean containsKey(char ch) {
            return links[ch - 'a'] != null;
        }

        public TrieNode get(char ch) {
            return links[ch - 'a'];
        }

        public void put(char ch, TrieNode node) {
            links[ch - 'a'] = node;
        }

        public void setEnd() {
            isEnd = true;
        }

        public boolean isEnd() {
            return isEnd;
        }
    }

    private TrieNode root;

    /** Initialize your data structure here. */
    public Add_211() {
        root = new TrieNode();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!node.containsKey(ch)) node.put(ch, new TrieNode());
            node = node.get(ch);
        }
        node.setEnd();
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return search(word, 0, root);
    }

    private boolean search(String word, int idx, TrieNode node) {
        if (idx == word.length()) return node.isEnd();
        char ch = word.charAt(idx);
        if (ch == '.') {
            for (int j = 0; j < node.links.length; j++) {
                if (node.links[j] != null && search(word, idx+1, node.links[j]))
                    return true;
            }
        }
        else
            return node.containsKey(ch) && search(word, idx+1, node.get(ch));

        return false;
    }
}
