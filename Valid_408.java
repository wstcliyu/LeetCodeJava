class Valid_408 {
    // My solution
    public boolean validWordAbbreviation(String word, String abbr) {
        int i = 0, j = 0;
        int n = word.length();
        int m = abbr.length();
        while (i < n && j < m) {
            int num = 0;
            while (j < m && Character.isDigit(abbr.charAt(j))) {
                num = num * 10 + abbr.charAt(j++) - '0';
                // If there is a leading zero, then num == 0, return false
                // Test Case: word = "a", abbr = "01"
                if (num == 0) return false;
            }
            
            i += num;

            if (i < n && j < m) {
                if (word.charAt(i) != abbr.charAt(j))
                    return false;
                else {
                    i++;
                    j++;
                }
            }            
        }
        return i == n && j == m;
    }
}