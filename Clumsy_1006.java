public class Clumsy_1006 {
	// https://leetcode.com/problems/clumsy-factorial/discuss/252279/You-never-think-of-this-amazing-O(1)-solution
	// Most voted solution using math knowledge O(1)

	// My first solution O(n)
	public int clumsy(int N) {
        int res = 0;
        int tmp = 0;
        for (int i = 0; i < N; i++) {
            if (i % 4 == 0) 
                tmp = i == 0 ? N : i - N;
            else if (i % 4 == 1)
                tmp *= N - i;
            else if (i % 4 == 2)
                tmp /= N - i;
            else {
                res += tmp + N - i;
                tmp = 0;
            }
        }
        res += tmp;
        return res;
    }
}