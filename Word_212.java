import java.util.*;

public class Word_212 {
    class TrieNode {
        TrieNode[] next = new TrieNode[26];
        String word;
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String w : words) {
            TrieNode p = root;
            for (int i = 0; i < w.length(); i++) {
                char ch = w.charAt(i);
                if (p.next[ch - 'a'] == null)
                    p.next[ch - 'a'] = new TrieNode();
                p = p.next[ch - 'a'];
            }
            p.word = w;
        }
        return root;
    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        TrieNode root = buildTrie(words);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root, res);
            }
        }
        return res;
    }

    private void dfs(char[][] board, int i, int j, TrieNode p, List<String> res) {
        char c = board[i][j];
        if (c == '#' || p.next[c - 'a'] == null) return;
        p = p.next[c - 'a'];
        if (p.word != null) { // Find one string in dictionary
            res.add(p.word);
            p.word = null; // Avoid duplicate by removing it from dictionary
        }
        board[i][j] = '#';
        if (i > 0) dfs(board, i-1, j, p, res);
        if (j > 0) dfs(board, i, j-1, p, res);
        if (i < board.length - 1) dfs(board, i+1, j, p, res);
        if (j < board[0].length - 1) dfs(board, i, j+1, p, res);
        board[i][j] = c;
    }
}
