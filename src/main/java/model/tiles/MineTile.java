package model.tiles;

import controller.Game;
import model.AI;
import model.Board;
import model.Robot;
import view.TileType;

public class MineTile implements InteractsWithTile { // now used as kamikaze tile!!!!

	private boolean valid;
	private TileType type;
	private Robot robotOn;

	public MineTile() {
		this.setValid(true);
		this.setType(TileType.MINE);
	}
    
    @Override
	public void steppedOn(Robot robot, Board board, Game game) {
    	int[] otherPlayer = game.findOtherPlayer(robot);
    	int otherX = otherPlayer[0];
    	int otherY = otherPlayer[1];
    	
    	int Y = robot.getY(); int X = robot.getX();
    	
    	robot.hurt(1);
    	if (Math.abs(X-otherX) <= 1 && Math.abs(Y-otherY) <= 1) {
    		game.hurtOtherPlayer(robot);
    	}   	
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
		return type.getPictureFile();
	}
}
