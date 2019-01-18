import java.util.Arrays;
import java.util.LinkedList;

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
}
