import java.awt.*;
import java.util.*;
import java.util.List;

public class FourSum_18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        HashMap<Integer, ArrayList<Point>> map = new HashMap<>();
        int n = nums.length;
        for (int i=0; i<n-1; i++) {
            if (i+1<n-1 && nums[i] == nums[i+1])
                continue;
            for (int j=i+1; j<n; j++) {
                if (j-1>=i+1 && nums[j] == nums[j-1])
                    continue;
                int sum = nums[i] + nums[j];
                ArrayList<Point> tmp = new ArrayList<>();
                if (map.containsKey(sum))
                    tmp = map.get(sum);
                tmp.add(new Point(i, j));
                map.put(sum, tmp);
            }
        }
        for (int sum : map.keySet()) {
            if (map.containsKey(target-sum)) {
                for (Point p1 : map.get(sum)) {
                    for (Point p2 : map.get(target-sum)) {
                        if (p1.y < p2.x)
                            res.add(Arrays.asList(nums[p1.x], nums[p1.y], nums[p2.x], nums[p2.y]));
                    }
                }
            }
        }
        return res;
    }
    public static void main (String args[]) {
        int[] testNums = {-3, -2, -1, 0, 0, 1, 2, 3};
        List<List<Integer>> testRes = new FourSum_18().fourSum(testNums, 0);
        for (List<Integer> i:testRes)
            System.out.println(Arrays.toString(i.toArray()));
    }
}
