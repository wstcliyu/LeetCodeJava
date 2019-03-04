import java.util.*;

public class Flatten_341 implements Iterator<Integer> {

    // Related: Nested_339, Nested_364

    // Good submission using Recursion to directly flatten nested list
    private List<Integer> flattenedList;
    private Iterator<Integer> it;

    private void flatten(List<NestedInteger> nestedList) {
        for (NestedInteger i : nestedList) {
            if (i.isInteger()) flattenedList.add(i.getInteger());
            else flatten(i.getList());
        }
    }


    public Flatten_341(List<NestedInteger> nestedList) {
        flattenedList = new LinkedList<>();
        flatten(nestedList);
        it = flattenedList.iterator();
    }

    @Override
    public Integer next() {
        return it.next();
    }

    @Override
    public boolean hasNext() {
        return it.hasNext();
    }




    // Most voted solution using Stack and NestedInteger
    /*
    private Stack<NestedInteger> stack;

    public Flatten_341(List<NestedInteger> nestedList) {
        stack = new Stack<>();
        for (int i = nestedList.size()-1; i >= 0; i--)
            stack.push(nestedList.get(i));
    }

    @Override
    public Integer next() {
        return hasNext() ? stack.pop().getInteger() : null;
    }

    @Override
    public boolean hasNext() {
        while (!stack.isEmpty()) {
            NestedInteger cur = stack.peek();
            if (cur.isInteger()) return true;
            List<NestedInteger> ls = stack.pop().getList();
            for (int i = ls.size()-1; i >= 0; i--)
                stack.push(ls.get(i));
        }
        return false;
    }
    */




    // Second voted solution using Stack and ListIterator
    /*
    private Stack<ListIterator<NestedInteger>> stack;

    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new Stack<>();
        stack.push(nestedList.listIterator());
    }

    @Override
    public Integer next() {
        return hasNext() ? stack.peek().next().getInteger() : null;
    }

    @Override
    public boolean hasNext() {
        while (!stack.isEmpty()) {
            ListIterator<NestedInteger> it = stack.peek();
            if (!it.hasNext()) {
                stack.pop();
            } else {
                NestedInteger x = it.next();
                if (x.isInteger()) {
                    it.previous();
                    return true;
                } else {
                    stack.push(x.getList().listIterator());
                }
            }
        }
        return false;
    }
    */




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
}
