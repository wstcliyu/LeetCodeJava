import java.util.ArrayList;
import java.util.List;

public class Partition_763 {
    public static List<Integer> partitionLabels(String S) {
        ArrayList<Integer> res = new ArrayList<>();
        int[] last = new int[26];
        for (int i=0; i<S.length(); i++)
            last[S.charAt(i) - 'a'] = i;
        int start = -1, end = 0;
        for (int i=0; i<S.length(); i++) {
            end = Math.max(end, last[S.charAt(i) - 'a']);
            // Terminating condition
            if (end == i) {
                res.add(end - start);
                start = end;
                end = 0;
            }
        }
        return res;
    }
    public static void main (String[] args) {
        String testS = "ababcbacadefegdehijhklij";
        System.out.println(partitionLabels(testS).toString());
    }
}
