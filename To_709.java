public class To_709 {
    public String toLowerCase(String str) {
        // return str.toLowerCase();
        StringBuilder sb = new StringBuilder();
        for (char c:str.toCharArray()) {
            if (c - 'A' >= 0 && c - 'A' < 26)
                sb.append((char)(c+32));
            else
                sb.append(c);
        }
        return sb.toString();
    }


    // Most voted solution
    /*
    public String toLowerCase(String str) {
        char[] a = str.toCharArray();
        for (int i = 0; i < a.length; i++)
            if ('A' <= a[i] && a[i] <= 'Z')
                a[i] = (char) (a[i] - 'A' + 'a');
        return new String(a);
    }
    */
}
