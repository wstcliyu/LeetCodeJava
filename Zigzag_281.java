import java.util.*;

public class Zigzag_281 {
    // Most voted solution
    LinkedList<Iterator> list;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        list = new LinkedList<Iterator>();
        if(!v1.isEmpty()) list.add(v1.iterator());
        if(!v2.isEmpty()) list.add(v2.iterator());
    }

    public int next() {
        // Iterator poll = list.remove();
        // int result = (Integer)poll.next();
        Iterator<Integer> poll = list.removeFirst();
        int result = poll.next();
        if (poll.hasNext()) list.add(poll);
        return result;
    }

    public boolean hasNext() {
        return !list.isEmpty();
    }



    // My first solution
    /*
    private int i1, i2, turn;
    private List<Integer> v1, v2;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        i1 = 0;
        i2 = 0;
        turn = 0;
        this.v1 = v1;
        this.v2 = v2;
    }

    public int next() {
        if (turn == 0) {
            if (i1 < v1.size()) {
                turn = 1 - turn;
                return v1.get(i1++);
            } else {
                turn = 1 - turn;
                return v2.get(i2++);
            }
        } else {
            if (i2 < v2.size()) {
                turn = 1 - turn;
                return v2.get(i2++);
            } else {
                turn = 1 - turn;
                return v1.get(i1++);
            }
        }
    }

    public boolean hasNext() {
        return i1 < v1.size() || i2 < v2.size();
    }
    */
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */