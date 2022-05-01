package model.tiles;

import model.AI;
import model.Robot;
import view.TileType;

public class EmptyTile implements Tile {

	private TileType type;
	private boolean valid;
	private Robot robotOn;
	
	public EmptyTile() {
		this.setValid(true);
		this.setType(TileType.EMPTY);
	}

	@Override
	public void setRobotOn(Robot robot) {
		if (robot instanceof AI) {
			robotOn = (AI) robot;
		}
		else {
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
		this.valid = newValid;
	}

	@Override
	public void setType(TileType newType) {
		this.type = newType;
	}

	@Override
	public String getType() {
		return this.type.getPictureFile();
	}
}
