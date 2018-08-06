import java.util.ArrayList;
import java.util.Stack;

public class Baseball_682 {
    // Standard solution using stack
    /*
    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack();

        for(String op : ops) {
            if (op.equals("+")) {
                int top = stack.pop();
                int newtop = top + stack.peek();
                stack.push(top);
                stack.push(newtop);
            } else if (op.equals("C")) {
                stack.pop();
            } else if (op.equals("D")) {
                stack.push(2 * stack.peek());
            } else {
                stack.push(Integer.valueOf(op));
            }
        }

        int ans = 0;
        for(int score : stack) ans += score;
        return ans;
    }
    */

    // My solution using arraylist
    public int calPoints(String[] ops) {
        int res = 0;
        ArrayList<Integer> ls = new ArrayList<>();
        for (String s : ops) {
            int len = ls.size();
            int score;
            if (s.equals("+")) {
                score = ls.get(len-1) + ls.get(len-2);
                ls.add(score);
            }
            else if (s.equals("D")) {
                score = 2 * ls.get(len-1);
                ls.add(score);
            }
            else if (s.equals("C")) {
                score = -ls.get(len-1);
                ls.remove(len-1);
            }
            else {
                score = Integer.valueOf(s);
                ls.add(score);
            }
            res += score;
        }
        return res;
    }
}
