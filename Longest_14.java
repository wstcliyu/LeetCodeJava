public class Longest_14 {
    public String longestCommonPrefix(String[] strs) {
        // For more solutions https://leetcode.com/problems/longest-common-prefix/solution/
        // My first solution
        StringBuilder res = new StringBuilder();
        if (strs == null || strs.length == 0)
            return res.toString();
        for (int i=0; i<strs[0].length(); i++) {
            // j must start from 0, not 1. Otherwise, it goes wrong if strs.length==1
            for (int j=0; j<strs.length; j++) {
                // Must add the first condition. Otherwise, the second condition will throw IndexOutOfBoundryException
                if (strs[j].length() <= i || strs[j].charAt(i) != strs[0].charAt(i))
                    return res.toString();
                if (j == strs.length-1)
                    res.append(strs[0].charAt(i));
            }
        }
        return res.toString();
    }
}
