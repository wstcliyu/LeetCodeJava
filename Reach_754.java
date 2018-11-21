public class Reach_754 {
    // My solution using binary search
    // Time: O(log(sqrt(N)))
    public int reachNumber(int target) {
        if (target < 0)
            return reachNumber(-target);
        int left = 1, right = 45000;
        while (left < right) {
            int mid = (left + right) / 2;
            int sum = mid * (mid + 1) / 2;
            if (sum == target)
                return mid;
            else if (sum < target)
                left = mid + 1;
            else
                right = mid;
        }
        int sum = left * (left + 1) / 2;
        if ((sum - target) % 2 == 0)
            return left;
        else if (left % 2 == 0)
            return left + 1;
        else
            return left + 2;
    }

    // Most voted solution, same thinking as mine, but without binary search
    // Time: O(sqrt(N))
    /*
    public int reachNumber(int target) {
        target = Math.abs(target);
        int step = 0;
        int sum = 0;
        while (sum < target) {
            step++;
            sum += step;
        }
        while ((sum - target) % 2 != 0) {
            step++;
            sum += step;
        }
        return step;
    }
    */
}
