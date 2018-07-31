import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Generate_22 {
    // Refer to the standard solution on leetcode website for complexity analysis
    // https://leetcode.com/problems/generate-parentheses/solution/
    public List<String> generateParenthesis(int n) {
        List<String> res = new LinkedList<>();
        helper(res, "", 0, 2*n);
        return res;
    }
    private void helper(List<String> ls, String temp, int l, int n) {
        if (temp.length() == n && l == 0)
            ls.add(temp);
        else if (temp.length() < n) {
            if (temp.length() + l > n)
                return;
            if (l > 0)
                helper(ls, temp+")", l-1, n);
            helper(ls, temp+"(", l+1, n);
        }
    }

    // Approach 3: Closure Number
    /*
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList();
        if (n == 0) {
            ans.add("");
        } else {
            for (int c = 0; c < n; ++c)
                for (String left: generateParenthesis(c))
                    for (String right: generateParenthesis(n-1-c))
                        ans.add("(" + left + ")" + right);
        }
        return ans;
    }
    */
    public static void main (String args[]) {
        Generate_22 test = new Generate_22();
        System.out.println(Arrays.toString(test.generateParenthesis(3).toArray()));
    }
}
