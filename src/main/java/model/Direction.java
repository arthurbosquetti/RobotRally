package model;

public class Direction {

    private int direction;

    public Direction(int dir) {
        this.direction = dir;
    }
    
    public int dirToInt() {
    	return this.direction;
    }

    //moves 90 degrees to the right
    public void turnRight() {
    	direction = (direction + 90) % 360;
    }

    //moves 90 degrees to the left
    public void turnLeft() {
    	direction = (direction - 90) % 360;
    	if (direction==-90) {direction = 270;}
    }
    
    public int getDirectionInt() {
    	return direction;
    }
    
    //returns direction in string form based on NSEW
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
    	}
    	return null;
    }
    
    

}


