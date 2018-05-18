public class Teemo_495 {
    public static int findPoisonedDuration(int[] timeSeries, int duration) {
        int n = timeSeries.length;
        if (n == 0)
            return 0;
        int result = 0;
        int startTime = timeSeries[0];
        int endTime = startTime + duration;
        for (int i=1; i<n; i++) {
            if (timeSeries[i] < endTime)
                endTime = timeSeries[i] + duration;
            else {
                result += endTime - startTime;
                startTime = timeSeries[i];
                endTime = startTime + duration;
            }
        }
        return result+endTime-startTime;
    }
    public static void main (String args[]) {
        int[] testTimeSeries = {1};
        int testDuration = 2;
        System.out.println(findPoisonedDuration(testTimeSeries, testDuration));
    }
}
