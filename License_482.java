public class License_482 {

    // My first solution
    /*
    public String licenseKeyFormatting(String S, int K) {
        StringBuilder res = new StringBuilder();
        StringBuilder tmp = new StringBuilder();
        for (int i=S.length()-1; i>=0; i--) {
            char c = S.charAt(i);
            if (c == '-')
                continue;
            if (Character.isLetter(c))
                c = Character.toUpperCase(c);
            tmp.insert(0, c);
            if (tmp.length() == K) {
                res.insert(0, "-" + tmp);
                tmp = new StringBuilder();
            }
        }
        if (tmp.length() != 0)
            return res.insert(0, tmp).toString();
        return res.length() == 0 ? "" : res.deleteCharAt(0).toString();
    }
    */


    // Most voted solution
    public String licenseKeyFormatting(String S, int K) {
        StringBuilder sb = new StringBuilder();
        for (int i=S.length()-1; i>=0; i--) {
            if (S.charAt(i) != '-')
                sb.append(sb.length() % (K + 1) == K ? "-" : "").append(S.charAt(i));
        }
        return sb.reverse().toString().toUpperCase();
    }
}
