import java.util.*;

class Flower_1042 {
    public int[] gardenNoAdj(int N, int[][] paths) {
        List<Set<Integer>> ls = new ArrayList<>();
        for (int i = 0; i < N; i++) {
        	ls.add(new HashSet<>());
        }

        for (int[] path : paths) {
            int a = path[0] - 1;
            int b = path[1] - 1;
            ls.get(a).add(b);
            ls.get(b).add(a);
        }
        int[] res = new int[N];

        for (int i = 0; i < N; i++) {
            boolean[] used = new boolean[5];
            for (int neighbor : ls.get(i)) {
                used[res[neighbor]] = true;
            }
            for (int color = 4; color > 0; color--) {
                if (!used[color]) res[i] = color;
            }
        }

        return res;
    }
}