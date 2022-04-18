package setUp.Tiles;

import setUp.Robot;
import setUp.Direction;

public class ConveyorTile extends Tile {

    Direction direction;

    public ConveyorTile(Direction dir) {
    	this.setValid(true);
    	this.setImage("acid.png");
    	direction = dir;
    }
    
    public ConveyorTile() {
    	this.setValid(true);
        this.direction = new Direction(0);
    }
    
    @Override
    public String tileType() {
        return " |C|";
    }

    @Override
    public void steppedOn(Robot robot) {
        //TODO: this
    }
}
