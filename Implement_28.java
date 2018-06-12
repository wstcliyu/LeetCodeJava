public class Implement_28 {
    public int strStr(String haystack, String needle) {
        /* Most voted solution
        for (int i = 0; ; i++) {
            for (int j = 0; ; j++) {
              if (j == needle.length())
                  return i;
              if (i + j == haystack.length())
                  return -1;
              if (needle.charAt(j) != haystack.charAt(i + j))
                  break;
            }
        }
        */

        // Good submission
        // return haystack.indexOf(needle);
        for (int i=0; i<haystack.length()-needle.length()+1; i++) {
            int j = 0;
            while (j<needle.length()) {
                if (haystack.charAt(i+j) != needle.charAt(j))
                    break;
                j++;
            }
            if (j == needle.length())
                return i;
        }
        return -1;
    }
}
