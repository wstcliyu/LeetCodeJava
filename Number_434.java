public class Number_434 {
    // https://leetcode.com/problems/number-of-segments-in-a-string/solution/

    // Approach #1
    public int countSegments(String s) {
        /*
        String[] tokens = "".split("\\s++");
        tokens.length; // 1
        tokens[0]; // ""
        */
        String trimmed = s.trim();
        if (trimmed.equals("")) {
            return 0;
        }
        return trimmed.split("\\s+").length;
    }

    // Approach #2
    /*
    public int countSegments(String s) {
        int segmentCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if ((i == 0 || s.charAt(i-1) == ' ') && s.charAt(i) != ' ') {
                segmentCount++;
            }
        }
        return segmentCount;
    }
    */
}
