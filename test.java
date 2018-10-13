import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class test implements testInterface {
    @Override
    public void print() {
        System.out.println("Interface");
    }

    public void print(int x) {
        System.out.println(x);
    }

    public static void main (String args[]) {
        Queue<Integer> q = new LinkedList<>();
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(1);
        q.remove(2);
        System.out.println(q);
        new test().print();
    }
}
