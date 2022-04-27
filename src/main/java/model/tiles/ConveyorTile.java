package model.tiles;

import controller.Game;
import model.Board;
import model.Direction;
import model.Robot;
import view.TileType;

public class ConveyorTile extends Tile {

    Direction direction;

    public ConveyorTile(Direction dir) {
    	this.setValid(true);
		this.setType(TileType.CONVEYOR);
    	direction = dir;
    }
    
    public ConveyorTile() {
    	this.setValid(true);
		this.setType(TileType.CONVEYOR);
        this.direction = new Direction(0);
    }
    
    @Override
    public String tileType() {
        return " |C|";
    }

    @Override
    public void steppedOn(Robot robot, Board board, Game game) { //assuming this is never on an edge
    	int x = robot.getX();
    	int y = robot.getY();
    	
    	switch (this.direction.getDirection()) {
		case "north":
			robot.setY(y-1);
		case "east":
			robot.setX(x+1);
		case "south":
			robot.setY(y+1);
		case "west":
			robot.setX(x-1);
    	}
    }
}
