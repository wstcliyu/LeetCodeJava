public class Container_11 {
    public int maxArea(int[] height) {
        int i = 0, j = height.length-1;
        int res = 0;
        while (i < j) {
            res = Math.max(res, (j-i)*Math.min(height[i], height[j]));
            if (height[i] < height[j])
                i++;
            else
                j--;
        }
        return res;
    }
}
