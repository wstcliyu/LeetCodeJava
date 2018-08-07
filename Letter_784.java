import java.util.LinkedList;
import java.util.List;

public class Letter_784 {
    public List<String> letterCasePermutation(String S) {
        LinkedList<String> res = new LinkedList<>();
        if (S == null)
            return res;
        backtrack(res, new StringBuilder(), S);
        return res;
    }
    private void backtrack(List<String> res, StringBuilder sb, String S) {
        int len = sb.length();
        if (len == S.length())
            res.add(sb.toString());
        else {
            char c = S.charAt(len);
            if (Character.isLetter(c)){
                sb.append(Character.toLowerCase(c));
                backtrack(res, sb, S);
                sb.deleteCharAt(len);
                sb.append(Character.toUpperCase(c));
                backtrack(res, sb, S);
                sb.deleteCharAt(len);
            }
            else if (Character.isDigit(c)){
                sb.append(c);
                backtrack(res, sb, S);
                sb.deleteCharAt(len);
            }
        }
    }
}
