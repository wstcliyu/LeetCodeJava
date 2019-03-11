import java.awt.Point;
import java.util.ArrayDeque;

public class Online_901 {
	// My first solution
	// Similar with Daily_739
	ArrayDeque<Point> stack;
    
    public Online_901() {
        stack = new ArrayDeque<>();
        stack.addLast(new Point(-1, Integer.MAX_VALUE));
    }
    
    public int next(int price) {
        int day = 1 + stack.getLast().x;
        while (!stack.isEmpty() && stack.getLast().y <= price)
            stack.removeLast();
        int res = day - stack.getLast().x;
        stack.addLast(new Point(day, price));
        return res;
    }



    // Standard solution
    // Time: O(Q) in total, O(1) amortized
    // Q is the number of calls to StockSpanner.next. 
    // In total, there are Q pushes to the stack, and at most Q pops.
    /*
    Stack<Integer> prices, weights;

    public StockSpanner() {
        prices = new Stack();
        weights = new Stack();
    }

    public int next(int price) {
        int w = 1;
        while (!prices.isEmpty() && prices.peek() <= price) {
            prices.pop();
            w += weights.pop();
        }

        prices.push(price);
        weights.push(w);
        return w;
    }
    */
}