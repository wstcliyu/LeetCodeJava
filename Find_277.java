public class Find_277 extends Relation {
    public int findCelebrity(int n) {
        int candidate = 0;

        // If there is a celebrity, any candidate before the celebrity will know him,
        // and then candidate will switch to him and not change anymore.
        for(int i = 1; i < n; i++){
            if(knows(candidate, i))
                candidate = i;
        }
        for(int i = 0; i < n; i++){
            if(i != candidate && (knows(candidate, i) || !knows(i, candidate))) return -1;
        }
        return candidate;
    }
}