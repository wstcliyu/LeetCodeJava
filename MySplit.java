import java.util.ArrayList;
import java.util.Arrays;

class MySplit {
	public static String[] split(String str, String regex) {
		ArrayList<String> res = new ArrayList<>();
		int start = 0;
		int pos = str.indexOf(regex);
		while (pos >= start) {
			res.add(str.substring(start, pos));
			res.add(regex);
			start = pos + regex.length();
			pos = str.indexOf(regex, start);
		}
		if (start < str.length()) {
			res.add(str.substring(start));
		}
		return res.toArray(new String[res.size()]);
	}

	public static void main(String[] args) {
		String regex = "/";
		String[] strs = {"a/b", "a//b", "/a//b"};
		for (String str : strs) {
			String[] res = split(str, regex);
			System.out.println(Arrays.toString(res));
		}
	}
}