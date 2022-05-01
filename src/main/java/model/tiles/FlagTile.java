package model.tiles;

import controller.Game;
import model.AI;
import model.Board;
import model.Robot;
import view.TileType;

public class FlagTile implements Flags, InteractsWithTile {

    private boolean valid;
    private TileType type;
    private int flagNum;
    private Robot robotOn;

    public FlagTile(int flagNum) {
    	this.setValid(true);
        this.setType((flagNum == 1)? TileType.FLAG1 : TileType.FLAG2);
        this.flagNum = flagNum;

    }

    @Override
    public String toString() {
		return " " + this.tileType() + " ";
    }
    @Override
    public String tileType() {
        return "|F" + flagNum+"|";
    }

    @Override
    public void steppedOn(Robot robot, Board board, Game game) {
        if (flagNum == 1) {
            robot.setFlag1(true);
        } else if (flagNum == 2 && robot.getFlag1()) {
            robot.setFlag2(true);
            robot.setWinner(true);
        }
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
        return this.getRobotOn() != null;
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
