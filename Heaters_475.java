import java.util.Arrays;

public class Heaters_475 {
    // Sort two arrays, then two pointers
    /*
    public static int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int j = 0, res = 0;
        for (int i = 0; i < houses.length; i++) {
            while (j < heaters.length - 1
                && Math.abs(heaters[j] - houses[i]) >= Math.abs(heaters[j+1] - houses[i])) {
                j++;
            }
            res = Math.max(res, Math.abs(heaters[j] - houses[i]));
        }
        return res;
    }
    */
        

    // Sort one array, then use Arrays.binarySearch(int[] a, int key)
    public static int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int res = 0;
        for (int house : houses) {
            int p = Arrays.binarySearch(heaters, house);
            if (p < 0) p = - p - 1;
            int dist1 = (p >= 1) ? house - heaters[p-1] : Integer.MAX_VALUE;
            int dist2 = (p < heaters.length) ? heaters[p] - house : Integer.MAX_VALUE;
            res = Math.max(res, Math.min(dist1, dist2));
        }
        return res;
    }
}
