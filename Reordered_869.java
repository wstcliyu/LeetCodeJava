public class Reordered_869 {
	// Time: O(log^2 N)
	// Because digitCount(N) takes O(log N) time
	public boolean reorderedPowerOf2(int N) {
        int[] count = digitCount(N);
        for (int i = 0; i < 31; i++) {
        	// Arrays.equals() here only takes O(1) time 
        	// because the size of these two arrays is always 10
            if (Arrays.equals(count, digitCount(1<<i)))
                return true;
        }
        return false;
    }
    
    private int[] digitCount(int N) {
        int[] count = new int[10];
        while (N > 0) {
            count[N % 10]++;
            N /= 10;
        }
        return count;
    }
}