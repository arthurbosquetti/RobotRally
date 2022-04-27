package model;

public class Direction {

    private int direction;
    private boolean rotatedLeft;
    private boolean rotatedRight;

    public Direction(int dir) {
        this.direction = dir;
    }
    
    public int dirToInt() {
    	return this.direction;
    }

    public void turnRight() {
    	System.out.println("I turned right");
    	this.rotatedRight = true;
    	direction = (direction + 90) % 360;
    }

    public void turnLeft() {
    	System.out.println("I turned left");
    	this.rotatedLeft = true;
    	if (direction == 0) {
    		direction = 270;
    	}
    	else {
    		direction = (direction - 90);
    	}
    }
    
    public int getDirectionInt() {
    	return direction;
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
    
    public String toString() {
    	return this.getDirection();
    }

    public boolean getRotatedRight() {
    	return rotatedRight;
    }
    public boolean getRotatedLeft() {
    	return rotatedLeft;
    }
}