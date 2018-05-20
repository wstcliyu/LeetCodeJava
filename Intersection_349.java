import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Intersection_349 {
    public static int[] intersection(int[] nums1, int[] nums2) {
        // My intuitive solution, O(n) time
        // Why HashSet_Object.contains() has O(1) time complexity?
        Set<Integer> n1 = new HashSet<>();
        Set<Integer> intersect = new HashSet<>();
        for (Integer i:nums1)
            n1.add(i);
        for (Integer i:nums2) {
            if (n1.contains(i))
                intersect.add(i);
        }
        int[] res = new int[intersect.size()];
        int j = 0;
        for (Integer i:intersect)
            res[j++] = i;
        return res;

        /* Arrays.sort() the two arrays, O(nlogn) time
         * Then two pointers traverse the two sorted arrays respectively
         * to find all the same integers and add them to a new HashSet
        Set<Integer> intersect = new HashSet<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i=0, j=0;
        while (i<nums1.length && j<nums2.length) {
            if (nums1[i] == nums2[j]) {
                intersect.add(nums1[i]);
                i++;
                j++;
            }
            else if (nums1[i] < nums2[j])
                i++;
            else
                j++;
        }
        int[] res = new int[intersect.size()];
        int jj = 0;
        for (Integer ii:intersect)
            res[jj++] = ii;
        return res;
        */
    }
    public static void main (String args[]) {
        int[] testNums1 = {1,2,2,1};
        int[] testNums2 = {2,2};
        System.out.println(Arrays.toString(intersection(testNums1,testNums2)));
    }
}
