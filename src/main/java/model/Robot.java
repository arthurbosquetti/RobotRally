package model;

import controller.Game;
import model.Direction;
import model.tiles.Tile;

public class Robot extends Player {
    
    private int x;
    private int y;
    private int spawnX;
    private int spawnY;
    private Direction direction;
    private Tile currentTile;
    private Tile nextTile;
    private boolean canMove;
    private Board board;
    private Game game;
    private int num;
    //private boolean glue;
    
    public Robot(String name, int lives, Game game) {
        super(name, lives);
        this.direction = new Direction(0);
        this.game = game;
        canMove = true;
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
    
    public void setNum(int newNum) {
        this.num = newNum;
    }
    public int getNum() {
        return num;
    }

    public int[] getSpawn() {
    	return new int[] {spawnX, spawnY};
    }
    public void setSpawn(int[] newSpawn) {
    	spawnX = newSpawn[0];
    	spawnY = newSpawn[1];
    }
    
    public void setDir(Direction direction) {
		this.direction = direction;
	}
    
    public Direction getDir() {
    	return this.direction;
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
        this.currentTile.steppedOn(this, board, game); 
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
        	this.setDir(new Direction(0));
            this.setLives(this.getLives() - dmg);
            this.setCanMove(false);
        }
    }
    
    public int[] getNewPoint(boolean forward, int steps) {
		switch (direction.getDirection()) {
			case "north":
				return (forward)? new int[]{x, y - 1} : new int[]{x, y + 1};
			case "east":
				return (forward)? new int[]{x + 1, y} : new int[]{x - 1, y};
				
			case "south":
				return (forward)? new int[]{x, y + 1} : new int[]{x, y - 1};
				
			case "west":
				return (forward)? new int[]{x - 1, y} : new int[]{x + 1, y};
				
			default:
				return new int[]{x, y};	
		}
	}

    public boolean canMove() {
    	return canMove;
    }
	public void setCanMove(boolean moveable) {
		this.canMove = moveable;
	}
    

}
