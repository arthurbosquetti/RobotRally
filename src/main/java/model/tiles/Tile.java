package model.tiles;


import view.TileType;

import controller.Game;
import model.AI;
import model.Board;
import model.Robot;

public abstract class Tile {	
	private boolean valid;
	private TileType type; 
	private Robot robotOn;

	public abstract String tileType();
	public abstract void steppedOn(Robot robot, Board board, Game game);

	@Override
	public String toString() {
		return " " + this.tileType() + " ";
	}

	public void setRobotOn(Robot robot) {
		if (robot instanceof AI) {
			robotOn = (AI) robot;
		}
		else {
			robotOn = robot;

		}
	}
	public void setRobotOff() {
		robotOn = null;
	}
	public Robot getRobotOn() {
		return robotOn;
	}
	
	public boolean validTile() {
		return valid;
	}	
	public void setValid(boolean newValid) {
		this.valid = newValid;
	}
	
	public void setType(TileType newType) {
		this.type = newType;
	}
	public String getType() {
		return this.type.getPictureFile();
	}
}
