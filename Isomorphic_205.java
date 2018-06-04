public class Isomorphic_205 {
    public boolean isIsomorphic(String s, String t) {
        if (s.equals(t))
            return true;
        // Use two arrays to store the latest index of each character
        int[] sa = new int[128];
        int[] ta = new int[128];
        for (int i=0; i<s.length(); i++) {
            if (sa[s.charAt(i)] != ta[t.charAt(i)])
                return false;
            sa[s.charAt(i)] = i+1;
            ta[t.charAt(i)] = i+1;
        }
        return true;
    }
}
