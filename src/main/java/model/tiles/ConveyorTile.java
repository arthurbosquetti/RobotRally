package model.tiles;

import controller.Game;
import model.Board;
import model.Card;
import model.Direction;
import model.Robot;
import view.BoardScreen;
import view.TileType;

public class ConveyorTile extends Tile {

    Direction direction;

    public ConveyorTile(Direction dir) {
    	this.setValid(true);
		this.setType(TileType.CONVEYOR);
    	direction = dir;
    }
    
    //public ConveyorTile() {
    //	this.setValid(true);
	//	this.setType(TileType.CONVEYOR);
    //    this.direction = new Direction(0);
    //}
    
    public Direction getDir() {
    	return this.direction;
    }
    
    @Override
    public String tileType() {
        return " |C|";
    }

    @Override
    public void steppedOn(Robot robot, Board board, Game game) { //assuming this is never on an edge
    	int x = robot.getX();
    	int y = robot.getY();
    	
    	int w = BoardScreen.size;

    	if (this.direction.getDirection() == "north" && y>0) {
    		robot.setY(y-1);
    		robot.setDir(this.direction);
    	}
    	else if (this.direction.getDirection() == "north" && y==0) {
    		robot.setDir(this.direction);
    	}
    	else if (this.direction.getDirection() == "south" && y<w-1) {
    		robot.setY(y+1);
    		robot.setDir(this.direction);
    	}
    	else if (this.direction.getDirection() == "south" && y==w-1) {
    		robot.setDir(this.direction);
    	}
    	else if (this.direction.getDirection() == "west" && x>0) {
    		robot.setX(x-1);
    		robot.setDir(this.direction);
    	}
    	else if (this.direction.getDirection() == "west" && x==0) {
    		robot.setDir(this.direction);
    	}
    	else if (this.direction.getDirection() == "east" && x<w-1) {
    		robot.setX(x+1);
    		robot.setDir(this.direction);
    	}
    	else if (this.direction.getDirection() == "east" && x==w-1) {
    		robot.setDir(this.direction);
    	}
    
    	
    	//switch (this.direction.getDirection()) {
		//case "north":
		//	robot.setY(y-1);
		//	robot.setX(x);
		//	robot.nextTile(board.getTile(x, y-1));
		//case "east":
		//	robot.setX(x+1);
		//	robot.setY(y);
		//	robot.nextTile(board.getTile(x+1, y));
		//case "south":
		//	robot.setY(y+1);
		//	robot.setX(x);
		//	robot.nextTile(board.getTile(x, y+1));
		//case "west":
		//	robot.setX(x-1);
		//	robot.setY(y);
		//	robot.nextTile(board.getTile(x-1, y));
    	//}
    }
}
