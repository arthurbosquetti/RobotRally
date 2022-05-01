package model.tiles;

import controller.Game;
import model.AI;
import model.Board;
import model.Robot;
import view.TileType;
public class PitTile implements InteractsWithTile {

    private boolean valid;
    private TileType type;
    private Robot robotOn;
    
    public PitTile() {
        this.setValid(true);
		this.setType(TileType.PIT);
    }

    public void steppedOn(Robot robot, Board board, Game game) {
       robot.hurt(1);
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