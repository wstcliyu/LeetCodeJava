public class Poor_458 {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int d = minutesToTest / minutesToDie + 1;
        int max = 1;
        int pigs = 0;
        while (max < buckets) {
            pigs++;
            max *= d;
        }
        return pigs;
    }
}
