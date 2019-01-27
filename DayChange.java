import java.util.Arrays;

public class DayChange {
    // Amazon OA 2: Day Change
    // days[i] = (days[i - 1] == days[i + 1]) ? 0 : 1;
    // Take days[-1] and days[days.length] as 0
    public int[] solution(int[] days, int n) {
        int length = days.length;
        int[] res = new int[length + 2];
        int pre = res[0];
        for (int i = 1; i <= length; i++) res[i] = days[i - 1];
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= length; j++) {
                int temp = res[j];
                res[j] = pre ^ res[j + 1];
                pre = temp;
            }
        }
        return Arrays.copyOfRange(res, 1, length + 1);
    }
}
