public class String_443 {
    public int compress(char[] chars) {
        // Standard solution
        int anchor = 0, write = 0;
        for (int read = 0; read < chars.length; read++) {
            if (read == chars.length - 1 || chars[read] != chars[read + 1]) {
                chars[write++] = chars[read];
                if (read > anchor) {
                    // This is how to convert an integer x to Char Array
                    // ("" + x).toCharArray()
                    for (char c : ("" + (read - anchor + 1)).toCharArray())
                        chars[write++] = c;
                }
                anchor = read + 1;
            }
        }
        return write;


        // My first solution
        /*
        int res = 0, i = 0, j = 0;
        while (i < chars.length) {
            int count = 1;
            while (i < chars.length - 1 && chars[i + 1] == chars[i]) {
                i++;
                count++;
            }
            res++;
            chars[j++] = chars[i++];
            if (count <= 1)
                continue;
            StringBuilder sb = new StringBuilder();
            while (count > 0) {
                res++;
                sb.insert(0, count % 10);
                count /= 10;
            }
            for (int k=0; k<sb.length(); k++)
                chars[j++] = sb.charAt(k);
        }
        return res;
        */
    }
}
