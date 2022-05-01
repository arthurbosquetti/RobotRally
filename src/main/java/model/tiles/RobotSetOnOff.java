package model.tiles;

import model.Robot;

public interface RobotSetOnOff extends Tile  {
	
	void setRobotOn(Robot robot);

	void setRobotOff() ;

	Robot getRobotOn() ;

	

}
