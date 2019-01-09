public class Rectangle_223 {
    // Second voted solution
    static int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int left = Math.max(A, E), right = Math.max(Math.min(C, G), left);
        int bottom = Math.max(B, F), top = Math.max(Math.min(D, H), bottom);
        return (C - A) * (D - B) + (G - E) * (H - F) - (right - left) * (top - bottom);
    }

    /*
    public static int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int overlapArea = overlapLength(A,C,E,G) * overlapLength(B,D,F,H);
        return (C-A)*(D-B)+(G-E)*(H-F)-overlapArea;
    }
    public static int overlapLength(int a, int c, int e, int g) {
        if (e<a) {
            if (g>a)
                return (g-a)>(c-a) ? c-a : g-a;
            else
                return 0;
        }
        else {
            if (c>e)
                return (g-e)>(c-e) ? c-e : g-e;
            else
                return 0;
        }
    }
    */

    public static void main(String[] args) {
        System.out.println(computeArea(-2, -2, 2, 2, -1, -1, 1, 1));
    }
}
