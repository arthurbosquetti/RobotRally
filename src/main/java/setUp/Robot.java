package setUp;

import setUp.Tiles.Tile;


public class Robot extends Player {
    
    private int x;
    private int y;
    private Direction direction;
    private Tile currentTile;
    private Tile nextTile;
    

    public Robot(String name) {
        super(name, 9);
    }


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

    public void turnLeft() {
        this.direction.turnLeft();
    }

    public void turnRight() {
        this.direction.turnRight();
    }

    public void move() {
        if (nextTile.validTile()) {
            this.currentTile = nextTile;
            this.currentTile.hit(this);
        } 
        
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
            this.setLives(this.getLives() - dmg);
        }
    }

    

}
