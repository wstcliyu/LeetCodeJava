import java.util.Arrays;

public class TwoSum_167 {
    public static int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            if (numbers[left]+numbers[right] == target)
                return new int[]{left+1, right+1};
            if (numbers[left]+numbers[right] < target)
                left = moveLeftTo(numbers, target, left, right);
            else
                right = moveRightTo(numbers, target, left, right);
        }
        return new int[]{left+1, right+1};
    }
    // This is a very good practice for binary search
    // moverRightTo() returns the index of the largest number <= target - numbers[left]
    public static int moveRightTo(int[] numbers, int target, int left, int right) {
        target -= numbers[left];
        while (left < right) {
            int mid = (left + right) / 2;
            if (numbers[mid] > target)
                right = mid - 1;
            else if (numbers[mid + 1] > target) // should use > rather than >=, otherwise it goes wrong when numbers[mid+1]==target
                return mid;
            else
                left = mid + 1;
        }
        return left;
    }
    // moverLeftTo() returns the index of the smallest number >= target - numbers[right]
    public static int moveLeftTo(int[] numbers, int target, int left, int right) {
        target -= numbers[right];
        while (left < right) {
            int mid = (left + right) / 2;
            if (numbers[mid] < target)
                left = mid + 1;
            else if (numbers[mid - 1] < target)
                return mid;
            else
                right = mid - 1;
        }
        return left;
    }
    public static void main (String args[]) {
        int[] testNums = {12,83,104,129,140,184,199,300,306,312,321,325,341,344,349,356,370,405,423,444,446,465,471,491,500,506,508,530,539,543,569,591,606,607,612,614,623,627,645,662,670,685,689,726,731,737,744,747,764,773,778,787,802,805,811,819,829,841,879,905,918,918,929,955,997};
        int testTarget = 789;
        System.out.println(Arrays.toString(twoSum(testNums,testTarget)));
    }
}
