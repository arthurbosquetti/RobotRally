package model.tiles;

import controller.Game;
import model.Board;
import model.Robot;
import view.TileType;

public class FlagTile extends Tile {

    private int flagNum;

    public FlagTile(int flagNum) {
        this.flagNum = flagNum;
        this.setType((flagNum == 1)? TileType.FLAG1 : TileType.FLAG2);

    }

    @Override
    public String tileType() {
        return " |" + flagNum+"|";
    }

    @Override
    public void steppedOn(Robot robot, Board board, Game game) {
        if (flagNum == 1) {
            robot.setFlag1(true);
        } else if (flagNum == 2 && robot.getFlag1()) {
            robot.setFlag2(true);
        }
    }

}
