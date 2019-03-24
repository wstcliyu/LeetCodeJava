public class Binary_1023 {
	// https://leetcode.com/problems/binary-string-with-substrings-representing-1-to-n/discuss/260847/JavaC%2B%2BPython-O(S2)
	// Time: O(S^2)

	// Pick two indices, there are at most S^2 substrings,
	// so S can contains at most S^2 integers
	// N upper bound is O(S^2)

	// Have a look at the number 1001 ~ 2000 and their values in binary.
	// The number 1001 ~ 2000 have 1000 different continuous 10 digits.
	// The string of length S has at most S - 9 different continuous 10 digits.
	// N upper bound is O(S)

	public boolean queryString(String S, int N) {
        for (int i = N; i > 0; --i)
            if (!S.contains(Integer.toBinaryString(i)))
                return false;
        return true;
    }
}