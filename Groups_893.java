import java.util.Arrays;
import java.util.HashSet;

public class Groups_893 {
    // Most voted solution
    // For each String, we generate it's corresponding signature, and add it to the set
    public int numSpecialEquivGroups(String[] A) {
        HashSet<String> set = new HashSet<>();
        for (String a : A) {
            int[] even = new int[26];
            int[] odd = new int[26];
            for (int i=0; i<a.length(); i++) {
                if (i % 2 == 0)
                    even[a.charAt(i) - 'a'] ++;
                else
                    odd[a.charAt(i) - 'a'] ++;
            }
            String sig = Arrays.toString(even) + Arrays.toString(odd);
            set.add(sig);
        }
        return set.size();
    }
}
