import java.util.*;

class Design_353 {
    // 353. Design Snake Game
    // Rewrite most voted solution
    int width, height, score, foodIndex;
    int[][] food;
    Deque<Integer> body;
    Set<Integer> set;

    /** Initialize your data structure here.
        @param width - screen width
        @param height - screen height 
        @param food - A list of food positions
        E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
    public Design_353(int width, int height, int[][] food) {
        this.width = width;
        this.height = height;
        this.food = food;
        foodIndex = 0;
        score = 0;
        body = new ArrayDeque<>();
        set = new HashSet<>();
        body.add(0);
        set.add(0);
    }
    
    /** Moves the snake.
        @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down 
        @return The game's score after the move. Return -1 if game over. 
        Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
        if (score == -1) return -1;
        int head = body.getFirst();
        int r = head / width;
        int c = head % width;
        switch (direction) {
            case "U": r--; break;
            case "D": r++; break;
            case "L": c--; break;
            case "R": c++; break;
        }
        
        int newHead = r * width + c;
        int tail = body.getLast();
        set.remove(tail);
        
        // case 1: out of boundary or eating body
        if (r < 0 || c < 0 || r >= height || c >= width || set.contains(newHead)) {
            return score = -1;
        }
        
        // add head for case2 and case3
        set.add(newHead);
        body.addFirst(newHead);
        
        // case2: eating food, keep tail, add score and foodIndex
        if (foodIndex < food.length && r == food[foodIndex][0] && c == food[foodIndex][1]) {
            set.add(tail);
            foodIndex++;
            return ++score;
        } else {
            // case3: normal move, remove tail
            body.removeLast();
            return score;
        }
    }
}