import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum_15 {
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length-2; i++) {
            if (i > 0 && nums[i] == nums[i-1])
                continue;
            int left = i+1, right = nums.length-1, target = 0 - nums[i];
            while (left < right) {
                int[] twoSumRes = TwoSum_167.twoSumHelper_167(nums, target, left, right);
                if (twoSumRes != null) {
                    left = twoSumRes[0] - 1;
                    right = twoSumRes[1] - 1;
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    do {
                        left++;
                    } while (left < right && nums[left] == nums[left-1]);
                    do {
                        right--;
                    } while (left < right && nums[right] == nums[right+1]);
                }
                else
                    break;
            }
        }
        return res;
    }

/* Good submission
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    int min;
    int max;
    int[] hash;
	public List<List<Integer>> threeSum(int[] nums) {
		int len = nums.length;
		if (len < 3)
			return res;
        Arrays.sort(nums);

        int zeroCount;
        int lastNeg = Arrays.binarySearch(nums, 0);
        int firstPos = lastNeg;
        if(lastNeg < 0){
            zeroCount = 0;
            lastNeg = -(lastNeg + 1) - 1;
            firstPos = lastNeg + 1;
        }
        else{
            while(lastNeg > -1 && nums[lastNeg] == 0)
                lastNeg--;
            while(firstPos < len && nums[firstPos] == 0)
                firstPos++;
            zeroCount = firstPos - lastNeg - 1;
        }

		min = nums[0];
		max = nums[len - 1];
		// max = Math.max(Math.abs(max), Math.abs(min));
		// min = -max;
		hash = new int[max - min + 1];
		for (int v : nums) {
			hash[v - min]++;
		}

		if (zeroCount >= 3) { // 至少包含了3个0
			addTriplets(0, 0, 0);
		}
		if (zeroCount > 0 ) { // 包含了0
			for (int i = firstPos; i < len; i++) { //迭代正数, 看是否能找到绝对值相等的负数
                if(i > firstPos && nums[i] == nums[i - 1])
                    continue;
                if (-nums[i] - min > -1 && hash[-nums[i] - min] > 0)
					addTriplets(0, nums[i], -nums[i]);
			}
		}

		// 一个正数两个负数
		for (int i = firstPos; i < len; i++) { //对所有正数迭代, 看在负数中能否找到两个相应负数
            if(i > firstPos && nums[i] == nums[i - 1])
                    continue;
            int half;
            if(nums[i] % 2 != 0)
                half = -(nums[i] / 2 + 1);
            else{
                half = -(nums[i] / 2);
                if(half - min > -1 && hash[half - min] > 1)
                    addTriplets(nums[i], half, half);
            }
            for(int j = lastNeg; j > -1 && nums[j] > half; j--){
                if(j < lastNeg && nums[j] == nums[j + 1])
                    continue;
                if((-nums[i] - nums[j]) - min > -1 && hash[(-nums[i] - nums[j]) - min] > 0)
                    addTriplets(nums[i], nums[j], -nums[i] - nums[j]);
            }
        }

        // 一个负数两个正数
		for (int i = lastNeg; i > -1; i--) { //对负数迭代, 看在负数中能否找到两个相应正数
            if(i < lastNeg && nums[i] == nums[i + 1])
                    continue;
            int half;
            if(nums[i] % 2 != 0)
                half = -(nums[i] / 2 - 1);
            else{
                half = -(nums[i] / 2);
                if(half - min < hash.length && hash[half - min] > 1)
                    addTriplets(nums[i], half, half);
            }
            for(int j = firstPos; j < len && nums[j] < half; j++){
                if(j > firstPos && nums[j] == nums[j - 1])
                    continue;
                if((-nums[i] - nums[j]) - min < hash.length && hash[(-nums[i] - nums[j]) - min] > 0)
                    addTriplets(nums[i], nums[j], -nums[i] - nums[j]);
            }
        }
		return res;
	}

	public void addTriplets(int a, int b, int c) {
		List<Integer> triplets = new ArrayList<>(3);
		triplets.add(a);
		triplets.add(b);
		triplets.add(c);
		res.add(triplets);
	}
}
*/

    public static void main (String args[]) {
        int[] testNums = {0,3,0,1,1,-1,-5,-5,3,-3,-3,0};
        List<List<Integer>> testRes = threeSum(testNums);
        for (List<Integer> i:testRes)
            System.out.println(Arrays.toString(i.toArray()));
        //System.out.println(Arrays.deepToString(threeSum(testNums).toArray()));
    }
}
