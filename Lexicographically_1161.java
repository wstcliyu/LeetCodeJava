class Lexicographically_1161 {
    // My first solution
    private int[] root;
    
    private int find(int x) {
        if (x == root[x]) return x;
        root[x] = find(root[x]);
        return root[x];
    }
    
    private void connect(int x, int y) {
        int X = find(x);
        int Y = find(y);
        if (X == Y) return;
        if (X < Y) root[Y] = X;
        else root[X] = Y;
    }
    
    
    public String smallestEquivalentString(String A, String B, String S) {
        root = new int[26];
        for (int i = 0; i < 26; i++) root[i] = i;
        for (int i = 0; i < A.length(); i++) {
            connect(A.charAt(i) - 'a', B.charAt(i) - 'a');
        }
        StringBuilder sb = new StringBuilder();
        for (char c : S.toCharArray()) {
            sb.append((char)(find(c - 'a') + 'a'));
        }
        return sb.toString();
    }
}