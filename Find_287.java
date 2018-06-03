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
}
