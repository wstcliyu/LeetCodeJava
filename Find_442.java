import java.util.ArrayList;
import java.util.List;

public class Find_442 {
    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        int n = nums.length;
        for (int i=0; i<n; i++) {
            int val = Math.abs(nums[i]) - 1;
            if (nums[val] > 0)
                nums[val] = -nums[val];
            else result.add(val+1);
        }
        return result;
    }
    public static void main (String args[]) {
        int[] testNums = {4,3,2,7,8,2,3,1};
        List<Integer> testList = findDuplicates(testNums);
        System.out.println(testList);
    }
}
