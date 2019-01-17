public class Find_287 {
    public static int findDuplicate(int[] nums) {
        // Floyd's Algorithm
        // https://leetcode.com/problems/find-the-duplicate-number/discuss/134813/javascript-soution:-beats-99.35-runtime-56ms.-Using-linked-list
        int slow = 0, fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        fast = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }


    // Binary Search
    // https://leetcode.com/problems/find-the-duplicate-number/discuss/72844/Two-Solutions-(with-explanation)%3A-O(nlog(n))-and-O(n)-time-O(1)-space-without-changing-the-input-array
    /*
    public int findDuplicate(int[] nums) {
        int left = 1, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            int count = 0;
            for (int num : nums) 
                if (num <= mid) count++;
            if (count <= mid)
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }
    */
}
