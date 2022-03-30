package setUp;

import setUp.Tiles.Tile;
import setUp.Direction;

public class Robot extends Player {
    
    private int x;
    private int y;
    private int spawnX;
    private int spawnY;
    private Direction direction;
    private Tile currentTile;
    private Tile nextTile;
    
    public Robot(String name) {
<<<<<<< HEAD
    	super(name);
=======
        super(name, 9);
        //TODO: change these based on board generation
        this.direction = new Direction(0);
        this.spawnX = 2;
        this.spawnY = 2;
>>>>>>> branch 'md' of https://github.com/arthurbosquetti/RobotRally.git
    }

    //Getters and Setters
    public int getX() {
        return this.x;
    }
    public void setX(int newX) {
        this.x = newX;
    }

    public int getY() {
        return this.y;
    }
    public void setY(int newY) {
        this.y = newY;
    }
    
    public int[] getSpawn() {
    	return new int[] {spawnX, spawnY};
    }
    
    public Direction getDir() {
    	return direction;
    }
    
    public Tile getTile() {
        return currentTile;
    }
    public void nextTile(Tile newTile) {
        this.nextTile = newTile;
    }
    
    //moves the Robot to nextTile then interacts
    public void move() {
    	this.currentTile = nextTile;
        this.currentTile.hit(this);
    }
    
    public void hurt(int dmg) {
        if (this.getLives() - dmg <= 0) {
            //Code to kill the robot
            this.setLives(0);
            this.setLivingStatus(false);
        } else {
        	//TODO: make sure tiles stay consistent with board
        	int[] spawnpoint = this.getSpawn();
        	this.setX(spawnpoint[0]);
        	this.setY(spawnpoint[1]);
            this.setLives(this.getLives() - dmg);
        }
    }
    
    public int[] getNewPoint(boolean forward, int steps) {
		switch (direction.getDirection()) {
			case "north":
				return (forward)? new int[]{x, y -= steps} : new int[]{x, y += steps};
			case "east":
				return (forward)? new int[]{x += steps, y} : new int[]{x -= steps, y};
				
			case "south":
				return (forward)? new int[]{x, y += steps} : new int[]{x, y -= steps};
				
			case "west":
				return (forward)? new int[]{x -= steps, y} : new int[]{x += steps, y};
				
			default:
				return new int[]{x, y};	
		}
	}
    

}
