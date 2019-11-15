import java.util.*;

class Lonely_533 {
    // Most voted soluion
    public int findBlackPixel(char[][] picture, int N) {
        int R = picture.length;
        int C = picture[0].length;
        int[] colCount = new int[C];
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < R; i++) {
            String code = scanRow(i, N, picture, colCount);
            if (!code.isEmpty()) map.put(code, 1 + map.getOrDefault(code, 0));
        }
        int res = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == N) {
                String code = entry.getKey();
                for (int j = 0; j < C; j++) {
                    if (code.charAt(j) == 'B' && colCount[j] == N) {
                        res += N;
                    }
                }
            }
        }
        return res;
    }
    
    private String scanRow(int i, int target, char[][] picture, int[] colCount) {
        StringBuilder sb = new StringBuilder();
        int rowCount = 0;
        for (int j = 0; j < picture[i].length; j++) {
            sb.append(picture[i][j]);
            if (picture[i][j] == 'B') {
                rowCount++;
                colCount[j]++;
            }
        }
        if (rowCount == target) return sb.toString();
        return "";
    }
}