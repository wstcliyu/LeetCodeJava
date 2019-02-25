public class Moving_346 {
    // Most voted solution using array
    // This problem also can be solved by queue easily
    private int [] window;
    private int n, insert;
    private double sum;

    /** Initialize your data structure here. */
    public Moving_346(int size) {
        window = new int[size];
        insert = 0;
        sum = 0.0;
    }

    public double next(int val) {
        if (n < window.length)  n++;
        sum -= window[insert];
        sum += val;
        window[insert] = val;
        insert = (insert + 1) % window.length;

        return sum / n;
    }
}
