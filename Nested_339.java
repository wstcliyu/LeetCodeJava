import java.awt.*;
import java.util.List;

public class Nested_339 {

      // This is the interface that allows for creating nested lists.
      // You should not implement it, or speculate about its implementation
    public interface NestedInteger {
      // Constructor initializes an empty nested list.
      // public NestedInteger();

      // Constructor initializes a single integer.
      // public NestedInteger(int value);

      // @return true if this NestedInteger holds a single integer, rather than a nested list.
        boolean isInteger();

      // @return the single integer that this NestedInteger holds, if it holds a single integer
      // Return null if this NestedInteger holds a nested list
        Integer getInteger();

      // Set this NestedInteger to hold a single integer.
        void setInteger(int value);

      // Set this NestedInteger to hold a nested list and adds a nested integer to it.
        void add(NestedInteger ni);

      // @return the nested list that this NestedInteger holds, if it holds a nested list
      // Return null if this NestedInteger holds a single integer
        List<NestedInteger> getList();
    }


    // Standard solution: DFS
    public int depthSum(List<NestedInteger> nestedList) {
        return depthSum(nestedList, 1);
    }

    public int depthSum(List<NestedInteger> list, int depth) {
        int sum = 0;
        for (NestedInteger n : list) {
            if (n.isInteger()) {
                sum += n.getInteger() * depth;
            } else {
                sum += depthSum(n.getList(), depth + 1);
            }
        }
        return sum;
    }


    // My first solution
    /*
    public int depthSum(List<NestedInteger> nestedList) {
        return helper(nestedList).y;
    }

    private Point helper(List<NestedInteger> nestedList) {
        int sum = 0;
        int depthSum = 0;
        for (NestedInteger i : nestedList) {
            if (i.isInteger()) {
                sum += i.getInteger();
                depthSum += i.getInteger();
            } else {
                Point p = helper(i.getList());
                sum += p.x;
                depthSum += p.x + p.y;
            }
        }
        return new Point(sum, depthSum);
    }
    */
}
