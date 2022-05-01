package model.tiles;

import controller.Game;
import model.AI;
import model.Board;
import model.Robot;
import view.TileType;

public class TeleportTile implements InteractsWithTile { //always teleports you to middle of board

	private boolean valid;
	private TileType type;
	private Robot robotOn;

	public TeleportTile() {
		this.setValid(true);
		this.setType(TileType.PORTAL);
	}
    
    public int[] findOtherTeleportTile(Robot robot, Board board) {
    	int[] otherTile = new int[2];
    	int x = robot.getX(); int y = robot.getY();
    	int [][] tiles = board.searchBoard();
    	if (tiles[0][0] == y && tiles[0][1] == x) { 
    		otherTile[0] = tiles[1][0];
    		otherTile[1] = tiles[1][1];
    	}
    	else {
    		otherTile[0] = tiles[0][0];
    		otherTile[1] = tiles[0][1];
    	}
    	return otherTile;
    }
    
    @Override
	public void steppedOn(Robot robot, Board board, Game game) {
    	
      int[] other = findOtherTeleportTile(robot, board);
  	  robot.setX(other[1]);
  	  robot.setY(other[0]);
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
	public boolean alreadyOccupied() {
		return getRobotOn() != null;
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
