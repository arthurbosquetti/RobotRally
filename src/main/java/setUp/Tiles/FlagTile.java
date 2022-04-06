package setUp.Tiles;

import setUp.Robot;

public class FlagTile extends Tile {

    private int flagNum;

    public FlagTile(int flagNum) {
        this.flagNum = flagNum;
    }

    @Override
    public String tileType() {
        return " |>" + flagNum;
    }

    @Override
    public void steppedOn(Robot robot) {
        if (flagNum == 1) {
            robot.setFlag1(true);
        } else if (flagNum == 2 && robot.getFlag1()) {
            robot.setFlag2(true);
        }
    }

//    public FlagTile(int num) {
//        super(TileType.FLAG, true);
//        this.flagNum = num;
//    }
//
//    //this code is mid, will change later
//    public void hit(Robot robot) {
//    	if (flagNum == 1 ) {
//            robot.setFlag1(true);
//        } else if (flagNum == 2 && robot.getFlag1()) {
//            robot.setFlag2(true);
//        }
//    }
//
//    public void setFlagNum(int num) {
//        this.flagNum = num;
//    }
//    public int getFlagNum() {
//        return flagNum;
//    }

}
