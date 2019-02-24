import java.util.HashSet;
import java.util.Set;

public class Robot_489 {
    interface Robot {
        // Returns true if the cell in front is open and robot moves into the cell.
        // Returns false if the cell in front is blocked and robot stays in the current cell.
        public boolean move();

        // Robot will stay in the same cell after calling turnLeft/turnRight.
        // Each turn will be 90 degrees.
        public void turnLeft();
        public void turnRight();

        // Clean the current cell.
        public void clean();
    }


    // Most voted solution
    public void cleanRoom(Robot robot) {
        // A number can be added to each visited cell
        // use string to identify the class
        Set<String> set = new HashSet<>();
        int cur_dir = 0;   // 0: up, 90: right, 180: down, 270: left
        backtrack(robot, set, 0, 0, 0);
    }

    public void backtrack(Robot robot, Set<String> set, int i,
    			int j, int cur_dir) {
    	String tmp = i + "->" + j;
    	if (set.contains(tmp)) return;

    	robot.clean();
    	set.add(tmp);

    	for(int n = 0; n < 4; n++) {
            if(robot.move()) {
    			switch(cur_dir) {
    				case 0: backtrack(robot, set, i-1, j, cur_dir); break;
    				case 90: backtrack(robot, set, i, j+1, cur_dir); break;
    				case 180: backtrack(robot, set, i+1, j, cur_dir); break;
    				case 270: backtrack(robot, set, i, j-1, cur_dir); break;
    				default: break;
    			}

    			//  go back to the starting position
                //  Two turnLeft() or two turnRight() means reversing current direction
			    robot.turnLeft();
    			robot.turnLeft();
    			robot.move();
    			robot.turnRight();
    			robot.turnRight();

    		}
    		// turn to next direction
    		robot.turnRight();
    		cur_dir += 90;
    		cur_dir %= 360;
    	}
    }
}
