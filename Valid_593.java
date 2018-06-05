public class Valid_593 {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        if (helper(p1,p2,p3,p4) || helper(p1,p2,p4,p3))
            return true;
        if (helper(p1,p3,p2,p4) || helper(p1,p3,p4,p2))
            return true;
        return false;
    }
    private boolean helper(int[] p1, int[] p2, int[] p3, int[] p4) {
        int x = p1[0] - p2[0];
        int y = p1[1] - p2[1];
        if (x==0 && y==0) return false;
        if (p3[0]-p4[0]==x && p3[1]-p4[1]==y) {
            if (p1[0]-p3[0]==-y && p1[1]-p3[1]==x)
                return true;
            if (p1[0]-p3[0]==y && p1[1]-p3[1]==-x)
                return true;
        }
        return false;
    }
}
