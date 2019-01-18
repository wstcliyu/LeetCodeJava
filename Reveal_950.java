import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Reveal_950 {
    // Standard Solution: Simulation
    public int[] deckRevealedIncreasing(int[] deck) {
        LinkedList<Integer> index = new LinkedList<>();
        for (int i = 0; i < deck.length; i++) index.add(i);
        Arrays.sort(deck);
        int[] res = new int[deck.length];
        for (int card : deck) {
            res[index.removeFirst()] = card;
            if (!index.isEmpty()) index.add(index.removeFirst());
        }
        return res;
    }


    // Second voted solution
    // Simulate the reversed process
    // each time rotate the last element to the first,
    // and append the next biggest number
    /*
    public int[] deckRevealedIncreasing(int[] deck) {
        int n = deck.length;
        Arrays.sort(deck);
        Queue<Integer> q = new LinkedList<>();
        for (int i = n - 1; i >= 0; --i) {
            if (q.size() > 0) q.add(q.poll());
            q.add(deck[i]);
        }
        int[] res = new int[n];
        for (int i = n - 1; i >= 0; --i)
            res[i] = q.poll();
        return res;
    }
    */
}
