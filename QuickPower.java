public class QuickPower {
	// Compute b^{k} mod m
	public int quickPowerMod(int b, int k, int m) {
		int res = 1, base = b;
		while (k > 0) {
			if (k % 2 == 1) res = (res * base) % m;
			base = (base * base) % m;
			k /= 2; // k >>= 1;
		}
		return res;
	}
}