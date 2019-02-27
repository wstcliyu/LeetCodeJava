import java.util.ArrayList;
import java.util.List;

public class MaxHeap {
    private int size;
    private List<Integer> ls;

    public MaxHeap() {
        ls = new ArrayList<>();
        ls.add(-1);
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    public int peek() {
        return ls.get(1);
    }

    public int poll() throws Exception {
        if (isEmpty())
            throw new Exception("Heap is empty! Cannot poll!");
        int max = peek();
        ls.set(1, ls.get(size));
        ls.remove(size--);
        maxHeapify(1);
        return max;
    }

    public void add(int x) {
        ls.add(x);
        int i = ++size;
        while (i > 1 && ls.get(i) > ls.get(i/2)) {
            swap(i, i/2);
            i = i/2;
        }
    }

    private void maxHeapify(int i) {
        int largest = i;
        int left = 2 * i;
        int right = 2 * i + 1;
        if (left <= size && ls.get(left) > ls.get(largest)) largest = left;
        if (right <= size && ls.get(right) > ls.get(largest)) largest = right;
        if (largest != i) {
            swap(i, largest);
            maxHeapify(largest);
        }
    }

    private void swap(int i, int j) {
        int tmp = ls.get(i);
        ls.set(i, ls.get(j));
        ls.set(j, tmp);
    }

    public static void main(String[] args) {
        MaxHeap mh = new MaxHeap();
        for (int i = 5; i < 8; i++) mh.add(i);
        System.out.println(mh.isEmpty());
        try {
            System.out.println(mh.isEmpty());
            System.out.println(mh.poll());
            System.out.println(mh.poll());
            System.out.println(mh.poll());
            System.out.println(mh.getSize());
            System.out.println(mh.isEmpty());
            System.out.println(mh.poll());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
