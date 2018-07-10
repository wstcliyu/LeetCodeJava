import java.util.LinkedList;
import java.util.List;

public class Letter_17 {
    // Most voted solution with FIFO queue
    public List<String> letterCombinations(String digits) {
		LinkedList<String> ans = new LinkedList<String>();
		if(digits.isEmpty()) return ans;
		String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
		ans.add("");
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
		while(ans.peek().length()!=digits.length()){
			String remove = ans.remove();
			String map = mapping[digits.charAt(remove.length())-'0'];
			for(char c: map.toCharArray())
				ans.addLast(remove+c);
		}
		return ans;
	}

	// My solution with backtracking
    /*
    public List<String> letterCombinations(String digits) {
        List<String> res = new LinkedList<>();
        if (digits == null || digits.length() == 0)
            return res;
        backtrack(res, new StringBuilder(), digits, 0);
        return res;
    }
    private void backtrack (List<String> ls, StringBuilder sb, String digits, int start) {
        if (start == digits.length())
            ls.add(sb.toString());
        else {
            int d = digits.charAt(start) - '2';
            int x = 0, y = 0;
            switch(d) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                    x = 3 * d;
                    y = 3;
                    break;
                case 5:
                    x = 3 * d;
                    y = 4;
                    break;
                case 6:
                    x = 3 * d + 1;
                    y = 3;
                    break;
                case 7:
                    x = 3 * d + 1;
                    y = 4;
                    break;
            }
            for (int i=0; i<y; i++) {
                sb.append((char)('a'+x+i));
                backtrack(ls, sb, digits, start+1);
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }
    */
}
