public class Count_357 {
	// My first solution
	// similar with the most voted
	/*
	public int countNumbersWithUniqueDigits(int n) {
        n = Math.min(10, n);
        if (n == 0) return 1;
        int sum = 10;
        int tmp = 9;
        for (int i = 1; i < n; i++) {
            tmp *= 10 - i;
            sum += tmp;
        }
        return sum;
    }
    */


    // Most voted solution
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0)     return 1;
        
        int res = 10;
        int uniqueDigits = 9;
        int availableNumber = 9;
        while (n-- > 1 && availableNumber > 0) {
            uniqueDigits *= availableNumber;
            res += uniqueDigits;
            availableNumber--;
        }
        return res;
    }
}