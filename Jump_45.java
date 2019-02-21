public class Jump_45 {
	// My solution (similar with Jump_55)
	public int jump(int[] nums) {
        if (nums.length <= 1) return 0;
        int i = 0, pre_max, cur_max = 0, res = 0;
        do {
            pre_max = cur_max;
            res++;
            for (; i <= pre_max; i++)
                cur_max = Math.max(cur_max, i + nums[i]);
        } while (pre_max < cur_max && cur_max < nums.length - 1);
        return res;
    }


    // Most voted solution using BFS (similar thought with mine)
    /*
	int jump(int A[], int n) {
		if(n < 2) return 0;
		int level=0, currentMax=0, i=0, nextMax=0;

		while(currentMax-i+1>0){		//nodes count of current level>0
			level++;
			for(;i<=currentMax;i++){	//traverse current level , and update the max reach of next level
				nextMax=max(nextMax,A[i]+i);
				if(nextMax>=n-1)return level;   // if last element is in level+1,  then the min jump=level 
			}
			currentMax=nextMax;
		}
		return 0;
	 }
    */
}