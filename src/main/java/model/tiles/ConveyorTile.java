package model.tiles;

import controller.Game;
import model.AI;
import model.Board;
import model.Direction;
import model.Robot;
import view.TileType;

public class ConveyorTile implements InteractsWithTile {

    private boolean valid;
    private TileType type;
    private Robot robotOn;
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
    public void steppedOn(Robot robot, Board board, Game game) { //assuming this is never on an edge
    	
    	//robot.setDir(direction);
    	//board.makeMove(robot, true, 1, false);

    }

    @Override
    public void setRobotOn(Robot robot) {
        if (robot instanceof AI) {
            robotOn = (AI) robot;
        } else {
            robotOn = robot;
        }
    }

    @Override
    public void setRobotOff() {
        robotOn = null;
    }

    @Override
    public Robot getRobotOn() {
        return robotOn;
    }

    @Override
    public boolean validTile() {
        return valid;
    }

    @Override
    public void setValid(boolean newValid) {
        valid = newValid;
    }

    @Override
    public void setType(TileType newType) {
        type = newType;
    }

    @Override
    public String getType() {
        return this.type.getPictureFile();
    }
}
