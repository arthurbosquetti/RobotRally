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
    
    public Direction getDir() {
    	return this.direction;
    }
    
    @Override
    public String tileType() {
        return " |C|";
    }

    @Override
    public void steppedOn(Robot robot, Board board, Game game) { //assuming this is never on an edge
    	
    	robot.setDir(direction);
    	board.makeMove(robot, true, 1, false);

    }
}
