package model.tiles;

import model.AI;
import model.Robot;
import view.TileType;

public class TallTile implements Tile {

    private boolean valid;
    private TileType type;
    private Robot robotOn;

    public TallTile() {
        this.setValid(false);
		this.setType(TileType.TALL);
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
