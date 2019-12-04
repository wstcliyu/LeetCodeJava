public class KMP {
	// https://www.cnblogs.com/yjiyjige/p/3263858.html
	public int stringMatch(String ts, String ps) {
		char[] t = ts.toCharArray();
		char[] p = ps.toCharArray();
		int[] next = getNext(p);
		int i = 0;
		int j = 0;
		while (i < t.length && j < p.length) {
			if (j == -1 || t[i] == p[j]) {
				i++;
				j++;
			} else {
				j = next[j];
			}
		}
		return j == p.length ? i - j : -1;
	}

	public int[] getNext(char[] p) {
		int[] next = new int[p.length];
		next[0] = -1;
		int j = 0;
		int k = -1;
		while (j < p.length - 1) {
			if (k == -1 || p[j] == p[k]) {
				// Simple version: next[++j] = ++k;
				if (p[++j] == p[++k])
					next[j] = next[k];
				else
					next[j] = k;
			} else {
				k = next[k];
			}
		}
		return next;
	}
}