public class LargestTri_812 {
    public static double largestTriangleArea(int[][] points) {
        int n = points.length;
        int i,j,k;
        double result=0,temp;
        for (i=0;i<n;i++) {
            for (j=0;j<n;j++) {
                for (k=0;k<n;k++) {
                    temp = 0.5*Math.abs(points[i][0]*points[j][1]+points[j][0]*points[k][1]+points[k][0]*points[i][1]-points[i][1]*points[j][0]-points[j][1]*points[k][0]-points[k][1]*points[i][0]);

                    if(temp>result)
                        result = temp;
                }
            }
        }
        return result;
    }

}
