public class Rotate_796 {
    public boolean rotateString(String A, String B) {
        // Most voted solution
        /*
        return A.length() == B.length() && (A + A).contains(B);
        */

        // My first solution
        int len = A.length();
        if (len != B.length())
            return false;
        if (len == 0)
            return true;
        for (int i=0; i<len; i++) {
            String tmp = A.substring(i, len) + A.substring(0, i);
            if (B.equals(tmp))
                return true;
        }
        return false;
    }
}
