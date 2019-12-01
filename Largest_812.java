class Largest_812 {
    // Standard solution
    public double largestTriangleArea(int[][] points) {
        int N = points.length;
        double ans = 0;
        for (int i = 0; i < N; ++i)
            for (int j = i+1; j < N; ++j)
                for (int k = j+1; k < N; ++k)
                    ans = Math.max(ans, area(points[i], points[j], points[k]));
        return ans;
    }

    // (x1, y1) (x2, y2) (x3, y3)
    // Area = 0.5 * |(x1y2 + x2y3 + x3y1) - (x1y3 + x2y1 + x3y2)|
    public double area(int[] P, int[] Q, int[] R) {
        return 0.5 * Math.abs(P[0]*Q[1] + Q[0]*R[1] + R[0]*P[1]
                             -P[1]*Q[0] - Q[1]*R[0] - R[1]*P[0]);
    }
}