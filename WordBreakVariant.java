import java.util.*;

class WordBreakVariant {
	public List<String> mybreak(String s) {
		if (s.isEmpty()) return new ArrayList<>();
		return dfs(s, new HashMap<>());
	}

	private List<String> dfs(String s, Map<String, List<String>> map) {
		if (map.containsKey(s)) return map.get(s);

		List<String> res = new ArrayList<>();

		if (s.length() == 0) {
			res.add("");
		} else {
			int offset = Integer.valueOf(s.substring(0, 1));
			updateList(s.substring(1), map, res, offset, 1);
			if (s.length() > 1) {
				offset = Integer.valueOf(s.substring(0, 2));
				updateList(s.substring(2), map, res, offset, 2);
			}
		}

		map.put(s, res);
		return res;
	}

	private void updateList(String substr, Map<String, List<String>> map, List<String> res, int offset, int prefixLength) {
		if (prefixLength == 1 && (offset < 1 || offset > 9)) return;
		if (prefixLength == 2 && (offset < 10 || offset > 26)) return;
		char c = (char)('A' + offset - 1);
		for (String sub : dfs(substr, map))
			res.add(c + sub);
	}

	public static void main(String[] args) {
		WordBreakVariant solution = new WordBreakVariant();
		String s1 = "26";
		String s2 = "10122120";
		String[] strArr = {s1, s2};
		List<String> result;
		for (String str : strArr) {
			result = solution.mybreak(str);
			System.out.println(Arrays.toString(result.toArray()));
		}
	}
} 