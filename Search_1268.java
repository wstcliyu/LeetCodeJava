import java.util.*;

class Search_1268 {
    // My second solution: Sort and Binary Search
    /*
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> res = new ArrayList<>();
        Arrays.sort(products);
        String prefix = "";
        for (char c : searchWord.toCharArray()) {
            prefix += c;
            int idx = myBinarySearch(products, prefix);
            List<String> ls = new ArrayList<>();
            for (int i = idx; i < products.length && ls.size() < 3; i++) {
                if (products[i].startsWith(prefix)) {
                    ls.add(products[i]);
                }
            }
            res.add(ls);
        }
        return res;
    }
    
    private int myBinarySearch(String[] products, String prefix) {
        int l = 0, r = products.length;
        while (l < r) {
            int m = (l + r) / 2;
            if (products[m].compareTo(prefix) < 0) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return r;
    }
    */



    // My first solution: Trie
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> res = new ArrayList<>();
        List<String> ls = new ArrayList<>();
        TrieNode root = buildTrie(products);
        for (int i = 0; i < searchWord.length(); i++) {
            char c = searchWord.charAt(i);
            if (root != null) root = root.next[c - 'a'];
            if (root == null) {
                res.add(ls);
            } else {
                searchForPrefix(root, ls);
                res.add(new ArrayList<>(ls));
                ls.clear();
            }
        }
        return res;
    }
    
    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            addWord(root, word);
        }
        return root;
    }
    
    private void addWord(TrieNode root, String word) {
        for (char c : word.toCharArray()) {
            if (root.next[c - 'a'] == null)
                root.next[c - 'a'] = new TrieNode();
            root = root.next[c - 'a'];
        }
        root.str = word;
    }
    
    private void searchForPrefix(TrieNode root, List<String> ls) {
        if (ls.size() == 3) return;
        if (root.str != null)
            ls.add(root.str);
        for (TrieNode node : root.next) {
            if (node != null) {
                searchForPrefix(node, ls);
            }
        }
    }
    
    class TrieNode {
        String str;
        TrieNode[] next;
        TrieNode() {
            str = null;
            next = new TrieNode[26];
        }
    }
}