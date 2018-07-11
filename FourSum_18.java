import java.awt.*;
import java.util.*;
import java.util.List;

public class FourSum_18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new LinkedList<>();
        if (nums == null || nums.length < 4)
            return res;
        int n = nums.length;
        Arrays.sort(nums);
        // My first solution using HashMap
        /*
        HashMap<Integer, ArrayList<Point>> map = new HashMap<>();
        for (int i=0; i<n-1; i++) {
            for (int j=i+1; j<n; j++) {
                int sum = nums[i] + nums[j];
                ArrayList<Point> tmp = new ArrayList<>();
                if (map.containsKey(sum))
                    tmp = map.get(sum);
                tmp.add(new Point(i, j));
                map.put(sum, tmp);
            }
        }
        for (int i=0; i<n-1; i++) {
            if (i>0 && nums[i]==nums[i-1])
                continue;
            for (int j=i+1; j<n; j++) {
                if (j>i+1 && nums[j]==nums[j-1])
                    continue;
                if (map.containsKey(target - nums[i] - nums[j])) {
                    for (Point p : map.get(target - nums[i] - nums[j])) {
                        if (p.x > j) {
                            List<Integer> tmpList = res.peekLast();
                            if (tmpList != null && nums[i] == tmpList.get(0) && nums[j] == tmpList.get(1) && nums[p.x] == tmpList.get(2) && nums[p.y] == tmpList.get(3))
                                continue;
                            res.add(Arrays.asList(nums[i], nums[j], nums[p.x], nums[p.y]));
                        }
                    }
                }
            }
        }
        return res;
        */
        for (int i=0; i<n-3; i++) {
            if (i>0 && nums[i]==nums[i-1])
                continue;
            threeSumForFourSum(nums, target-nums[i], i+1, n-1, res, nums[i]);
        }
        return res;
    }
    private void threeSumForFourSum(int[] nums, int target, int low, int high, List<List<Integer>> ls, int first) {
        for (int i=low; i<high-1; i++) {
            if (i>low && nums[i]==nums[i-1])
                continue;
            twoSumForFourSum(nums, target-nums[i], i+1, high, ls, first, nums[i]);
        }
    }
    private void twoSumForFourSum(int[] nums, int target, int low, int high, List<List<Integer>> ls, int first, int second) {
        while (low < high) {
            if (nums[low] + nums[high] < target)
                low++;
            else if (nums[low] + nums[high] > target)
                high--;
            else {
                ls.add(Arrays.asList(first, second, nums[low], nums[high]));
                do {
                    low++;
                } while(low < high && nums[low] == nums[low-1]);
                do {
                    high--;
                } while(low < high && nums[high] == nums[high+1]);
            }
        }
    }
    public static void main (String args[]) {
        // int[] testNums = {0,0,0,0};
        int[] testNums = {-3, -2, -1, 0, 0, 1, 2, 3};
        List<List<Integer>> testRes = new FourSum_18().fourSum(testNums, 0);
        for (List<Integer> i:testRes)
            System.out.println(Arrays.toString(i.toArray()));
    }
}
