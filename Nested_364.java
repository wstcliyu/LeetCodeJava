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


    // My first solution
    private int total, lowest;
    
    public int depthSumInverse(List<NestedInteger> nestedList) {
        total = 0;
        lowest = 0;
        int sum = depthSum(nestedList, 0);
        return sum + total * (1 - lowest);
    }
    
    private int depthSum(List<NestedInteger> list, int depth) {
        int sum = 0;
        for (NestedInteger n : list) {
            if (n.isInteger()) {
                total += n.getInteger();
                lowest = Math.min(lowest, depth);
                sum += n.getInteger() * depth;
            } else {
                sum += depthSum(n.getList(), depth - 1);
            }
        }
        return sum;
    }




    // Most voted solution
    /*
    public int depthSumInverse(List<NestedInteger> nestedList) {
      int unweighted = 0, weighted = 0;
      while (!nestedList.isEmpty()) {
          List<NestedInteger> nextLevel = new ArrayList<>();
          for (NestedInteger ni : nestedList) {
              if (ni.isInteger())
                  unweighted += ni.getInteger();
              else
                  nextLevel.addAll(ni.getList());
          }
          weighted += unweighted;
          nestedList = nextLevel;
      }
      return weighted;
    }
    */
}
