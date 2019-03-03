import java.util.Random;

public class Implement_470 {
    public int rand7() {
        return 1 + new Random().nextInt(7);
    }


    // Standard solution: Rejection Sampling
    public int rand10() {
        int row, col, idx;
        do {
            row = rand7();
            col = rand7();
            idx = col + (row - 1) * 7;
        } while (idx > 40);
        return 1 + (idx - 1) % 10;
    }
}
