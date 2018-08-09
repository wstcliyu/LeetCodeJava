import java.util.Arrays;

public class Assign_455 {
    // My solution is the same as the most voted solution
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int j = 0;
        for (int i=0; i<s.length && j<g.length; i++)
            if (s[i] >= g[j])
                j++;
        return j;
    }
}
