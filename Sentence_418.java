class Sentence_418 {
    // Most voted solution
    public int wordsTyping(String[] sentence, int rows, int cols) {
        String s = String.join(" ", sentence) + " ";
        int start = 0, L = s.length();
        for (int i = 0; i < rows; i++) {
            start += cols;
            if (s.charAt(start % L) == ' ') {
                start++;
            } else {
                while (start > 0 && s.charAt((start-1) % L) != ' ') {
                    start--;
                }
            }
        }
        
        return start / L;
    }



    // My first solution (TLE): refer to Text_68
    /*
    public int wordsTyping(String[] sentence, int rows, int cols) {
        int N = sentence.length;
        int n = 0;
        for (int i = 0; i < rows; i++) {
            for (int l = 0, k = 0; l + sentence[n % N].length() <= cols - k; n++, k++) {
                l += sentence[n % N].length();
            }
        }
        return n / N;
    }
    */
}