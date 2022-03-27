package setUp;

import setUp.Tiles.Tile;
import setUp.Direction;

public class Robot extends Player {
    
    private int x;
    private int y;
    private Direction direction;
    private Tile currentTile;
    private Tile nextTile;
    

    public Robot(String name) {
        super(name, 9);
        //TODO: change this to change based on board generation
        this.direction = new Direction(0);
    }

    //Getters and Setters for X and Y
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
    
    public Direction getDir() {
    	return direction;
    }
    
    //moves the Robot to nextTile then interacts
    public void move() {
    	this.currentTile = nextTile;
        this.currentTile.hit(this);
        
    }

    public Tile getTile() {
        return currentTile;
    }
    public void nextTile(Tile newTile) {
        this.nextTile = newTile;
    }
    
    public void hurt(int dmg) {
        if (this.getLives() - dmg <= 0) {
            //Code to kill the robot
            this.setLives(0);
            this.setLivingStatus(false);
        } else {
        	//TODO: add code to respawn Robot
            this.setLives(this.getLives() - dmg);
        }
    }

    

}
