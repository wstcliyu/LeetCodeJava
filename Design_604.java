class Design_604 {
    // My solution similar to standard approach #3: Demand-Computation
    
    private String s;
    private char c;
    private int count, p;

    public Design_604(String compressedString) {
        s = compressedString;
        c = 0;
        p = 0;
        count = 0;
    }
    
    public char next() {
        if (count > 0) {
            --count;
            return c;
        } else if (p < s.length()) {
            c = s.charAt(p++);
            while (p < s.length() && Character.isDigit(s.charAt(p))) {
                count = count * 10 + s.charAt(p++) - '0';
            }
            return next();
        } else {
            return ' ';
        }
    }
    
    public boolean hasNext() {
        return count > 0 || p < s.length();
    }
}

/**
 * Your StringIterator object will be instantiated and called as such:
 * StringIterator obj = new StringIterator(compressedString);
 * char param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */