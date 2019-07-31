import java.util.List;

class Valid_422 {
    // Most voted solution
    public boolean validWordSquare(List<String> words) {
        if (words == null || words.size() == 0) {
            return true;
        }
        int n = words.size();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < words.get(i).length(); j++) {
                if (j >= n || words.get(j).length() <= i || words.get(j).charAt(i) != words.get(i).charAt(j))
                    return false;
            }
        }
        return true;
    }



    // My first solution
    /*
    public boolean validWordSquare(List<String> words) {
        int R = words.size();
        int C = 0;
        for (String word : words) C = Math.max(C, word.length());
        for (int k = 0; k < Math.min(R, C); k++) {
            StringBuilder sb = new StringBuilder();
            for (String word : words) {
                if (k < word.length()) sb.append(word.charAt(k));
            }
            if (!sb.toString().equals(words.get(k))) {
                return false;
            }
        }
        return true;
    }
    */
}