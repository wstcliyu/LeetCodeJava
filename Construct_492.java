public class Construct_492 {
    // Most voted solution using (int)Math.sqrt(area)
    /*
    public int[] constructRectangle(int area) {
        int w = (int)Math.sqrt(area);
        while (area % w != 0)
            w--;
        return new int[]{area / w, w};
    }
    */

    // My solution using binary search
    public int[] constructRectangle(int area) {
        int[] res = new int[2];
        int l = 1, r = 5000;
        while (l < r) {
            int m = (l + r) / 2;
            if (m * m == area)
                return new int[]{m, m};
            if (m * m < area)
                l = m;
            else
                r = m;
        }
        for (int i=l; i>0; i--)
            if (area % i == 0)
                return new int[]{area / i, i};
        return res;
    }
}
