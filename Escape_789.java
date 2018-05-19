public class Escape_789 {
    public static boolean escapeGhosts(int[][] ghosts, int[] target) {
        int val = Math.abs(target[0]) + Math.abs(target[1]);
        for (int i=0; i<ghosts.length; i++) {
            if (val >= Math.abs(ghosts[i][0]-target[0]) + Math.abs(ghosts[i][1]-target[1]))
                return false;
        }
        return true;
    }
    public static void main (String args[]) {
        int[][] testGhosts = {{1,0},{0,3}};
        int[] testTarget = {0,1};
        System.out.println(escapeGhosts(testGhosts,testTarget));
    }
}
