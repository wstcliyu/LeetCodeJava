import java.util.ArrayList;
import java.util.List;

public class Palindrome_131 {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), 0, s);
        return res;
    }
    private void backtrack(List<List<String>> ls, List<String> tempList, int start, String s) {
        if (start == s.length())
            ls.add(new ArrayList<>(tempList));
        else {
            for (int i=start; i<s.length(); i++) {
                if (isPalindrome(s, start, i)) {
                    tempList.add(s.substring(start,i+1));
                    backtrack(ls, tempList, i+1, s);
                    tempList.remove(tempList.size()-1);
                }
            }
        }
    }
    private boolean isPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--))
                return false;
        }
        return true;
    }
}
