public class Repeated_459 {
    public boolean repeatedSubstringPattern(String s) {
        // Second voted solution
        int l = s.length();
        for (int i=l/2; i>=1; i--) {
            if (l % i != 0)
                continue;
            int m = l / i;
            String subS = s.substring(0, i);
            StringBuilder sb = new StringBuilder();
            for (int j=0; j<m; j++)
                sb.append(subS);
            if (sb.toString().equals(s))
                return true;
        }
        return false;


        // Most voted solution, which can be finished in 1 line
        // return (s + s).substring(1, 2 * s.length() - 1).contains(s);
    }
}
