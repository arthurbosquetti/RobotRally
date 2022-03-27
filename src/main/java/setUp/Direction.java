package setUp;

public class Direction {

    private int direction;

    Direction(int dir) {
        this.direction = dir;
    }

    public void turnLeft() {
        if (direction < 270) {
            direction += 90;
        } else {
            direction = 0;
        }
    }

    public void turnRight() {
        if (direction > 0) {
            direction -= 90;
        } else {
            direction = 270;
        }
    }
    
    public String getDirection() {
    	switch (direction) {
    		case 0:
    			return "north";
    		case 90:
    			return "east";
    		case 180:
    			return "south";
    		case 270:
    			return "west";
    		default:
    			System.out.println("Error in Direction");
    			return "";
    	}
    }

}
