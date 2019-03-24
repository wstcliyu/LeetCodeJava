class Smallest_1022 {
	// https://leetcode.com/problems/smallest-integer-divisible-by-k/discuss/260852/JavaC%2B%2BPython-Brute-Force-O(K)-Time-O(1)-Space
	/*
	Assume that N = 1 to N = K, if there isn't 111...11 % K == 0
	There are at most K - 1 different remainders: 1, 2, .... K - 1.

	So this is a pigeon holes problem:
	There must be at least 2 same remainders.

	Assume that,
	f(N) ≡ f(M), N > M
	f(N - M) * 10 ^ M ≡ 0
	10 ^ M ≡ 0, mod K
	so that K has factor 2 or factor 5.

	Proof by contradiction，
	if (K % 2 == 0 || K % 5 == 0) return -1;
	otherwise, there must be a solution N <= K
	*/

    public int smallestRepunitDivByK(int K) {
        if (K % 2 == 0 || K % 5 == 0) return -1;
        int r = 0;
        for (int i = 1; i <= K; i++) {
            r = (r * 10 + 1) % K;
            if (r == 0) return i;
        }
        return -1;
    }
}