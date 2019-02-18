public class Remove_27 {
	// Standard solution 2: Two Pointers - when elements to remove are rare
	public int removeElement(int[] nums, int val) {
	    int i = 0;
	    int n = nums.length;
	    while (i < n) {
	        if (nums[i] == val) {
	            nums[i] = nums[n - 1];
	            // reduce array size by one
	            n--;
	        } else {
	            i++;
	        }
	    }
	    return n;
	}


	// Standard solution 1: 
	/*
	public int removeElement(int[] nums, int val) {
	    int write = 0;
	    for (int j = 0; j < nums.length; j++) {
	        if (nums[j] != val) {
	            nums[write++] = nums[j];
	        }
	    }
	    return write;
	}
	*/
}