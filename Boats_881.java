import java.util.Arrays;

public class Boats_881 {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int i, j;
        for (i = 0, j = people.length - 1; i <= j; j--)
            if (people[i] + people[j] <= limit) i++;
        return people.length - 1 - j;
    }


    // Time: O(n), Space: O(n)
    /*
    public int numRescueBoats(int[] people, int limit) {
        int[] buckets = new int[limit + 1];
        for (int weight : people) buckets[weight]++;
        int i = 1, j = limit, res = 0;
        while (i <= j) {
            while (i <= j && buckets[i] <= 0) i++;
            while (i <= j && buckets[j] <= 0) j--;
            if (i > j) return res;
            res++;
            if (i + j <= limit) buckets[i]--;
            buckets[j]--;
        }
        return res;
    }
    */
}
