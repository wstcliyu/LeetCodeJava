import java.util.ArrayList;
import java.util.List;

public class Missing_163 {
    // This problem has two corner cases (this solution just settles the second):
    // (1) The last element is Integer.MAX_VALUE. It causes next = a[i] + 1 overflow
    // (2) The array is empty but still we need to print lo and hi
    public List<String> findMissingRanges(int[] nums, int lo, int hi) {
        List<String> res = new ArrayList<>();
        if (nums.length == 0) {
            res.add(getRange(lo, hi));
            return res;
        }

         // the next number we need to find
        int next = lo;

        for (int num : num) {
            // not within the range yet
            if (num < next) continue;

            // continue to find the next one
            if (num == next) {
                if (num == Integer.MAX_VALUE) return res;
                next++;
                continue;
            }

            // get the missing range string format
            res.add(getRange(next, num - 1));

            if (num == Integer.MAX_VALUE) return res;

            // now we need to find the next number
            next = num + 1;
        }

        // do a final check
        if (next <= hi) res.add(getRange(next, hi));

        return res;
    }

    String getRange(int n1, int n2) {
        return (n1 == n2) ? String.valueOf(n1) : String.format("%d->%d", n1, n2);
    }
}
