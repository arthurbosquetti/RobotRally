package setUp.Tiles;

import setUp.Robot;

public class FlagTile extends Tile {

    private int flagNum;

    public FlagTile(int flagNum) {
        this.flagNum = flagNum;
        this.setImage("flag"+flagNum+".png");
    }

    @Override
    public String tileType() {
        return " |" + flagNum+"|";
    }

    @Override
    public void steppedOn(Robot robot) {
        if (flagNum == 1) {
            robot.setFlag1(true);
        } else if (flagNum == 2 && robot.getFlag1()) {
            robot.setFlag2(true);
        }
    }

}
