package model.tiles;

import model.Robot;
import view.TileType;

public interface Tile {

	void setRobotOn(Robot robot);

	void setRobotOff() ;

	Robot getRobotOn() ;

	boolean validTile();

	void setValid(boolean newValid);

	void setType(TileType newType);

	String getType();
}
