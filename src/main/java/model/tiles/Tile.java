package model.tiles;


<<<<<<< HEAD
import model.Robot;
import view.TileType;

public interface Tile {

	void setRobotOn(Robot robot);

	void setRobotOff() ;
=======
import view.TileType;

import controller.Game;
import model.AI;
import model.Board;
import model.Robot;
>>>>>>> 549a83ac096c7bc44a8357efd9ebbb1822251ecc

	Robot getRobotOn() ;

	boolean validTile();

	void setValid(boolean newValid);

	void setType(TileType newType);

	String getType();
}
