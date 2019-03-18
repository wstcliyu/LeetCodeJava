import java.util.Arrays;

public class MergeSortedArray_88 {
    // Since these two arrays are sorted and nums1 has enough space at the end,
    // We can fill nums1 from the end.
    // My updated solution
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1;
        int k = m + n - 1;

        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) nums1[k--] = nums1[i--];
            else nums1[k--] = nums2[j--];
        }
        
        // while (i >= 0) nums1[k--] = nums1[i--];
        // The above is unnecessary because we are merging them into nums1
        
        while (j >= 0) nums1[k--] = nums2[j--];
    }



    // 
    /*
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m+n-1;
        int j = m-1;
        int k = n-1;
        while(j>=0 || k>=0) {
            if (k<0) {
                nums1[i--] = nums1[j];
                j--;
                continue;
            }
            if (j<0) {
                nums1[i--] = nums2[k];
                k--;
                continue;
            }
            if (nums1[j] < nums2[k]) {
                nums1[i--] = nums2[k];
                k--;
            }
            else {
                nums1[i--] = nums1[j];
                j--;
            }
        }
    }
    */


    public static void main (String args[]) {
        int[] testNums1= {1,2,3,0,0,0};
        int testM = 3;
        int[] testNums2= {2,5,6};
        int testN = 3;
        merge(testNums1, testM, testNums2, testN);
        System.out.println(Arrays.toString(testNums1));
    }
}
