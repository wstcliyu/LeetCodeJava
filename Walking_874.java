import java.awt.*;
import java.util.HashSet;
import java.util.Set;

public class Walking_874 {

    public static int robotSim(int[] commands, int[][] obstacles) {
        int[] dx = {0,1,0,-1};
        int[] dy = {1,0,-1,0};
        int x = 0, y = 0, di = 0, res = 0;
        // HashSet<Point> obs = new HashSet<>();
        HashSet<Long> obs = new HashSet<>();
        for (int[] obstacle : obstacles) {
            // obs.add(new Point(obstacle[0], obstacle[1]));
            long ox = (long)obstacle[0] + 30000;
            long oy = (long)obstacle[1] + 30000;
            obs.add((ox << 16) + oy);
            // Must use (ox << 16) + oy, the parentheses cannot be omitted
        }

        for (int cmd : commands) {
            if (cmd == -2)
                di = (di + 3) % 4;
            else if (cmd == -1)
                di = (di + 1) % 4;
            else {
                for (int k = 0; k < cmd; k++) {
                    int nx = x + dx[di];
                    int ny = y + dy[di];
                    // Must not ignore the parenthesis between 16 and +
                    long code = (((long)nx + 30000) << 16) + ((long)ny + 30000);
                    // if (obs.contains(new Point(nx, ny)))
                    if (obs.contains(code))
                        break;
                    else {
                        x = nx;
                        y = ny;
                        res = Math.max(res, x * x + y * y);
                    }
                }
            }
        }
        return res;
    }


    /*
    public static int robotSim(int[] commands, int[][] obstacles) {
        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new int[]{1, 0, -1, 0};
        int x = 0, y = 0, di = 0;

        // Encode obstacles (x, y) as (x+30000) * (2^16) + (y+30000)
        Set<Long> obstacleSet = new HashSet();
        for (int[] obstacle: obstacles) {
            long ox = (long) obstacle[0] + 30000;
            long oy = (long) obstacle[1] + 30000;
            obstacleSet.add((ox << 16) + oy);
        }

        int ans = 0;
        for (int cmd: commands) {
            if (cmd == -2)  //left
                di = (di + 3) % 4;
            else if (cmd == -1)  //right
                di = (di + 1) % 4;
            else {
                for (int k = 0; k < cmd; ++k) {
                    int nx = x + dx[di];
                    int ny = y + dy[di];
                    long code = (((long) nx + 30000) << 16) + ((long) ny + 30000);
                    if (!obstacleSet.contains(code)) {
                        x = nx;
                        y = ny;
                        ans = Math.max(ans, x*x + y*y);
                    }
                }
            }
        }

        return ans;
    }
    */
    public static void main(String[] args) {
        int[] testCmds = {4,-1,4,-2,4};
        int[][] testObs = {{2,4}};
        System.out.println(robotSim(testCmds, testObs));
    }
}
