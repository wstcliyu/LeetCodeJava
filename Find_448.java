import java.util.ArrayList;
import java.util.List;

public class Find_448 {
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        int n = nums.length;
        for (int i=0; i<n; i++) {
            int val = Math.abs(nums[i]) - 1;
            if (nums[val] > 0)
                nums[val] = -nums[val];
        }
        for (int i=0; i<n; i++) {
            if (nums[i] > 0)
                result.add(i+1);
        }
        return result;
    }
    public static void main (String args[]) {
        int[] testNums = {4,3,2,7,8,2,3,1};
        List<Integer> testList = findDisappearedNumbers(testNums);
        System.out.println(testList);
    }
}
