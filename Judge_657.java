public class Judge_657 {
    public static boolean judgeCircle(String moves) {
        int horizontal=0, vertical=0;
        for (int i=0; i<moves.length(); i++) {
            char c = moves.charAt(i);
            switch (c) {
                case 'U':
                    vertical++;
                    break;
                case 'D':
                    vertical--;
                    break;
                case 'R':
                    horizontal++;
                    break;
                case 'L':
                    horizontal--;
                    break;
            }
        }
        return horizontal==0 && vertical==0;
    }
    public static void main(String[] args) {
        String testMoves = "RLUURDDDLU";
        System.out.println(judgeCircle(testMoves));
    }
}
