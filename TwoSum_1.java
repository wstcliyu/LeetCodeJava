import java.util.HashMap;

public class TwoSum_1 {
    public static int[] twoSum(int[] nums, int target) {
        /* Brutal Force #1
        int n = nums.length;
        int[] result = new int[2];
        for(int i=0;i<n;i++) {
            for(int j=i+1;j<n;j++){
                if(nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;
        */
        /* Two-pass Hash Table #2
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] { i, map.get(complement) };
            }
        }
        throw new IllegalArgumentException("No two sum solution");
        */
        // One-pass Hash Table #3
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
    public static void main (String args[]) {
        int[] testNums = {2,7,11,15};
        int testTarget = 9;
        System.out.println(twoSum(testNums,testTarget)[0]);
        System.out.println(twoSum(testNums,testTarget)[1]);
    }
}
