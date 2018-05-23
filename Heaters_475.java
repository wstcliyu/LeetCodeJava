import java.util.Arrays;

public class Heaters_475 {
    public static int findRadius(int[] houses, int[] heaters) {
        /* sort two arrays, then two pointers
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int i = 0, j = 0, res = 0;
        while (i < houses.length) {
            while (j < heaters.length - 1
                && Math.abs(heaters[j + 1] - houses[i]) <= Math.abs(heaters[j] - houses[i])) {
                j++;
            }
            res = Math.max(res, Math.abs(heaters[j] - houses[i]));
            i++;
        }
        return res;
        */
        // sort one array, then use Arrays.binarySearch(int[] a, int key)
        Arrays.sort(heaters);
        int res = 0;
        for (int house:houses) {
            int index = Arrays.binarySearch(heaters, house);
            if (index < 0)
                index = -index-1;
            int dist1 = index>=1 ? house - heaters[index-1] : Integer.MAX_VALUE;
            int dist2 = index<heaters.length ? heaters[index] - house : Integer.MAX_VALUE;
            res = Math.max(res, Math.min(dist1, dist2));
        }
        return res;
    }
}
