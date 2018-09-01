public class Reverse_541 {

    // Standard solution, better organized
    /*
    public String reverseStr(String s, int k) {
        char[] a = s.toCharArray();
        for (int start = 0; start < a.length; start += 2 * k) {
            int i = start, j = Math.min(start + k - 1, a.length - 1);
            while (i < j) {
                char tmp = a[i];
                a[i++] = a[j];
                a[j--] = tmp;
            }
        }
        return new String(a);
    }
    */


    // My first solution
    public String reverseStr(String s, int k) {
        StringBuilder sb = new StringBuilder(s);
        int len = s.length();
        for (int i=0; i<len; i+=2*k) {
            if (i + k -1 < len)
                helper(sb, i, i+k-1);
            else
                helper(sb, i, len-1);
        }
        return sb.toString();
    }
    private void helper(StringBuilder sb, int l, int r) {
        while(l < r) {
            char c = sb.charAt(l);
            sb.setCharAt(l++, sb.charAt(r));
            sb.setCharAt(r--, c);
        }
    }
}
