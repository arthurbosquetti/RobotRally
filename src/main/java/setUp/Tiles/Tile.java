package setUp.Tiles;


import setUp.Board;
import setUp.Game;
import setUp.Robot;

import java.awt.image.BufferedImage;

public abstract class Tile {
	private boolean valid;
	private BufferedImage image;
	private Robot robotOn;


	public abstract String tileType();
	public abstract void steppedOn(Robot robot, Board board, Game game);

	@Override
	public String toString() {
		return " " + this.tileType() + " ";
	}

	public void setRobotOn(Robot robot) {
		robotOn = robot;
	}
	public void setRobotOff() {
		robotOn = null;
	}
	
	public boolean validTile() {
		return valid;
	}	
	public void setValid(boolean newValid) {
		this.valid = newValid;
	}
}
