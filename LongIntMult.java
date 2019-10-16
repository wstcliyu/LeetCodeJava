class LongIntMult {
	String multiply(String a, String b) {
		int m = a.length();
		int n = b.length();
		int[] A = new int[m];
		int[] B = new int[n];
		for (int i = 0; i < m; i++) {
			A[i] = a.charAt(i) - '0';
		}
		for (int j = 0; j < n; j++) {
			B[j] = b.charAt(j) - '0';
		}

		int[] d = new int[m + n];
		for (int i = m - 1; i >= 0; i--) {
			int carry = 0;
			for (int j = n - 1; j >= 0; j--) {
				d[i + j + 1] += carry + A[i] * B[j];
				carry = d[i + j + 1] / 10;
				d[i + j + 1] %= 10;
			}
			d[i] = carry;
		}

		StringBuilder sb = new StringBuilder();
		if (d[0] > 0) sb.append(d[0]);
		for (int i = 1; i < m + n; i++) {
			sb.append(d[i]);
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		LongIntMult test = new LongIntMult();
		String a = "123";
		String b = "1234";
		String res = test.multiply(a, b);
		System.out.println(res);
		System.out.println(Integer.valueOf(a) * Integer.valueOf(b));
		System.out.println(Integer.valueOf(res) == Integer.valueOf(a) * Integer.valueOf(b));
	}
}