public class Compare_165 {
    // Most voted solution
    public int compareVersion(String version1, String version2) {
        // You need to escape the dot if you want to split on a literal dot
        // Otherwise you are splitting on the regex . which means "any single character"
        // Note the double backslash needed to create a single backslash in the regex
        String[] levels1 = version1.split("\\.");
        String[] levels2 = version2.split("\\.");
        int length = Math.max(levels1.length, levels2.length);
        for (int i=0; i<length; i++) {
            Integer v1 = i < levels1.length ? Integer.parseInt(levels1[i]) : 0;
            Integer v2 = i < levels2.length ? Integer.parseInt(levels2[i]) : 0;
            if (v1 < v2)
                return -1;
            if (v1 > v2)
                return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        int test1 = "a.b".split("\\.").length;
        int test2 = "a.".split("\\.").length;
        int test3 = ".b".split("\\.").length;
        // https://stackoverflow.com/questions/14833008/java-string-split-with-dot
        // split(regex) removes all trailing blanks from the result,
        // but since splitting a dot on a dot leaves only two blanks,
        // after trailing blanks are removed you're left with an empty array.
        int test4 = ".".split("\\.").length;
        int test5 = ".".split("\\.",-1).length;
        System.out.println(test4);
    }

    // My first solution
    /*
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        if (v1.length < v2.length)
            return -helper(v2, v1);
        return helper(v1, v2);
    }
    private int helper(String[] v1, String[] v2) {
        for (int i=0; i<v1.length; i++) {
            int a1 = Integer.valueOf(v1[i]);
            if (i >= v2.length) {
                if (a1 > 0)
                    return 1;
                else if (a1 == 0)
                    continue;
            }
            int a2 = Integer.valueOf(v2[i]);
            if (a1 > a2)
                return 1;
            if (a1 < a2)
                return -1;
        }
        return 0;
    }
    */
}
