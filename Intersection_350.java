import java.util.Arrays;
import java.util.HashMap;
import java.util.ArrayList;

public class Intersection_350 {
    // My first solution using HashMap
    // The time complexity for HashMap contains method is O(1)? Why?
    // Time: O(n1 + n2)
    // Space: O(min(n1, n2))

    // Follow up: What if elements of nums2 are stored on disk,
    // and the memory is limited such that you cannot load all elements into the memory at once?
    // Answer: If only nums2 cannot fit in memory, put all elements of nums1 into a HashMap,
    // read chunks of array that fit into the memory, and record the intersections.
    /*
    public static int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        ArrayList<Integer> intersection = new ArrayList<>();
        for (int num1 : nums1)
            freq.put(num1, 1 + freq.getOrDefault(num1, 0));
        for (int num2 : nums2) {
            if (freq.getOrDefault(num2, 0) > 0) {
                intersection.add(num2);
                freq.put(num2, freq.get(num2) - 1);
            }
        }
        int[] res = new int[intersection.size()];
        for (int i=0; i<intersection.size(); i++)
            res[i] = intersection.get(i);
        return res;
    }
    */

    // Follow up: What if the given array is sorted? What if both two arrays are huge?
    // Answer: If both nums1 and nums2 are so huge that neither fit into the memory, sort them individually (external sort),
    // then read 2 elements from each array at a time in memory, record intersections.

    // Two Pointers
    // Time: O(n1 + n2)
    // Space: O(1) if we don't consider the space of result; O(min(n1, n2)) otherwise.
    public static int[] intersect(int[] nums1, int[] nums2) {
        ArrayList<Integer> intersection = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j])
                i++;
            else if (nums1[i] > nums2[j])
                j++;
            else {
                intersection.add(nums1[i]);
                i++;
                j++;
            }
        }
        int[] res = new int[intersection.size()];
        for (int k=0; k<intersection.size(); k++)
            res[k] = intersection.get(k);
        return res;
    }

    public static void main(String[] args) {
        int[] testNums1 = {1,2,2,1};
        int[] testNums2 = {2,2};
        System.out.println(intersect(testNums1, testNums2).length);
    }
}
