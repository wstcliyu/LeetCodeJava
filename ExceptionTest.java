public class ExceptionTest {
	class MyException extends Exception {
		MyException(String m) {
			super(m);
		}

		MyException() {}
	}

	public boolean divide(int[] a) throws Exception {
		if (a.length > 2) throw new MyException("Array size greater than 2!");
		if (a[1] == 0) throw new MyException("divider is 0!");
		if (a[0] == 0) throw new MyException();
		return a[0]/a[1] == 2;
	}

	public static void main(String[] args) {
		ExceptionTest test = new ExceptionTest();
		int[] testA = {1, 0};
		int[] testB = {1, 2, 3};
		int[] testC = {2, 1};
		int[] testD = {0, 1};
		try {
			System.out.println(test.divide(testB));
		} catch (Exception e) {
			e.printStackTrace();
			// System.out.println(e.getMessage());
		}
	}
}