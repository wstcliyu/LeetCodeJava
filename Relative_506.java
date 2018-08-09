import java.util.Arrays;

public class Relative_506 {
    // Most voted solution using two-dimension array
    /*
    public String[] findRelativeRanks(int[] nums) {
        String[] res = new String[nums.length];
        int[][] pair = new int[nums.length][2];
        for (int i=0; i<nums.length; i++) {
            pair[i][0] = nums[i];
            pair[i][1] = i;
        }
        Arrays.sort(pair, (a, b) -> b[0] - a[0]);
        for (int i=0; i<nums.length; i++) {
            if (i == 0)
                res[pair[i][1]] = "Gold Medal";
            if (i == 1)
                res[pair[i][1]] = "Silver Medal";
            if (i == 2)
                res[pair[i][1]] = "Bronze Medal";
            if (i > 2)
                res[pair[i][1]] = i + 1 + "";
        }
        return res;
    }
    */


    // Most voted solution using one-dimension array
    // Arrays.sort(index, (a, b) -> nums[b] - nums[a])
    // index is an Integer array. We must not use Primitive Data Types here.
    public String[] findRelativeRanks(int[] nums) {
        String[] res = new String[nums.length];
        Integer[] index = new Integer[nums.length];
        for (int i=0; i<nums.length; i++)
            index[i] = i;
        Arrays.sort(index, (a, b) -> nums[b] - nums[a]);
        for (int i=0; i<nums.length; i++) {
            if (i == 0)
                res[index[i]] = "Gold Medal";
            if (i == 1)
                res[index[i]] = "Silver Medal";
            if (i == 2)
                res[index[i]] = "Bronze Medal";
            if (i > 2)
                res[index[i]] = i + 1 + "";
        }
        return res;
    }
}
