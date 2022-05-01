package model.tiles;


import model.Robot;
import view.TileType;

public interface Tile {
//	private boolean valid;
//	private TileType type;
//	private Robot robotOn;
//	private Direction direction;

	public void setRobotOn(Robot robot);
//		if (robot instanceof AI) {
//			robotOn = (AI) robot;
//		}
//		else {
//			robotOn = robot;

	public void setRobotOff() ;
//		robotOn = null;

	public Robot getRobotOn() ;
//		return robotOn;

	
	public boolean alreadyOccupied();
//		if (this.getRobotOn() != null) {
//			return true;
//		}
//		return false;

	
	public boolean validTile();
//		return valid;

	public void setValid(boolean newValid);
//		this.valid = newValid;

	
	public void setType(TileType newType);
//		this.type = newType;

	public String getType();
//		return this.type.getPictureFile();

}
