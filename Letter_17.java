import java.util.LinkedList;
import java.util.List;

public class Letter_17 {
    // Most voted solution with FIFO queue
    public List<String> letterCombinations(String digits) {
		LinkedList<String> ans = new LinkedList<String>();
		if (digits.isEmpty()) return ans;
		String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
		ans.add("");

        // Online solution
		/*
		for(int i =0; i<digits.length();i++){
			int x = Character.getNumericValue(digits.charAt(i));
			while(ans.peek().length()==i){
				String t = ans.remove();
				for(char s : mapping[x].toCharArray())
					ans.add(t+s);
			}
		}
		*/

        // My version
		while (ans.getFirst().length() != digits.length()) {
			String peek = ans.removeFirst();
			String map = mapping[digits.charAt(peek.length()) - '0'];
			for(char c: map.toCharArray())
				ans.addLast(peek+c);
		}
		return ans;
	}


	// My solution with backtracking
    /*
    String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> res = new LinkedList<>();
        if (digits == null || digits.length() == 0)
            return res;
        backtrack(res, new StringBuilder(), digits);
        return res;
    }

    private void backtrack (List<String> ls, StringBuilder sb, String digits) {
        if (sb.length() == digits.length())
            ls.add(sb.toString());
        else {
            String map = mapping[digits.charAt(sb.length())-'0'];
            for (char c: map.toCharArray()) {
                sb.append(c);
                backtrack(ls, sb, digits);
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }
    */
}
