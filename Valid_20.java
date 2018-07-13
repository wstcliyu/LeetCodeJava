import java.util.Stack;

public class Valid_20 {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0)
            return true;
        Stack<Character> tmp = new Stack<>();
        for (int i=0; i<s.length(); i++) {
            char cur = s.charAt(i);
            if (cur == '(' || cur == '[' || cur == '{')
                tmp.push(cur);
            else {
                if (tmp.empty())
                    return false;
                char pre = tmp.pop();
                if ((cur == ')' && pre != '(') || (cur == ']' && pre != '[') || (cur == '}' && pre != '{'))
                    return false;
            }
        }
        return tmp.empty();
    }
}
