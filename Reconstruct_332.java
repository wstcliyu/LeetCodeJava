import java.util.*;

class Reconstruct_332 {
    // https://leetcode.com/problems/reconstruct-itinerary/discuss/78768/Short-Ruby-Python-Java-C%2B%2B
    // Most voted solution
    // Eulerian Path, use each edge exactly once
    // First keep going forward until you get stuck. That's a good main path already. 
    // Remaining tickets form cycles which are found on the way back and get merged into that main path. 
    // By writing down the path backwards when retreating from recursion, merging the cycles into the main path is easy - 
    // the end part of the path has already been written, the start part of the path hasn't been written yet, 
    // so just write down the cycle now and then keep backwards-writing the path.
    public List<String> findItinerary(List<List<String>> tickets) {
        for (List<String> ticket : tickets)
            targets.computeIfAbsent(ticket.get(0), k -> new PriorityQueue()).add(ticket.get(1));
        visit("JFK");
        return route;
    }

    Map<String, PriorityQueue<String>> targets = new HashMap<>();
    List<String> route = new LinkedList<>();

    void visit(String airport) {
        while (targets.containsKey(airport) && !targets.get(airport).isEmpty())
            visit(targets.get(airport).poll());
        route.add(0, airport);
    }



    // Iterative version
    /*
    public List<String> findItinerary(String[][] tickets) {
        Map<String, PriorityQueue<String>> targets = new HashMap<>();
        for (String[] ticket : tickets)
            targets.computeIfAbsent(ticket[0], k -> new PriorityQueue()).add(ticket[1]);
        List<String> route = new LinkedList();
        Stack<String> stack = new Stack<>();
        stack.push("JFK");
        while (!stack.empty()) {
            while (targets.containsKey(stack.peek()) && !targets.get(stack.peek()).isEmpty())
                stack.push(targets.get(stack.peek()).poll());
            route.add(0, stack.pop());
        }
        return route;
    }
    */
}