class Bold_758 {
    // Rewrite most voted solution
    public String boldWords(String[] words, String S) {
        boolean[] marked = new boolean[S.length()];
        for (String word : words) markWords(word, S, marked);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            if (marked[i] && (i == 0 || !marked[i - 1]))
                sb.append("<b>");
            sb.append(S.charAt(i));
            if (marked[i] && (i == S.length() - 1 || !marked[i + 1]))
                sb.append("</b>");
        }
        return sb.toString();
    }
    
    private void markWords(String word, String S, boolean[] marked) {
        for (int i = S.indexOf(word); i >= 0 && i + word.length() <= S.length(); i = S.indexOf(word, i + 1)) {
            Arrays.fill(marked, i, i + word.length(), true);
        }
    }
}